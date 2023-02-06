package pandemic;

/**
 * @author saralyna.ouyahia.etu
 *
 */
public class PlayersCards extends Cards{
	public PlayersCards(String city,String disease) {
		super(city,disease);
	}
	/**
	 * @return
	 */
	public String tostring() {
		return "A player card for the city "+city+" and the disease "+disease;
	}
}
