package pandemic;
import java.util.*;
import pandemic.chooser.*;

/**
 * this class represent the most important actions to do
 * each player (or role) do an action with the card he gets
 */

public class Actions {
	
	/**
	 * constructor of the class Actions
	 */
	public Actions() {
		
	}
	
 

    /**
     * @param p
     * @param Disease
	 * check if the city has a Research Center and discover a Cure for a specific disease.
	 * Then discard the 5 players cards.
     */
    public static void discover(Players p, Diseases Disease){
		//TODO IMPLEMENTER RANDOMLISTCHOOSER DANS CETTE METHODE POUR AUTOMATISER
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
			if (cpt > 4) {
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
	 * @param playerToMove the player to be moved
	 * @param destination the wanted destination
	 * @throws IllegalArgumentException see above
	 * Calls setLocation() on a random location among the neighboring cities.
	 */
	public static void move(Players playerToMove) throws IllegalArgumentException {
		
		/* note : if we want to add the possibility of using an InputListChooser we need a boolean somewhere that is retrieved by this function to use the correct ListChooser*/
		
		List<Cities> neighborsList = playerToMove.getLocation().getNeighbors();	
		
		RandomListChooser<Cities> rlc = new RandomListChooser<>();
		Cities chosenCity = rlc.choose("A city will be chosen randomly for the player " + playerToMove.getName() + " to move.",neighborsList); /* we use the random list chooser to automatically pick a city*/
				
		/* code à supprimer vu que le randomListChooser est ici cantonné à neighborsList
			if (! neighborsList.contains(destination)){
				//System.out.println("the destination is not among the Player's neighboring cities ");
				//throw new IllegalArgumentException("the destination is not among the Player's neighboring cities ");
				
						
							//choose("false destination", neighborsList);
			}else {*/
		
		playerToMove.setLocation(chosenCity);
		System.out.print(playerToMove.getName() + " has been moved to " + chosenCity.getName()+"\n");
	}
	
	
	
	/**
	 * @param player
	 * this action consist to build a research center
	 * in the same city where the player card is
	 */
	public static void construct( Players player) {
		
		//TODO IMPLEMENTER RANDOMLISTCHOOSER DANS CETTE METHODE POUR AUTOMATISER
		Stack<Cards> cards= player.getCardsInHand();
		Cities city = player.getLocation();
		Iterator<Cards> it= cards.iterator();
		boolean a = false;
		while(it.hasNext()) {
			Cards card = it.next();
			if (card.getCityName().equals(city.getName())) {
				if (city.isReasearchCenter == false) {
					city.addResearchCenter();
					player.removeCard(card);
					a = true;
					System.out.println(player.getName() + " built a research center in " + city.getName()+"\n");
				}       
		        break; // Exit the loop once a research center is built
			}		
		}
		if(a == false) {
			System.out.println(player.getName() + " did not built a research center in " + city.getName()+"\n");
		}

	}
	
	
	/**
	 *  this method allow to heal a specific disease from a city
	 * @param city , the city to heal the disease from
	 * @param disease, the disease to be healed
	 * @param cubesStock , the stock of the diseases' cubes
	 */
	public static  void healDisease(Diseases disease, Cities city,HashMap <Diseases, Integer> cubesStock){	
		int lastCubes = city.getCubeCount(disease);// number of cubes of the Disease disease
		 if (lastCubes == 0) {
		    System.out.println("There is no cubes of the disease " + disease.getDiseaseName() + " in the city "+ city.getName() + " anymore" );
		    return;
		 }	
		 
		 else if (disease.isCured()) {
			 for(int i = 0; i < lastCubes ; i++){
				city.reduceInfection(disease);//  the cube of the Disease disease is removed
				cubesStock.put(disease,cubesStock.get(disease) + 1);// the removed cube is added to the cubeStock
			 }
			 System.out.println("The disease " + disease.getDiseaseName()+"  was successfully treated thanks to the discovery of the cure !");
			 return; 
		 }	
		 
		 else { 
			 city.reduceInfection(disease);//  the cube of the Disease disease is removed
			 cubesStock.put(disease,cubesStock.get(disease) + 1);
			 System.out.println("a cube of the disease "+ disease.getDiseaseName() +" is removed from the city " + city.getName());
			 return;
		 }
	}

	
	
	/**
	 * this action is to do nothing,
	 * 
	 */
	public static void DontDoAnything(){ 
		System.out.println("this player don't do anything");
	}
	

}
