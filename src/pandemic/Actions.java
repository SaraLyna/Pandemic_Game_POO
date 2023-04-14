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
     *   Pour découvrir un remède, il faut que la ville dans laquelle le joueur se trouve
     *   dispose d’une station de recherche et doit avoir dans sa main 5 cartes joueur de la même maladie. 
     *   Les 5 cartes sont défaussées et il est pris note qu’un remède
     *   est trouvé pour cette maladie. Une fois un remède trouvé,
     *    on dit que la maladie est guérie. Si les remèdes sont trouvés
     */
    public void discover(Players p){
				Stack<Cards> hand = p.getCardsInHand();
				for (int i=0; i<hand.size();i++){
					if (p.getLocation().isResearchCenter()){
						if() {
							Iterator<Cards> it = hand.iterator();
							while (it.hasNext()) {								
							}
						}
					}
				}
	} 
	
	
	/** Calls setLocation() on the Player passed in parameters, throws an exception if the destination is not among the Player's neighboring cities.
	 * @param playerToMove the player to be moved
	 * @param destination the wanted destination
	 * @throws IllegalArgumentException see above
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
		 */
		
		
		if (! neighborsList.contains(destination)){
			throw new IllegalArgumentException("the destination is not among the Player's neighboring cities");
		}
		
		//move the player
		playerToMove.setLocation(destination);
		System.out.print(playerToMove.getName() + " has been moved to " + destination.getName() + ".");
		 
		/* décommenter cette ligne si on utilise Scanner plus haut
		 * 					scanner.close(); //to avoid ressource leak
		 */
	}
	
	
	/**
	 * @param player
	 * this action consist to build a research center
	 * in the same city where the player card is
	 */
	public void construct( Players player) {
		Stack<Cards> cards= player.getCardsInHand();
		Cities city = player.getLocation();
		Iterator<Cards> it= cards.iterator();
		while(it.hasNext()) {
			Cards card = it.next();
			if(card.getCityName()==city.getName()) {
				city.addResearchCenter();
		        player.removeCard(card);
			}		
		}			
	}
	
	
	/**
	 * 
	 */
	public void HealDisease() {
		
	}
	
	
	/**
	 * this action is to do nothing,
	 * 
	 */
	public void DontDoAnything(){ 
		System.out.println("this player don't do anything");
	}
	

}
