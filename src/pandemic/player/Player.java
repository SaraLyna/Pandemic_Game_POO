package pandemic.player;
import java.util.*;

import pandemic.City;
import pandemic.card.Card;


/**
 * cette classe représente les joueurs
 *
 */
public class Player {
	private String name;
	private Roles role;
	private City location;
	private Stack<Card> CardsInHand; /* the stack of cards in the player's hand */
	protected  List<Player> thePlayers;

	/** 
	 * constructor of the class Players
	 * @param name
	 * @param role
	 * @param location
	 */
	public Player(String name, Roles role, City location) {
		this.name=name;
		this.role=role;
		this.location=location;
		this.CardsInHand = new Stack<Card>();
	}
	

	/**
	 * Getter of the class Players
	 * @return the name of the player
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * getter of the class Players
	 * @return the role of the player
	 */
	public Roles getRole() {
		return this.role;
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
	 */
	public void discard() {		
		this.CardsInHand.pop();
	}
	
	
	/**
	 * defausse la carte de la main du joueur ,
	 * new version
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
	public Stack<Card> getCardsInHand() {
	    return this.CardsInHand;
	}

	/**
	 * Setter of the class Players
	 * @param cardsInHand the new stack of cards in the player's hand
	 */
	public void setCardsInHand(Stack<Card> cardsInHand) {
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
		 this.CardsInHand.push(c); 
	}
	
	
	/**
	 * @return the list of the Players
	 */
	public List<Player> getPlayers(){
		return this.thePlayers;
	}
	
	
	/**
	 * @param player
	 * add a player in the game
	 */
	public void addPlayer(Player player) {
		this.getPlayers().add(player);
	}

	 

}
