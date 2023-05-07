package pandemic;

import java.util.Iterator;
import java.util.Stack;

/* TODO déplacer toutes les méthodes de main ici, et rédiger le reste*/

/**
 * Class to run the pandemic game simulation.
 *
 */
public class Game {
	
	/*
	 *  all the necessary data to be stored for the game, will be accessed by other classes by passing the Game instance to them
	 */
	
	//TODO terminer la docu des attributs
	//TODO créer tous les getters et setters nécessaires
	protected int InfectionFocusAmount;
	protected int GlobalInfectionRate;
	protected Stack<InfectionCards> infectionStack;
	protected Stack<PlayersCards> playersStack;
	
	
	/**
	 * Builds an instance of Game by creating all its necessary components : map, players, etc.
	 *  @param mapFile The name of the file that contains city data
	 *  @param playerNumber The numbers of players for this game, should be between 2 and 4 included.
	 *  @param GlobalInfectionRate Should be 2 for the classic version of the game.
	 *	
	 */
	public Game (String mapFile, int numPlayers, int GlobalInfectionRate){
		this.GlobalInfectionRate=GlobalInfectionRate;
		
		if ( (numPlayers<2) || (numPlayers>4) ) {
			System.out.println("Error : invalid number of players"); //TODO facultatif : mettre ça en exception
		} 
		
		MappeMonde map = new MappeMonde(mapFile);
		
		//TODO créer [playerNumber] joueurs
		
		
		//TODO gérer le reste du jeu en lançant des tours jusqu'à ce que isFinished soit à true
		while (!this.isFinished()) {
			effectuer des tours
		}
		
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
		
		//INIT
		Map.displayAllCities();
	     ;
	    //TODO récupérer map depuius les args
	    
		//TODO faire ici tout ce que le main faisait 
	}
	
	
	/** @return true if the game is finished, false otherwise*/
	public boolean isFinished(){
		return (TODO : si remede trouvé) 
				|| InfectionFocusAmount == 8 
				|| this.playersStack.size() < 2);	
	}
	
	

	/**
	 *@return a string representation of the object.
	 */
	public String toString() {
		return "The global infection rate : "+this.GlobalInfectionRate + " and the infection focus amount "+this.InfectionFocusAmount;
	}
	
	/**
	 * Acts everything a player is supposed to do during their turn, except for the action that must be manually acted out after using this method.
	 * @param currentPlayer the player that will take this turn
	 * @param currentDeck the PlayersPaquet deck that is currently in use for this game
	 * 
	 * NB : cette mÃ©thode est amÃ©liorable en incluant le message "tour du [n]iÃ¨me joueur qui est [nom du joueur]" si les parties Ã  codÃ©es sont longues et/ou de longueur variable
	 */
	
	static void makePlayerTakeATurn(Players currentPlayer, PlayersPaquet currentDeck) {
					PlayersCards l1=currentDeck.tirerCarte();
				   PlayersCards l2=currentDeck.tirerCarte();
				   
				   currentPlayer.addCard(l1);
				   currentPlayer.addCard(l2);
				   
				   System.out.println("Player " + currentPlayer.getName() + " "+ l1.toString() + " and "+ l2.toString());
				   Stack<Cards> hand=currentPlayer.getCardsInHand();
				   System.out.println(currentPlayer.getName() + " has " + hand.size()+ " cards in his/her hand. \n");
				   
				   //si on veut mettre des actions alÃ©atoires et/ou du choix d'actions Ã§a peut Ãªtre Ã  cet endroit
	}


}

