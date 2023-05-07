package pandemic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;


/**
 *Cette classe sert à lancer le jeu
 *à jouer
 *
 */
public class Game {
	
	protected int GlobalInfectionRate;
	protected int InfectionFocusAmount ;
	protected Stack<InfectionCards> infectionStack;
	protected Stack<PlayersCards> playersStack;
	
	
	/**
	 * @param GlobalInfectionRate
	 * @param InfectionFocusAmount
	 */
	public Game (int GlobalInfectionRate, int InfectionFocusAmount ){
		this.GlobalInfectionRate=GlobalInfectionRate;
		this.InfectionFocusAmount=InfectionFocusAmount;
	}

	
	/**
	 * @return null
	 */
	public static Iterator<String> keys() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * the most important method in the game, the method to play a party
	 */
	public void play() {
		
	}
	
	
	/**
	public boolean isFinished(){
		if( findRemedy() || InfectionFocusAmount == 8 || this.playersStack.size() < 2) {
			return true;
		}
		else {
			return false;
		}
		
	}
	 */
	
	

	/**
	 *@return  a string representation of the object.
	 */
	public String toString() {
		return "The global infection rate : "+this.GlobalInfectionRate + " and the infection focus amount "+this.InfectionFocusAmount;
	}
	
    //Méthode pour automatiser la phase d'infection classique
	// A faire: -créer une main du jeu qui puisse jouer des cartes a la place des joueurs
	//			-créer une défausse pour les paquets respectifs
	//			-mettre la méthode dans game?
    public void phaseOfInfection() {
    	ArrayList<InfectionCards> hand = new ArrayList<>(); //la main du "jeu" pour recuperer et jouer les cartes infections
    	InfectionPaquet paquetInfection=new InfectionPaquet();//simule le paquet de cartes d'infection
    	InfectionPaquet defausse=new InfectionPaquet(); //simule la défausse
 	   for (int i=0; i< overallInfectionRate +1; i++) {
 	       hand.add(paquetInfection.tirerCarte());
 	       for(Cities city : Map.getVilles()) {
 	    	   if( city.getName().equals(hand.get(i).getCityName())) {
 	    		   city.infectionPropagation(Diseases.nameToDisease(hand.get(i).getDiseaseName()));
 	    		   //met dans la défausse
 	    		   defausse.addCarte(hand.get(i));
 	    		   //remove the card from hand
 	    		   hand.remove(i);
 	    		   
 	    	   }
 	       }
 	   }
    }

}

