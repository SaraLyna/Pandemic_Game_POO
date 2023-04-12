package pandemic;
import java.util.List;
import java.util.Scanner;

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
	public String discover(){
		
	} */
	
	/** Give the player a choice among the adjacent cities and moves them accordingly. */
	public void move(Players playerToMove, MappeMonde map) {
		List<Cities> neighborsList = playerToMove.getLocation().getNeighbors();
		System.out.print("What neighboring city do you want to travel to ? Enter the number.");
		
		for(int i = 0; i< neighborsList.size();i++) {
			System.out.print(
					(i+1) + "\t" + neighborsList.get(i).getName() + "\n" ); //si erreur ici il faudra caster i+1 vers string

		}
		
		//get number
		Scanner scanner = new Scanner(System.in);
		
		int input;
		boolean inputNeeded = true;
		while (inputNeeded) {
			input = scanner.nextInt(); //get input from user
			if (input > neighborsList.size() ) {
				System.out.print("Invalid number, try again.");
			} else {
				inputNeeded = false; //end loop
			}
		}
		//move the player
		playerToMove.setLocation(neighborsList.get(input-1));

		System.out.print(playerToMove.getName() + " has been moved to " + neighborsList.get(input-1).getName() + ".");
		
		scanner.close(); //to avoid ressource leak
	}
	
	
	public String construct() {
		
	}
	public String HealDisease() {
		
	}
	
	public void DontDoAnything(){ 
	//cette méthode ne fait rien  
		System.out.println("this player don't do anything");
	}
	

}
