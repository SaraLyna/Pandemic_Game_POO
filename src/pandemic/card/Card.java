//TODO


package pandemic.card;
import pandemic.Disease;
import pandemic.Game;
import pandemic.City;

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
	
	
	
	/**
	 * this method doesn't do anything
	 */
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

	    return this.getName().equals(otherCard.getName())
	            && this.disease.equals(otherCard.disease);
	}
	
	
	


	
	
}