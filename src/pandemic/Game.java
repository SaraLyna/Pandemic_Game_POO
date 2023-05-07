package pandemic;

import java.io.FileNotFoundException;
import java.util.*;

import pandemic.card.Card;
import pandemic.card.InfectionCards;
import pandemic.card.PlayersCards;
import pandemic.card.PlayersPaquet;
import pandemic.player.Player;

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
	/** the map object created from the json file*/
	protected MappeMonde map;
	/** HashMap linking the amounts of disease cubes in stock for each disease. If any of them drops down to 0, the game is lost.
	  * keys : a given disease from the Disease enum
	  * values : the number of cubes left for that disease */
	protected HashMap<Disease, Integer> cubeStocks;
	
	
	/**
	 * Builds an instance of Game by creating all its necessary components : map, players, etc.
	 *  @param mapFile The name of the file that contains city data
	 *  @param playerNumber The numbers of players for this game, should be between 2 and 4 included.
	 *  @param GlobalInfectionRate Should be 2 for the classic version of the game.
	 * @throws FileNotFoundException 
	 *	
	 */
	public Game (String mapFile, int numPlayers, int GlobalInfectionRate) throws FileNotFoundException{
		this.GlobalInfectionRate=GlobalInfectionRate;
		
		cubeStocks = new HashMap<Disease,Integer>();
		
		//init cubeStocks for each disease
		Disease everyDisease[] = Disease.values(); 
		//will be [BLUE, RED, YELLOW, BLACK] for the classic game
		for(Disease d:everyDisease) {
			this.getCubesStocks().put(d, 24);
		}
		
		if ( (numPlayers<2) || (numPlayers>4) ) {
			System.out.println("Error : invalid number of players"); //TODO facultatif : mettre ça en exception
		} 
		
		this.map = new MappeMonde(mapFile);
		
		//TODO créer [playerNumber] objets joueurs
		for (int i=0;i<numPlayers;i++) {
			//TODO créer un objet joueur
		}
		

		
	}
	
	
	/**
	 * the most important method in the game, the method to play a party
	 */
	public void play() {
		//TODO faire dans cette méthode tout ce que le main faisait 
		
		
		
		//INIT
		map.displayAllCities();
		
		//TODO gérer le reste du jeu en lançant des tours jusqu'à ce que isFinished soit à true
		while (true) {
			//TODO effectuer des tours
		}
	    

	     
	    //NB :  les méthodes qui peuvent potentiellement faire perdre la partie doivent soit return qqch qui l'indique, ou modifier un attribut isFinished de Game (au choix) 
	
	
	
	}
	
	public HashMap<Disease, Integer> getCubesStocks() {
		return this.cubeStocks;
	}
	
	/** decrements the corresponding cube stock and calls Cities.addCube()
	 * @param  */
	void addCube(City city, Disease diseaseType) {
		//decrements the stock
		this.decrementStock(diseaseType);
		
		//calls Cities.addCube()
		city.addCube(diseaseType);
	}
	
	/** 
	 * decrements the corresponding cube stock
	 * */
	void decrementStock(Disease diseaseType) {
		int newValue = this.getCubesStocks().get(diseaseType) ;
		this.getCubesStocks().put(diseaseType, newValue-1); //update with a decremented value
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
	
	static void makePlayerTakeATurn(Player currentPlayer, PlayersPaquet currentDeck) {
					PlayersCards l1=currentDeck.tirerCarte();
				   PlayersCards l2=currentDeck.tirerCarte();
				   
				   currentPlayer.addCard(l1);
				   currentPlayer.addCard(l2);
				   
				   System.out.println("Player " + currentPlayer.getName() + " "+ l1.toString() + " and "+ l2.toString());
				   Stack<Card> hand=currentPlayer.getCardsInHand();
				   System.out.println(currentPlayer.getName() + " has " + hand.size()+ " cards in his/her hand. \n");
				   
				   //si on veut mettre des actions alÃ©atoires et/ou du choix d'actions Ã§a peut Ãªtre Ã  cet endroit
	}
	
	
	
	/**  pas besoin de cette méthode si on teste juste après l'insertion de cubes, la création de foyers, la pioche ou la découverte de remèdes
	/** @return 0 if the game is finished, 1 if it is won by the players, and more than 1 if it has been lost by the players.*
	public int isFinished(){
		return (TODO : si remede trouvé) 
				|| InfectionFocusAmount == 8 
				|| this.playersStack.size() < 2);	
	}
	
	
		/**
	 * @return null
	 
	 *
	 */
	



}

