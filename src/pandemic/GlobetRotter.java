package pandemic;

/**
 * this class represent the action of the GlobetRotter
 *
 */

class GlobetRotter extends Actions {
	//en relation avec l'action se déplacer
		//a la possibilité de se déplacer dans n’importe quelle ville. Ce qui augmente sa capacité d’action. 
		// private String name;

		
		/**
		 * constructor of the class GlobetRotter
		 * @param name
		 * @param city
		 */
		public GlobetRotter(String name, Cities city) {
			super();
		}
		
		/**
		 * this method allows the player whose role is "globetRotter" to travel to the city of his choice
		 * @param player; the player who has this role
		 * @param city; the city chosen by the player
		 */
		public static void moveAnywhere(Players player,Cities city ) {
			player.setLocation(city);
			System.out.println("Le GlobetRotter s'est déplacée dans " + city.getName());
		}
		
		
		/*public String getName() {
			return this.name;
		}*/

}