package pandemic;

/**
 * this class represent the EpidemicCards
 *
 */
public class EpidemicCards extends PlayersCards {
	/**
	 * constructor of the class EpidemicCards
	 * @param city
	 * @param disease
	 */
	public EpidemicCards(String cityName,String disease){
		super(cityName,disease);
	}
	
	/**
	 *Returns a string representation of the object.
	 */
	public String toString(){
		return "A card Epidemic for the city named "+ cityName ;
		
	}
	
	/**
	 * @return the name of the city on the card
	 */
	
	public String getCityName() {
		return super.getCityName();
	}
	

}
