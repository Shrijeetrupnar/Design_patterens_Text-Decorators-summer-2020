package textdecorators.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * MostFrequentWordDecorator class 
 * This class  does Frequent word decoration
 * @author Shrijeet Rupnar
 * @version 1.0.
 * @since   08-08-2020
 */
public class MostFrequentWordDecorator extends AbstractTextDecorator {

	private AbstractTextDecorator atd;
	private InputDetails id;
	private Map<String,Integer> mostfrequentWord=null;


	/**
	 * MostFrequentWordDecorator is parameterized constructor 
	 * @param keywordDecorator,InputDetails
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	public MostFrequentWordDecorator(AbstractTextDecorator keywordDecorator, InputDetails idIn) {
		atd = keywordDecorator;
		id = idIn;

		mostfrequentWord= new LinkedHashMap<String, Integer>();
	}



	/**
	 * processInputDetails method 
	 * This method take each sentence and finds most frequent word
	 * and perform Decoration 
	 * @param no
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	@Override
	public void processInputDetails() {
		// Decorate input details.

		List<String> sentences=	id.retrive(); 


		for(String sentencesList: sentences) {

			String[] words= sentencesList.split(" ");

			for(String wd: words) {

				mostfrequentWord.put(wd.toLowerCase(), mostfrequentWord.getOrDefault(wd, 0)+1);

			}
		}


		Map.Entry<String,Integer> mostFrequentWordResult = null;

		for (Map.Entry<String,Integer> entry : mostfrequentWord.entrySet())
		{
			if (mostFrequentWordResult == null || entry.getValue().compareTo(mostFrequentWordResult.getValue()) > 0)
			{
				mostFrequentWordResult = entry;
				break;
			}
		}


		for(String sentencesList: sentences) {
			String result="";
			String[] words= sentencesList.split(" ");

			for(String wd: words) {

				if(wd.toLowerCase().matches(mostFrequentWordResult.getKey())) {

					result+="MOST_FREQUENT_" +wd+"_MOST_FREQUENT"+" ";

				}
				else {
					result=result+wd+" ";
				}
			}

			id.update(result);
		}

		id.store();

		// Forward to the next decorator, if any.
		if (null != atd) {
			atd.processInputDetails();
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
