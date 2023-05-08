package pandemic.player;

import java.util.HashMap;
import java.util.List;

import pandemic.City;
import pandemic.Disease;
import pandemic.Game;
import pandemic.chooser.RandomListChooser;

/**
 * this class represent players that have the Doctor role
 */

public class Doctor extends Player {
	/**
	c'est en relation avec l'action traiter une maladie	
	action traiter une maladie:peut retirer tous les cubes maladie en une seule fois meme sans remède
	sans action: retirer tous les
	cubes dès qu’il passe dans une ville où il existe des cubes d’une maladie guérie, sans que cela compte pour une action
	 */
	
	/* pas besoin normalement avec l'héritage
	private String name;
	private City city;*/
	
	
	/**
	 * constructor of the class DoctorRole
	 * @param name
	 * @param city
	 */
	public Doctor(String name, City city,  Game game) {
		super(name, city, game);
	}
	
	

	/**
	 *  this method allows to remove all cubes for a specific disease, in the city the player is in.
	 * @param city , the city to heal the disease from
	 * @param disease, the disease to be healed
	 * @param cubesStock , the stock of the diseases' cubes
	 */
	public void healDisease(Disease chosenDisease){	
		
		City currentCity = this.getLocation();		
		
		int lastCubes = currentCity.getCubeCount(chosenDisease);// number of cubes of the Disease chosenDisease
		 HashMap<Disease, Integer> cubesStock = this.getGame().getCubesStocks(); /*reference to the attribute in Game*/
		
			 for(int i = 0; i < lastCubes ; i++){
				currentCity.reduceInfection(chosenDisease);//  the cube of the Disease disease is removed
				cubesStock.put(chosenDisease,cubesStock.get(chosenDisease) + 1);// the removed cube is added to the cubeStock
			 }
			 System.out.println("The disease " + chosenDisease.getDiseaseName()+"  was successfully treated thanks to the discovery of the cure !");
		 }


}
