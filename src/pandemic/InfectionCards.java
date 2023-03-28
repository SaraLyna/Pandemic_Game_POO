package pandemic;

/**
 * this class represent the InfectionCards
 *
 */
public class InfectionCards extends Cards {
	
	/**
	 * constructor of the class InfectionCards
	 * @param cityName
	 * @param disease
	 */
	public InfectionCards(String cityName,String disease){
		super(cityName,disease);
	}
	
	
	/**
	 *Returns a string representation of the object.
	 */
	public String toString(){
		return " A card Infection for the city named "+ cityName +" and the disease "+disease;
		
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