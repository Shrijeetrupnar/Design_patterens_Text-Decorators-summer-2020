package textdecorators.driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;

import textdecorators.util.AbstractTextDecorator;
import textdecorators.util.InputDetails;
import textdecorators.util.KeywordDecorator;
import textdecorators.util.MostFrequentWordDecorator;
import textdecorators.util.SentenceDecorator;
import textdecorators.util.SpellCheckDecorator;


/**
 * Driver class 
 * The Driver program implements the application,
 * It reads input, creates different Decorators, and display result
 * perform the write to output file and console write operation.
 * @author Shrijeet Rupnar
 * @version 1.0.
 * @since   08-08-2020
 */
public class Driver {


	/**
	 * This is the main method which accepts input file 
	 * process the input,creates different Decorators, and display result
	 * it also prints to output file
	 * perform the write to output file and console write operation
	 * @param args Accepts command line arguments as array of strings
	 * @return void. Since it is main method
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub





		if ((args.length != 5) || args[0].equals("${input}") || args[1].equals("${misspelled}") ||args[2].equals("${keywords}") ||args[3].equals("${output}") ||args[4].equals("${debug}")) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 5 arguments.");
			System.exit(0);
		}


		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("--------------------------- Design Patterns -------------------------------------------------");
		System.out.println("--------------------- Assignment-5 - Summer - 2020 ------------------------------------------");
		System.out.println("-------------------------- Text Decorators-----------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------\n");


		String inputFilePath= args[0];
		String misspelledFilePath=args[1];
		String keywordsFilePath=args[2];
		String outputFilePath=args[3];
		int debugLevel=Integer.parseInt(args[4]);

		try {

			File fileInput = new File(args[0]);
			File filemisspelled = new File(args[1]);
			File fileKeyword = new File(args[2]);

			if(!new File(args[0]).exists() || !new File(args[1]).exists() 
					|| !new File(args[2]).exists()) {
				throw new FileNotFoundException("Exception: input file not found!!");
			}

			if(fileInput==null || filemisspelled==null || fileKeyword==null )
				throw new NullPointerException("Exception:Null pointer...!!");

			if((args[0]!=null && !"".equals(args[0]) && fileInput.length()!=0) && (args[1]!=null && !"".equals(args[1]) && filemisspelled.length()!=0) && (args[2]!=null && !"".equals(args[2]) && fileKeyword.length()!=0) ) {

				InputDetails inputD= new InputDetails(inputFilePath,  keywordsFilePath,misspelledFilePath, outputFilePath);
				AbstractTextDecorator sentenceDecorator = new SentenceDecorator(null, inputD);
				AbstractTextDecorator spellCheckDecorator = new SpellCheckDecorator(sentenceDecorator, inputD);
				AbstractTextDecorator keywordDecorator = new KeywordDecorator(spellCheckDecorator, inputD);
				AbstractTextDecorator mostFreqWordDecorator = new MostFrequentWordDecorator(keywordDecorator, inputD);


				mostFreqWordDecorator.processInputDetails();

				inputD.display();
				inputD.writeToFile();
			}
			else{

				System.out.println("Invalid input file");
				System.exit(0);

			}

		}
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			System.out.println("Exiting...");
			System.exit(0);

		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			System.out.println("\nPlease check Input File...");
			System.out.println("Exiting...");
			System.err.println(e.getMessage());
			System.exit(0);

		} 
		catch(SecurityException e)
		{
			System.out.println(e.getMessage());
			System.out.println("\n Not valid Input file...");
			System.exit(0);
		}
		catch (InvalidPathException e)
		{
			// TODO Auto-generated catch block
			System.out.println("\nPlease check Input File...");
			System.out.println("Exiting...");
			System.err.println(e.getMessage());
			System.exit(0);

		}

		catch(Exception e)// Any other exceptions
		{
			System.err.println(e.getMessage());
			System.out.println("\nException...");
			System.exit(0);
		}


		finally {
			
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Thank you ....");
			System.out.println("Exiting....");
			System.out.println("------------------------------- End of Application ------------------------------------------");

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
