package textdecorators.util;

import java.util.List;

/**
 * SpellCheckDecorator class 
 * This class does spellcheck
 * @author Shrijeet Rupnar
 * @version 1.0.
 * @since   08-08-2020
 */
public class SpellCheckDecorator extends AbstractTextDecorator {


	private AbstractTextDecorator atd;
	private InputDetails id;


	/**
	 * SpellCheckDecorator is parameterized constructor 
	 * This class has does spellcheck
	 * @param sentenceDecorator,InputDetails
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	public SpellCheckDecorator(AbstractTextDecorator sentenceDecorator, InputDetails inputD) {
		// TODO Auto-generated constructor stub

		atd = sentenceDecorator;
		id = inputD;
	}



	/**
	 * processInputDetails method 
	 * This method take each sentence and each word from mis spelled files
	 * and perform Decoration 
	 * @param no
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	@Override
	public void processInputDetails() {
		// TODO Auto-generated method stub


		List<String> sentences=	id.getSentences(); 

		for(int i=0;i<sentences.size();i++){
			String result="";
			List<String> key=	id.getMisspelledWords(); 
			String sentencesList=sentences.get(i);
			String nextSen=sentencesList.toLowerCase();

			for(String keyword: key) {
				int len=0;

				if((len=(nextSen.indexOf(keyword)))>0) {
					String firstPart=	sentencesList.substring(0, len-1);
					String middlePart= "SPELLCHECK_"+keyword+"_SPELLCHECK";
					String endPart= sentencesList.substring(len+keyword.length()-1, sentencesList.length()-1);

					sentencesList=firstPart+" "+middlePart+" "+endPart;

				}

			}
			sentences.set(i, sentencesList);

		}

		id.setSentences(sentences);


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
