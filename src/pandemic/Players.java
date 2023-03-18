package pandemic;
import java.util.Stack;


public class Players {
	private String name;
	private Roles role;
	private Cities location;
	private Stack<Cards> CardsInHand; /* the stack of cards in the player's hand */

	/**
	 * 
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

}
