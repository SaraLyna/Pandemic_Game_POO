package pandemic;

import java.util.List;

/**
 * this class represents the action of the Scientist
 *
 */

class ScientistRole extends Actions{
	
	//a besoin de disposer que de 4 cartes joueur d’une même maladie pour découvrir
	//un remède. C’est donc en relation avec l’action découvrir un remède
	
	private String name="Scientist";
	private int handSize=4;
	
	/**
	 * constructor of the class ScientistRole
	 * @param name
	 * @param handSize
	 */
	public ScientistRole (String name, int handSize) {
		super();
		this.name=name;
		this.handSize=handSize;
		
	}
	
	/**
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * @return the number of cards ih the hand of the player ==4
	 */
	public int getSize() {
		return this.handSize;
	}
	
	
	//méthode pour trouver un remède avec une main de cartes .
	public boolean discoverCure(List<Cards> hand) {
        if (hand.size() != handSize) {
            return false;
        }
        // Vérifie si toutes les cartes de la main ont le meme nom de ville 
        String diseasename = hand.get(0).getDiseaseName();
        for (Cards card : hand) {
            if (!card.getDiseaseName().equals(diseasename)) {
                return false;
            }
            System.out.println("The Scientist has find a remedy with his 4 cards");
        }
        // Si toutes les cartes ont le meme nom de ville , le remède est découvert
        return true;
    }
	
	/**
	 * method equals
	 */
	public boolean equals(Object o) {
	    if (o == this) {
	        return true;
	    }
	    if (!(o instanceof Cards)) {
	        return false;
	    }
	    Cards card = (Cards) o;
	    return this.name.equals(card.getDiseaseName());
	}
	// méthode findRemedy qui permettrait de trouver un remede pour une maladie donnée en utilisant la méthode discoverCure définie plus haut 
	
	public boolean findRemedy(List<Cards> hand, List<Diseases> diseases, Diseases diseaseToCure) {
	    // Vérifier si le scientifique a la bonne maladie
	    if (!hand.get(0).getDiseaseName().equals(diseaseToCure.getDiseaseName())) {
	        return false;
	    }

	    // Vérifier s'il y a assez de cartes de la maladie pour découvrir un remède
	    int count = 0;
	    for (Cards card : hand) {
	        if (card.getDiseaseName().equals(diseaseToCure.getDiseaseName())) {
	            count++;
	        }
	    }

	    if (count < handSize) {
	        return false;
	    }

	    // Vérifier si un remède n'a pas encore été découvert pour la maladie donnée
	    if (diseases.contains(diseaseToCure)) {
	        return false;
	    }

	    // Découvrir un remède pour la maladie
	    diseases.add(diseaseToCure);
	    return true;
	}
}