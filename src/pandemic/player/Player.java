package pandemic.player;
import java.util.*;

import pandemic.City;
import pandemic.card.Card;


/**
 * cette classe représente les joueurs
 *
 */
public abstract class Player {
	private String name;
	private City location;
	private ArrayList<Card> CardsInHand; /* the stack of cards in the player's hand */
						
						//protected  List<Player> thePlayers; //voir si utilisable, pb d'actualisations entre les listes des différents joueurs, pour qu'elles soient synchronisées il faudrait utiliser addPlayer sur chacun des joueurs
																//ça ferait plus de sens de stocker ça dans Game je pense

	/** 
	 * constructor of the class Players
	 * @param name
	 * @param location
	 */
	public Player(String name, City location) {
		this.name=name;
		this.location=location;
		this.CardsInHand = new ArrayList<Card>();
	}
	

	/**
	 * Getter of the class Players
	 * @return the name of the player
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Getter of the class Players
	 * @return the location of the player
	 */
	public City getLocation() {
		return this.location;
	}
	
	
	/**
	 *this method allows to discard a card from the player's stack cards if the stack 's size (number of cards it contains) extends 7 (MAX)
	 
	public void discard() {	
		
		this.CardsInHand.remove(this.CardsInHand[0]);
	}
	*/
	
	
	/**
	 * defausse la carte demandée de la main du joueur
	 */
	public void removeCard(Card c) {
		Iterator<Card> it= CardsInHand.iterator();
		while(it.hasNext()) {
			Card card = it.next();
			if(card.getCityName()==c.getCityName()) {
				it.remove();
			}		
		}
	}
	
	
	/**
	 * Getter of the class Players
	 * @return the player's hand of cards
	 */
	public ArrayList<Card> getCardsInHand() {
	    return this.CardsInHand;
	}

	/**
	 * Setter of the class Players
	 * @param cardsInHand the new stack of cards in the player's hand
	 */
	public void setCardsInHand(ArrayList<Card> cardsInHand) {
	    this.CardsInHand = cardsInHand;
	}
	
	/**
	 * allows to set a new location to the player
	 * @param city ; the city to set
	 */
	
	public void setLocation(City city) {
		this.location = city;
	}
	
	 /**
	  * add a card in the hand of the player 
	 * @param c
	 */
	public void addCard(Card c ) { 
		 this.CardsInHand.add(c); 
	}
	
	
	/**
	 * 
	 * 	
	 * 
	 * 
	 * 
	 * @return the list of the Players

	public List<Player> getPlayers(){
		return this.thePlayers;
	}
	

	


	 * @param player
	 * add a player in the game

	public void addPlayer(Player player) {
		this.getPlayers().add(player);
	}

	 	 */

}
