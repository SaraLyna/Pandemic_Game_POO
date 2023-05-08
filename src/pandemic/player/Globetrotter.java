package pandemic.player;
//import java.util.Scanner;

import java.util.Arrays;
import java.util.List;

import pandemic.City;
import pandemic.Game;
import pandemic.chooser.RandomListChooser;

/**
 * this class represent the action of the GlobetRotter
 *
 */
class Globetrotter extends Player {
	/**
	c'est en relation avec l'action se déplacer
	il	a la possibilité de se déplacer dans n’importe quelle ville. Ce qui augmente sa capacité d’action. 
     */

		
		/**
		 * constructor of the class GlobetRotter
		 * @param name
		 * @param city
		 */
		public Globetrotter(String name, City city, Game game) {
			super(name,city,game);
		}
		
		/** overrides the base method from Player
		 * this method allows the player whose role is "globetRotter" to travel to the city of his choice
		 * @param playerToMove; the player who has this role
		 * @param destination; the city chosen by the player
		 */
		public void move(City destination) throws IllegalArgumentException {
			this.setLocation(destination);
			System.out.print(this + " has been moved to " + destination.getName() + ".");

		}
		
		/* overriden to choose among all cities*/
		public City chooseDestination() {
			RandomListChooser<City> rlc = new RandomListChooser<>();
			City allCitiesArray[] = this.getGame().getMap().getCities();
			List<City> allCitiesList = Arrays.asList(allCitiesArray); /*conversion to an ArrayList to feed it to ListChooser*/
			City destination = rlc.choose("A city will be chosen randomly for the player " + this + " to move.",allCitiesList); /* we use the random list chooser to automatically pick a city*/
			return destination;
		}

}