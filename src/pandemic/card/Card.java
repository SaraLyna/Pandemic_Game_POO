//TODO


package pandemic.card;
import pandemic.Disease;
import pandemic.Game;

public abstract class Card {
	protected Game game;
	
	/**
	 * constructor of the class Cards
	 * @param city
	 * @param disease
	 */
	public Card(Game game) {
		this.game = game;
	}
	
	
	//TODO DOCU
	public void sideEffectWhenDrawn() {
		//does nothing
	}
	
	@Override
	public boolean equals(Object o) {
	    if (o == this) {
	        return true;
	    }

	    if (!(o instanceof Card)) {
	        return false;
	    }

	    Card otherCard = (Card) o;

	    return this.cityName.equals(otherCard.cityName)
	            && this.disease.equals(otherCard.disease);
	}
	
	
	


	
	
}