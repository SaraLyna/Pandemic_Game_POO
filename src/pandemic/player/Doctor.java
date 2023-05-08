package pandemic.player;

import java.util.HashMap;

import pandemic.City;
import pandemic.Disease;
import pandemic.Game;

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
	 *  this method allow to heal a specific disease from a city
	 * @param city , the city to heal the disease from
	 * @param disease, the disease to be healed
	 * @param cubesStock , the stock of the diseases' cubes
	 */
	public void healDisease(Disease disease, City city){	
		
		HashMap<Disease, Integer> cubesStock = this.getGame().getCubesStocks();
		
		int lastCubes = city.getCubeCount(disease);// number of cubes of the Disease disease
			 for(int i = 0; i < lastCubes ; i++){
				city.reduceInfection(disease);//  the cube of the Disease disease is removed
				cubesStock.put(disease,cubesStock.get(disease) + 1);// the removed cube is added to the cubeStock
			 }
			 System.out.println("The disease " + disease.getDiseaseName()+"  was successfully treated thanks to the discovery of the cure !");
			 return; 
		 }	


}
