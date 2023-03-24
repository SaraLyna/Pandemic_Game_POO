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
	public PlayersCards(Cities city,String disease) {
		super(city,disease);
	}
	
	/**
	 *Returns a string representation of the object.
	 */
	public String toString() {
		return "A player card for the city "+city+" and the disease "+disease;
	}
}
