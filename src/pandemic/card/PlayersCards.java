//TODO

package pandemic.card;
import pandemic.Disease;
import pandemic.Game;

/**
 * this class represents the players cards
 *
 */
public class PlayersCards extends Card{
	
	protected String cityName;
	protected Disease disease;
	/**
	 * constructor of the class PlayersCards
	 * @param city
	 * @param disease
	 */
	public PlayersCards(String cityName,Disease disease,Game game) {
		super(game);
		this.cityName=cityName;
		this.disease=disease;
		
	}
	
	
	/**
	 *@return a string representation of the object.
	 */
	public String toString() {
		return  " has a player card for the city named "+ cityName +" and the disease "+ disease;
	}
	

	/**
	 * @return the name of the city on the card
	 */
	public String getCityName() {
		return this.cityName;
	}
	
	
	/**
	 * @return the name of the disease on the card
	 */
	public String getDiseaseName() {
		return this.getDiseaseName();
	}
	
	/**
	 * @return the name of the disease
	 */
	public String toStringDiseaseName() {
		return (this.disease.toString());
	}
	
	
}
