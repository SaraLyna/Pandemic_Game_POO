package pandemic;


public abstract class Cards {
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
	
	
	/**
	 * @return the name of the disease
	 */
	public String getDiseaseName() {
		return this.disease;
	}
	
	
	/**
	 * @return the name of the city
	 */
	public String getCityName() {
		return this.cityName;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (o == this) {
	        return true;
	    }

	    if (!(o instanceof Cards)) {
	        return false;
	    }

	    Cards otherCard = (Cards) o;

	    return this.cityName.equals(otherCard.cityName)
	            && this.disease.equals(otherCard.disease);
	}
	
	
	


	
	
}