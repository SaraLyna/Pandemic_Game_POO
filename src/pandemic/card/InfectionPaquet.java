package pandemic.card;

import java.util.ArrayList;
import java.util.Collections;

import pandemic.Disease;

/**
 * cette classe représente le paquet des cartes infection
 *
 */
public class InfectionPaquet {
private ArrayList<InfectionCards> cards;
	
	/**
	 * constructor of the class InfectionPaquet
	 */
	public InfectionPaquet() {
		this.cards= new ArrayList<>();
		this.initCards();
	}
    
		/**
		 * all the cards in the package infection
		 */
		public void initCards() {
			/**
			 this.cards = new ArrayList<>();
			    this.cards.add(new InfectionCards("ville-19", "rouge"));
			    this.cards.add(new InfectionCards("ville-23", "rouge"));
			    this.cards.add(new InfectionCards("ville-24", "rouge"));
				this.cards.add(new InfectionCards("ville-25", "rouge"));
				this.cards.add(new InfectionCards("ville-29", "rouge"));
				this.cards.add(new InfectionCards("ville-30", "rouge"));
				this.cards.add(new InfectionCards("ville-31", "rouge"));
				this.cards.add(new InfectionCards("ville-35", "rouge"));
				this.cards.add(new InfectionCards("ville-36", "rouge"));
				this.cards.add(new InfectionCards("ville-37", "rouge"));
				this.cards.add(new InfectionCards("ville-42", "rouge"));
				this.cards.add(new InfectionCards("ville-48", "rouge"));
				this.cards.add(new InfectionCards("ville-2", "noir"));
				this.cards.add(new InfectionCards("ville-3", "noir"));
				this.cards.add(new InfectionCards("ville-8", "noir"));
				this.cards.add(new InfectionCards("ville-9", "noir"));
				this.cards.add(new InfectionCards("ville-10", "noir"));
				this.cards.add(new InfectionCards("ville-14", "noir"));
				this.cards.add(new InfectionCards("ville-15", "noir"));
				this.cards.add(new InfectionCards("ville-16", "noir"));
				this.cards.add(new InfectionCards("ville-20", "noir"));
				this.cards.add(new InfectionCards("ville-21", "noir"));
				this.cards.add(new InfectionCards("ville-22", "noir"));
				this.cards.add(new InfectionCards("ville-27", "noir"));
				this.cards.add(new InfectionCards("ville-1", "jaune"));
				this.cards.add(new InfectionCards("ville-5", "jaune"));
				this.cards.add(new InfectionCards("ville-6", "jaune"));
				this.cards.add(new InfectionCards("ville-7", "jaune"));
				this.cards.add(new InfectionCards("ville-12", "jaune"));
				this.cards.add(new InfectionCards("ville-13", "jaune"));
				this.cards.add(new InfectionCards("ville-17", "jaune"));
				this.cards.add(new InfectionCards("ville-18", "jaune"));
				this.cards.add(new InfectionCards("ville-38", "jaune"));
				this.cards.add(new InfectionCards("ville-43", "jaune"));
				this.cards.add(new InfectionCards("ville-44", "jaune"));
				this.cards.add(new InfectionCards("ville-47", "jaune"));
				this.cards.add(new InfectionCards("ville-4", "bleu"));
				this.cards.add(new InfectionCards("ville-11", "bleu"));
				this.cards.add(new InfectionCards("ville-26", "bleu"));
				this.cards.add(new InfectionCards("ville-28", "bleu"));
				this.cards.add(new InfectionCards("ville-32", "bleu"));
				this.cards.add(new InfectionCards("ville-33", "bleu"));
				this.cards.add(new InfectionCards("ville-34", "bleu"));
				this.cards.add(new InfectionCards("ville-39", "bleu"));
				this.cards.add(new InfectionCards("ville-40", "bleu"));
				this.cards.add(new InfectionCards("ville-41", "bleu"));
				this.cards.add(new InfectionCards("ville-45", "bleu"));
				this.cards.add(new InfectionCards("ville-46", "bleu"));
			*/
			  this.cards = new ArrayList<>();
			    String[] cities = {"ville-19", "ville-23", "ville-24", "ville-25", "ville-29", "ville-30", "ville-31", "ville-35", "ville-36", "ville-37", "ville-42", "ville-48", "ville-2", "ville-3", "ville-8", "ville-9", "ville-10", "ville-14", "ville-15", "ville-16", "ville-20", "ville-21", "ville-22", "ville-27", "ville-1", "ville-5", "ville-6", "ville-7", "ville-12", "ville-13", "ville-17", "ville-18", "ville-38", "ville-43", "ville-44", "ville-47", "ville-4", "ville-11", "ville-26", "ville-28", "ville-32", "ville-33", "ville-34", "ville-39", "ville-40", "ville-41", "ville-45", "ville-46"};
			    
				Disease everyDisease[] = Disease.values(); 
				//will be [BLUE, RED, YELLOW, BLACK] for the classic game
				for(Disease d:everyDisease) {
			        for (String city : cities) {
			            this.cards.add(new InfectionCards(city, d));
			        }
			    }
		}
	    
		
	/**
	 * @param card
	 * add an Infectioncard 
	 */
	public void addCarte(InfectionCards card) {
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
	    public InfectionCards tirerCarte() {
	        InfectionCards carte = cards.get(0);
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
