package pandemic;

/**
 * this class represent the action of the Scientist
 *
 */

class ScientistRole extends Actions{
	
	//a besoin de disposer que de 4 cartes joueur d’une même maladie pour découvrir
	//un remède. C’est donc en relation avec l’action découvrir un remède
	
	private String name;
	public String getName() {
		return this.name;
	}

}
