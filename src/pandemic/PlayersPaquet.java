package pandemic;

import java.util.ArrayList;
import java.util.Collections;


/**
 * cette classe représente le paquet des cartes joueurs
 *
 */
public class PlayersPaquet {
	private ArrayList<PlayersCards> cards;
	
	/**
	 * constructor of the class PlayersPaquet
	 */
	public PlayersPaquet() {
		this.cards= new ArrayList<>();
		this.initCards();
	}
    
		/**
		 * all the cards in the package players
		 */
		public void initCards() {
			 String[] colors = {"rouge", "noir", "jaune", "bleu"};
			    String[] redCards = {"ville-19", "ville-23", "ville-24", "ville-25", "ville-29", "ville-30", "ville-31", "ville-35", "ville-36", "ville-37", "ville-42", "ville-48"};
			    String[] blackCards = {"ville-2", "ville-3", "ville-8", "ville-9", "ville-10", "ville-14", "ville-15", "ville-16", "ville-20", "ville-21", "ville-22", "ville-27"};
			    String[] yellowCards = {"ville-1", "ville-5", "ville-6", "ville-7", "ville-12", "ville-13", "ville-17", "ville-18", "ville-38", "ville-43", "ville-44", "ville-47"};
			    String[] blueCards = {"ville-4", "ville-11", "ville-26", "ville-28", "ville-32", "ville-33", "ville-34", "ville-39", "ville-40", "ville-41", "ville-45", "ville-46"};
			    int[] cardCounts = {redCards.length, blackCards.length, yellowCards.length, blueCards.length};
			    for (int colorIndex = 0; colorIndex < colors.length; colorIndex++) {
			        for (int cardIndex = 0; cardIndex < cardCounts[colorIndex]; cardIndex++) {
			            String cardName = "";
			            switch (colorIndex) {
			                case 0:
			                    cardName = redCards[cardIndex];
			                    break;
			                case 1:
			                    cardName = blackCards[cardIndex];
			                    break;
			                case 2:
			                    cardName = yellowCards[cardIndex];
			                    break;
			                case 3:
			                    cardName = blueCards[cardIndex];
			                    break;
			            }
			            this.cards.add(new PlayersCards(cardName, colors[colorIndex]));
			        }
			    }
			    this.cards.add(new EpidemicCards("epidemic", "epidemic"));
			    this.cards.add(new EpidemicCards("epidemic", "epidemic"));
			    this.cards.add(new EpidemicCards("epidemic", "epidemic"));
			    this.cards.add(new EpidemicCards("epidemic", "epidemic"));
			
		}
	
		
	/**
	 * @param card
	 * add a Playerscard 
	 */
	public void addCarte(PlayersCards card) {
	        cards.add(card);
	    }

	    /**
	     * shuffle the cards
	     */
	public void melanger() {
			Collections.shuffle(this.cards);
			
	    }
	

	    /**
	     * @param cartes
	     * @return a card
	     */
	    public PlayersCards tirerCarte() {
	        PlayersCards carte = cards.get(0);
	        cards.remove(0);
	        return carte;
	    }

	    /**
	     * @return the number of cards
	     */
	    public int nbCartes() {
	        return cards.size();
	    }
	   

}
