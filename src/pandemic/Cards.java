package pandemic;

public  abstract class Cards {
	protected String cityName;
	protected String disease;
	
	/**
	 * constructor of the class Cards
	 * @param city
	 * @param disease
	 */
	public Cards(String cityName, String disease) {
		this.cityName=cityName;
		this.disease=disease;

	}
	
	public String getDiseaseName() {
		return this.disease;
	}
}