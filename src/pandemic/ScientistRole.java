package pandemic;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * this class represents the action of the Scientist
 *
 */
class ScientistRole extends Actions{
	/**
	il a besoin de disposer que de 4 cartes joueur d’une même maladie pour découvrir
	un remède. C’est donc en relation avec l’action découvrir un remède
	 */
	
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
	
	
	
	  /**
     * @param p
     * @param Disease
	 * check if the city has a Research Center and discover a Cure for a specific disease.
	 * Then discard the 5 players cards.
     */
    public static void discover(Players p, Diseases Disease){
    	int cpt = 0;
		Stack<Cards> hand = p.getCardsInHand();
		Cities city = p.getLocation();
		if (city.isResearchCenter()){
			Iterator<Cards> it = hand.iterator();
			while (it.hasNext()) {	
				Cards card = it.next();
				if(card.getDiseaseName()==Disease.getDiseaseName()) {
					cpt += 1;
				}
			}
			if (cpt > 3) {
				Disease.setCured(true);
				while (it.hasNext()) {
					Cards card = it.next();
					if(card.getDiseaseName()==Disease.getDiseaseName()) {
						p.removeCard(card);
					}
				}
			System.out.println("A cure has been found for the disease " + Disease.getDiseaseName());
			}
			else {
				System.out.println(p.getName() + " has not enough cards to cure the disease " + Disease.getDiseaseName());
			}
		}
		else {
			System.out.println(p.getName() + ", please build a research Center to discover a Cure for the disease " + Disease.getDiseaseName());
		}
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
	
	
	
	
	/**
	 * @param hand
	 * @param diseases
	 * @param diseaseToCure
	 * @return a boolean
	 * méthode findRemedy qui permettrait de trouver un remede pour une maladie donnée 
	 * en utilisant la méthode discoverCure définie plus haut 
	 */
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