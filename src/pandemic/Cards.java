package pandemic;

public  abstract class Cards {
	protected Cities city;
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
	public String getDiseaseName() {
		return this.city.getName();
	}
}