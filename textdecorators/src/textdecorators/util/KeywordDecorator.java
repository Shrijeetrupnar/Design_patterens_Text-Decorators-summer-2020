package textdecorators.util;

import java.util.List;


/**
 * KeywordDecorator class 
 * This class  does Keyword decoration
 * @author Shrijeet Rupnar
 * @version 1.0.
 * @since   08-08-2020
 */
public class KeywordDecorator extends AbstractTextDecorator {

	private AbstractTextDecorator atd;
	private InputDetails id;


	/**
	 * SpellCheckDecorator is parameterized constructor 
	 * @param spellCheckDecorator,InputDetails
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	public KeywordDecorator(AbstractTextDecorator spellCheckDecorator, InputDetails idIn) {
		// TODO Auto-generated constructor stub

		atd = spellCheckDecorator;
		id = idIn;
	}



	/**
	 * processInputDetails method 
	 * This method take each sentence and each word from keyword files
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
			List<String> key=	id.getKeywords(); 
			String sentencesList=sentences.get(i);
			String nextSen=sentencesList.toLowerCase();

			for(String keyword: key) {
				int len=0;

				if((len=(nextSen.indexOf(keyword)))>0) {
					String firstPart=	sentencesList.substring(0, len-1);
					String middlePart= "KEYWORD_"+keyword+"_KEYWORD";
					String endPart= sentencesList.substring(len+keyword.length(), sentencesList.length()-1);

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
