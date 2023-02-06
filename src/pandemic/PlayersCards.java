package pandemic;


public class PlayersCards extends Cards{
	public PlayersCards(String city,String disease) {
		super(city,disease);
	}
	
	public String tostring() {
		return "A player card for the city "+city+" and the disease "+disease;
	}
}
