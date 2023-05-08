package pandemic.card;
import pandemic.Disease;

public abstract class Card {
	protected String cityName;
	protected Disease disease;
	
	/**
	 * constructor of the class Cards
	 * @param city
	 * @param disease
	 */
	public Card(String cityName, Disease disease) {
		this.cityName=cityName;
		this.disease=disease;
	}
	
	
	/**
	 * @return the name of the disease
	 */
	public String getDiseaseName() {
		return (this.disease.toString());
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

	    if (!(o instanceof Card)) {
	        return false;
	    }

	    Card otherCard = (Card) o;

	    return this.cityName.equals(otherCard.cityName)
	            && this.disease.equals(otherCard.disease);
	}
	
	
	


	
	
}