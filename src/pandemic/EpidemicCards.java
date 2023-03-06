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
	public EpidemicCards(String city,String disease){
		super(city,disease);
	}
	
	/**
	 *Returns a string representation of the object.
	 */
	public String toString(){
		return "EpidemicCards for the city "+city+" and the disease "+disease;
		
	}

}
