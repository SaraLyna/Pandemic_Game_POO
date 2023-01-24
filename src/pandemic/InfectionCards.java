package pandemic;

public class InfectionCards extends Cards {
	public InfectionCards(String city,String disease){
		super(city,disease);
	}
	public String tostring(){
		return "InfectionCards for the city "+city+" and the disease "+disease;
		
	}
}