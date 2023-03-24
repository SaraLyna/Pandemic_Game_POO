package pandemic;

/**
 * this class represent the EpidemicCards
 *
 */
public class EpidemicCards extends Cards {
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
		return "EpidemicCards for the city named"+cityName+" and the disease "+disease;
		
	}

}
