package textdecorators.util;

import java.util.List;


/**
 * SentenceDecorator class 
 * This class  does sentence decoration
 * @author Shrijeet Rupnar
 * @version 1.0.
 * @since   08-08-2020
 */
public class SentenceDecorator extends AbstractTextDecorator {

	private AbstractTextDecorator atd;
	private InputDetails id;


	/**
	 * SentenceDecorator is parameterized constructor 
	 * @param null,InputDetails
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	public SentenceDecorator(AbstractTextDecorator atdIn, InputDetails idIn) {
		atd = atdIn;
		id = idIn;
	}



	/**
	 * processInputDetails method 
	 * This method take each sentence and performs decoration
	 * @param no
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   08-08-2020
	 */
	@Override
	public void processInputDetails() {
		// Decorate input details.


		List<String> sentences=	id.getSentences(); 

		for(int i=0;i<sentences.size();i++){

			String sentencesList=sentences.get(i);

			sentencesList="BEGIN_SENTENCE__"+sentencesList+"__END_SENTENCE";

			sentences.set(i, sentencesList);

		}

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
