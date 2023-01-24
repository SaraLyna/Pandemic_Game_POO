package pandemic;

public class EpidemicCards extends Cards {
	public EpidemicCards(String city,String disease){
		super(city,disease);
	}
	public String tostring(){
		return "EpidemicCards for the city "+city+" and the disease "+disease;
		
	}

}
