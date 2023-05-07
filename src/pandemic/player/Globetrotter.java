package pandemic.player;
//import java.util.Scanner;

import pandemic.City;

/**
 * this class represent the action of the GlobetRotter
 *
 */
class Globetrotter extends Actions {
	/**
	c'est en relation avec l'action se déplacer
	il	a la possibilité de se déplacer dans n’importe quelle ville. Ce qui augmente sa capacité d’action. 
     */
	
	private String name;

		
		/**
		 * constructor of the class GlobetRotter
		 * @param name
		 * @param city
		 */
		public Globetrotter(String name, City city) {
			super();
		}
		
		/**
		 * this method allows the player whose role is "globetRotter" to travel to the city of his choice
		 * @param playerToMove; the player who has this role
		 * @param destination; the city chosen by the player
		 */
		public static void moveAnywhere(Player playerToMove, City destination) {		
			/* le code ci-dessous est à décommenter si l'on veut récupérer l'input de l'utilisateur et/ou afficher les possibilités pour les villes
			public static void move(Players playerToMove, MappeMonde map) {	
						Cities[] citiesList = map.getVilles();					
						System.out.print("What city do you want to travel to ? Enter the number.");
						
						for(int i = 0; i< citiesList.length;i++) {
							System.out.print(
									(i+1) + "\t" + citiesList[i].getName() + "\n" ); //si erreur ici il faudra caster i+1 vers string
						}		
						//get number
						Scanner scanner = new Scanner(System.in);
						
						int input=1; //initialization to avoid warnings, should be overriden when input is read
						boolean inputNeeded = true;
						while (inputNeeded) {
							input = scanner.nextInt(); //get input from user
							if (input > citiesList.length) {
								System.out.print("Invalid number, try again.");
							} else {
								inputNeeded = false; //end loop
							}
						}
						destination = citiesList[input-1];
						scanner.close(); //to avoid ressource leak
						*/
	
			playerToMove.setLocation(destination);
			System.out.print(playerToMove.getName() + " has been moved to " + destination.getName() + ".");

		}
		
		
		/**
		 * @return name
		 */
		public String getName() {
			return this.name;
		}

}