package pandemic;

public class PlayersCards extends Cards{
	/**
	 * constructor of the class PlayersCards
	 * @param city
	 * @param disease
	 */
	public PlayersCards(String cityName,String disease) {
		super(cityName,disease);
	}
	
	
	/**
	 *Returns a string representation of the object.
	 */
	public String toString() {
		return  " has a player card for the city named "+ cityName +" and the disease "+ disease;
	}

	/**
	 * @return the name of the city on the card
	 */
	
	public String getCityName() {
		return super.getCityName();
	}
	
	/**
	 * @return the name of the disease on the card
	 */
	
	public String getDiseaseName() {
		return super.getDiseaseName();
	}
	
	
}
