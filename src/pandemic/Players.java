package pandemic;
import java.util.*;


/**
 * cette classe représente les joueurs
 *
 */
public class Players {
	private String name;
	private Roles role;
	private Cities location;
	private Stack<Cards> CardsInHand; /* the stack of cards in the player's hand */
	protected  List<Players> thePlayers;

	/** 
	 * constructor of the class Players
	 * @param name
	 * @param role
	 * @param location
	 */
	public Players(String name, Roles role, Cities location) {
		this.name=name;
		this.role=role;
		this.location=location;
		this.CardsInHand = new Stack<Cards>();
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
	public Cities getLocation() {
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
	public void removeCard(Cards c) {
		Iterator<Cards> it= CardsInHand.iterator();
		while(it.hasNext()) {
			Cards card = it.next();
			if(card.getCityName()==c.getCityName()) {
		        it.remove();
			}		
		}
	}
	
	
	/**
	 * Getter of the class Players
	 * @return the player's hand of cards
	 */
	public Stack<Cards> getCardsInHand() {
	    return this.CardsInHand;
	}

	/**
	 * Setter of the class Players
	 * @param cardsInHand the new stack of cards in the player's hand
	 */
	public void setCardsInHand(Stack<Cards> cardsInHand) {
	    this.CardsInHand = cardsInHand;
	}
	
	/**
	 * allows to set a new location to the player
	 * @param city ; the city to set
	 */
	
	public void setLocation(Cities city) {
		this.location = city;
	}
	 /**
	  * add a card in the hand of the player 
	 * @param c
	 */
	public void addCard(Cards c ) { 
		 this.CardsInHand.push(c); 
	}
	
	
	/**
	 * @return the list of the Players
	 */
	public List<Players> getPlayers(){
		return this.thePlayers;
	}
	
	
	/**
	 * @param player
	 * add a player in the game
	 */
	public void addPlayer(Players player) {
		this.getPlayers().add(player);
	}

	 

}
