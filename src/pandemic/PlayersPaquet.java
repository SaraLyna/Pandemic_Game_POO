package pandemic;

import java.util.ArrayList;
import java.util.Collections;

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
			this.cards.add(new PlayersCards("ville-19", "rouge"));
		    this.cards.add(new PlayersCards("ville-23", "rouge"));
		    this.cards.add(new PlayersCards("ville-24", "rouge"));
		    this.cards.add(new PlayersCards("ville-25", "rouge"));
		    this.cards.add(new PlayersCards("ville-29", "rouge"));
			this.cards.add(new PlayersCards("ville-30", "rouge"));
			this.cards.add(new PlayersCards("ville-31", "rouge"));
			this.cards.add(new PlayersCards("ville-35", "rouge"));
			this.cards.add(new PlayersCards("ville-36", "rouge"));
			this.cards.add(new PlayersCards("ville-37", "rouge"));
			this.cards.add(new PlayersCards("ville-42", "rouge"));
			this.cards.add(new PlayersCards("ville-48", "rouge"));
			this.cards.add(new PlayersCards("ville-2", "noir"));
			this.cards.add(new PlayersCards("ville-3", "noir"));
			this.cards.add(new PlayersCards("ville-8", "noir"));
			this.cards.add(new PlayersCards("ville-9", "noir"));
			this.cards.add(new PlayersCards("ville-10", "noir"));
			this.cards.add(new PlayersCards("ville-14", "noir"));
			this.cards.add(new PlayersCards("ville-15", "noir"));
			this.cards.add(new PlayersCards("ville-16", "noir"));
			this.cards.add(new PlayersCards("ville-20", "noir"));
			this.cards.add(new PlayersCards("ville-21", "noir"));
			this.cards.add(new PlayersCards("ville-22", "noir"));
			this.cards.add(new PlayersCards("ville-27", "noir"));
			this.cards.add(new PlayersCards("ville-1", "jaune"));
			this.cards.add(new PlayersCards("ville-5", "jaune"));
			this.cards.add(new PlayersCards("ville-6", "jaune"));
			this.cards.add(new PlayersCards("ville-7", "jaune"));
			this.cards.add(new PlayersCards("ville-12", "jaune"));
			this.cards.add(new PlayersCards("ville-13", "jaune"));
			this.cards.add(new PlayersCards("ville-17", "jaune"));
			this.cards.add(new PlayersCards("ville-18", "jaune"));
			this.cards.add(new PlayersCards("ville-38", "jaune"));
			this.cards.add(new PlayersCards("ville-43", "jaune"));
			this.cards.add(new PlayersCards("ville-44", "jaune"));
			this.cards.add(new PlayersCards("ville-47", "jaune"));
			this.cards.add(new PlayersCards("ville-4", "bleu"));
			this.cards.add(new PlayersCards("ville-11", "bleu"));
			this.cards.add(new PlayersCards("ville-26", "bleu"));
			this.cards.add(new PlayersCards("ville-28", "bleu"));
			this.cards.add(new PlayersCards("ville-32", "bleu"));
			this.cards.add(new PlayersCards("ville-33", "bleu"));
			this.cards.add(new PlayersCards("ville-34", "bleu"));
			this.cards.add(new PlayersCards("ville-39", "bleu"));
			this.cards.add(new PlayersCards("ville-40", "bleu"));
			this.cards.add(new PlayersCards("ville-41", "bleu"));
			this.cards.add(new PlayersCards("ville-45", "bleu"));
			this.cards.add(new PlayersCards("ville-46", "bleu"));
			this.cards.add(new EpidemicCards("epidemic","epidemic"));
			this.cards.add(new EpidemicCards("epidemic","epidemic"));
			this.cards.add(new EpidemicCards("epidemic","epidemic"));
			this.cards.add(new EpidemicCards("epidemic","epidemic"));
			
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
