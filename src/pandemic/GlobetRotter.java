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
		 * this method allows the player whose role is "globetRotter" to travel to the city of his choice
		 * @param player; the player who has this role
		 * @param city; the city chosen by the player
		 */
		
		public static void moveAnywhere(Players player,Cities city ) {
			player.setLocation(city);
		}
		
		/*public String getName() {
			return this.name;
		}*/

}