package pandemic;

import java.util.Scanner;

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
		public static void move(Players playerToMove, MappeMonde map) {
			
			Cities[] citiesList = map.getVilles();
			
			System.out.print("What city do you want to travel to ? Enter the number.");
			
			for(int i = 0; i< citiesList.length;i++) {
				System.out.print(
						(i+1) + "\t" + citiesList[i].getName() + "\n" ); //si erreur ici il faudra caster i+1 vers string
			}		
			//get number
			Scanner scanner = new Scanner(System.in);
			
			int input=1; /*initialization to avoid warnings, should be overriden when input is read*/
			boolean inputNeeded = true;
			while (inputNeeded) {
				input = scanner.nextInt(); //get input from user
				if (input > citiesList.length) {
					System.out.print("Invalid number, try again.");
				} else {
					inputNeeded = false; //end loop
				}
			}
			//move the player
			playerToMove.setLocation(citiesList[input-1]);
			System.out.print(playerToMove.getName() + " has been moved to " + citiesList[input-1].getName() + ".");
			
			scanner.close(); //to avoid ressource leak
		}
		
		
		/*public String getName() {
			return this.name;
		}*/

}