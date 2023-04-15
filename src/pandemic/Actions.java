package pandemic;
import java.util.*;

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
    public void discover(Players p, Diseases Disease){
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
				
			}
		}
    }
	
	
	
	/** 
	 * @param playerToMove the player to be moved
	 * @param destination the wanted destination
	 * @throws IllegalArgumentException see above
	 * Calls setLocation() on the Player passed in parameters,
	 *  throws an exception if the destination is not among the Player's neighboring cities.
	 */
	public static void move(Players playerToMove, Cities destination) throws IllegalArgumentException {
		List<Cities> neighborsList = playerToMove.getLocation().getNeighbors();	
		
		/* le code ci-dessous est à décommenter si l'on veut récupérer l'input de l'utilisateur et/ou afficher les possibilités pour les villes
		
						System.out.print("What neighboring city do you want to travel to ? Enter the number.");
						for(int i = 0; i< neighborsList.size();i++) {
							System.out.print(
									(i+1) + "\t" + neighborsList.get(i).getName() + "\n" ); //si erreur ici il faudra caster i+1 vers string
						}							
						//get input from user number
						Scanner scanner = new Scanner(System.in);
						
						int input=1; //initialization to avoid warnings, should be overriden when input is read
						boolean inputNeeded = true;
						while (inputNeeded) {
							input = scanner.nextInt(); //get input from user
							if (input > neighborsList.size() ) {
								System.out.print("Invalid number, try again.");
							} else {
								inputNeeded = false; //end loop
							}
						}				
						destination = neighborsList.get(input-1);
						scanner.close(); //to avoid ressource leak
		 */
				
		if (! neighborsList.contains(destination)){
			throw new IllegalArgumentException("the destination is not among the Player's neighboring cities ");
		}
		playerToMove.setLocation(destination);
		System.out.print(playerToMove.getName() + " has been moved to " + destination.getName());
	}
	
	
	
	/**
	 * @param player
	 * this action consist to build a research center
	 * in the same city where the player card is
	 */
	public static void construct( Players player) {
		Stack<Cards> cards= player.getCardsInHand();
		Cities city = player.getLocation();
		Iterator<Cards> it= cards.iterator();
		while(it.hasNext()) {
			Cards card = it.next();
			if (card.getCityName().equals(city.getName())) {
				city.addResearchCenter();
				System.out.println(player + "builds a research center in " + city);
		        player.removeCard(card);
		        break; // Exit the loop once a research center is built
			}		
		}			
	}
	
	
	/**
	 *  this method allow to heal a specific disease from a city
	 * @param city , the city to heal the disease from
	 * @param disease, the disease to be healed
	 * @param cubesStock , the stock of the diseases' cubes
	 */
	public void healDisease(Diseases disease, Cities city,HashMap <Diseases, Integer> cubesStock){	
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
	public void DontDoAnything(){ 
		System.out.println("this player don't do anything");
	}
	

}
