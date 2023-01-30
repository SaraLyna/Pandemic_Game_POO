package pandemic;

public abstract class Cards {
	protected String city;
	protected String disease;
	
	/**
	 * constructor of the class Cards
	 * @param city
	 * @param disease
	 */
 public Cards(String city, String disease) {
	 this.city=city;
	 this.disease=disease;
 }
}
