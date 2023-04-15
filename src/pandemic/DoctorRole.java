package pandemic;


/**
 * this class represent the action of the Doctor
 */

public class DoctorRole extends Actions {
	/**
	c'est en relation avec l'action traiter une maladie	
	action traiter une maladie:peut retirer tous les cubes maladie en une seule fois meme sans remède
	sans action: retirer tous les
	cubes dès qu’il passe dans une ville où il existe des cubes d’une maladie guérie, sans que cela compte pour une action
	 */
	
	private String name;
	private Cities city;
	
	
	/**
	 * constructor of the class DoctorRole
	 * @param name
	 * @param city
	 */
	public DoctorRole(String name, Cities city) {
		super();
		this.setName(name);
		this.city=city;
	}
	
	
	/**
	 * @return a city
	 */
	public Cities getCity() {
		return this.city;
	}
	
	
	/**
	 * @param disease
	 * retire les cubes d'une maladie dans une ville
	 * tout en réduisant le taux d'infection
	 */
	public void RemoveCubes(Diseases disease) {
		Cities city=getCity();
		int diseaseCubes= city.getCubeCount(disease);
		for(int i= 0; i < diseaseCubes; i++) {
			city.reduceInfection(disease);
		}
		System.out.println("The doctor removes all cubes of " + city.getName() );
	}

	
	/**
	 * @return name of the doctor
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}	

}
