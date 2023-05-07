package pandemic.player;

import pandemic.City;
import pandemic.Disease;

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
	
	
	/** overrides bc special role
	 * @param disease
	 * retire les cubes d'une maladie dans une ville
	 * tout en réduisant le taux d'infection
	 */
	public void healDisease(Disease disease, City city) {
		//Cities city=getCity();
		int diseaseCubes= city.getCubeCount(disease);
		for(int i= 0; i < diseaseCubes; i++) {
			city.reduceInfection(disease);
		}
		System.out.println("The doctor removes all cubes of the disease " + disease.getDiseaseName() + " from the city "+ city.getName() );
	}

}
