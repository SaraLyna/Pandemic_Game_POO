package pandemic;

/**
 * this class represent the InfectionCards
 *
 */
public class InfectionCards extends Cards {
	/**
	 * constructor of the class InfectionCards
	 * @param city
	 * @param disease
	 */
	public InfectionCards(Cities city,String disease){
		super(city,disease);
	}
	
	/**
	 *Returns a string representation of the object.
	 */
	public String toString(){
		return "InfectionCards for the city "+city+" and the disease "+disease;
		
	}
}