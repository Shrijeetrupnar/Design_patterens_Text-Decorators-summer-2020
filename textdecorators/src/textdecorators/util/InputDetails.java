package textdecorators.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;


/**
 * InputDetails class 
 * This class has  methods to store,writeToFile and display result.
 * also this class reads all 3 input file and store the input
 * into the List.
 * @author Shrijeet Rupnar
 * @version 1.0.
 * @since   08-08-2020
 */
public class InputDetails implements FileDisplayInterface,StdoutDisplayInterface {


	private List<String> sentences=null;
	private List<String> keywords=null;
	private List<String> misspelledWords=null;
	private List<String> temporaryList= null;
	private String outPutFilePath=null;


	/**
	 * setSentences method 
	 * This is setter method to set Sentences into the List.
	 * @param List of sentences
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	public void setSentences(List<String> sentences) {
		this.sentences = sentences;
	}


	/**
	 * getSentences method 
	 * This is getter method to get Sentences from the List.
	 * @param no
	 * @return List of Sentences
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	public List<String> getSentences() {
		return sentences;
	}

	/**
	 * getKeywords method 
	 * This is getter method to get keywords from the List.
	 * @param no
	 * @return List of keywords
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	public List<String> getKeywords() {
		return keywords;
	}


	/**
	 * getMisspelledWords method 
	 * This is getter method to get misspelled word from the List.
	 * @param no
	 * @return List of missspelled word
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	public List<String> getMisspelledWords() {
		return misspelledWords;
	}


	/**
	 * InputDetails is a parameterized constructor 
	 * This is constructor reads all 3 input file and store the input into List
	 * @param inputFileName,keywords,misspelled,outPutFile
	 * @return nothing
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	public InputDetails(String inputFileNameIn, String keywordsIn, String misspelledIn, String outputFileIn) {
		// TODO Auto-generated constructor stub

		outPutFilePath=outputFileIn;

		try {
			FileProcessor inputFile= new FileProcessor(inputFileNameIn);
			sentences= new ArrayList();
			FileProcessor keyword= new FileProcessor(keywordsIn);
			keywords= new ArrayList();
			FileProcessor misspelled= new FileProcessor(misspelledIn);
			misspelledWords= new ArrayList();
			temporaryList=new ArrayList();
			String line=null;

			do {
				line = inputFile.poll();
				if(line != null) {
					sentences.add(line);
				}
				else {
					//EOF
				}
			} while(line != null);

			String lineOne=null;
			do {
				lineOne = keyword.poll();
				if(lineOne != null) {
					keywords.add(lineOne);
				}
				else {
					//EOF
				}
			} while(lineOne != null);


			String lineTwo=null;
			do {
				lineTwo = misspelled.poll();
				if(lineTwo != null) {
					misspelledWords.add(lineTwo);
				}
				else {
					//EOF
				}
			} while(lineTwo != null);



		} catch (InvalidPathException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in File processing...");
			e.printStackTrace();
			System.exit(0);

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in File processing...");
			e.printStackTrace();
			System.exit(0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in File processing...");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in File processing...");
			e.printStackTrace();
			System.exit(0);
		}

	}


	/**
	 * store method 
	 * This is store content of temporary array in to original array
	 * @param no
	 * @return nothing
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	public void store() {

		sentences=temporaryList;

	}



	/**
	 * retrive method 
	 * This is retrive and return sentence
	 * @param no
	 * @return List of sentences
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	public List retrive() {

		return getSentences();
	}


	/**
	 * retriveKeyword method 
	 * This is  return keywords List
	 * @param no
	 * @return List of keywords
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	public List retriveKeyword() {

		return getKeywords();
	}


	/**
	 * update method 
	 * This is  method update temporary array
	 * @param String sentence
	 * @return no
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	public void update(String result) {

		temporaryList.add(result);

	}

	/**
	 * display method 
	 * This is  method display content on console
	 * @param no
	 * @return no
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	public void display() {

		for(String line: sentences )
			System.out.println(line+".");
	}


	/**
	 * writeToFile method 
	 * This is  method write result in to the file
	 * @param no
	 * @return no
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub

		try {
			File myObj = new File(outPutFilePath);
			myObj.createNewFile();
		}
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			System.out.println("Exiting...");
			System.exit(0);

		}catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.println("Could not create new file");
			System.exit(0);
		}

		try {

			FileWriter myWriter = new FileWriter(outPutFilePath);
			BufferedWriter bw = new BufferedWriter(myWriter);

			for(int i=0;i<sentences.size();i++) {
				bw.write(sentences.get(i).toString()+".");
				bw.write("\n");
			}


			bw.close();


		}//try
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			System.out.println("Exiting...");
			System.exit(0);

		}
		catch(IOException e) {
			System.err.println("Exception: writing to output file");
			System.err.println("Exiting...");
			System.exit(0);
		}


	}

	/**
	 * toString() method
	 * @return String
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "";
	}


}
