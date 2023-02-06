package pandemic;

/**
 * @author saralyna.ouyahia.etu
 *
 */
public class Players {
	private String name;
	private Roles role;
	private Cities location;

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

}
