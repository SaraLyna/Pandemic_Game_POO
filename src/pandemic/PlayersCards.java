package pandemic;


/**
 * 
 *
 */
public class PlayersCards extends Cards{
	/**
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
		return "A player card for the city named "+ cityName +" and the disease "+ disease;
	}

	
	
}
