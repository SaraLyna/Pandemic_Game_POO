package pandemic;

import java.io.FileNotFoundException;
import java.util.*;

import pandemic.card.Card;
import pandemic.card.InfectionCards;
import pandemic.card.PlayersCards;
import pandemic.card.PlayersPaquet;
import pandemic.chooser.RandomListChooser;
import pandemic.player.Player;

/* TODO déplacer toutes les méthodes de main ici, et rédiger le reste*/

/**
 * Class to run the pandemic game simulation.
 * All the necessary data to be stored for the game, will be accessed by other classes by passing the Game instance to them
 */
public class Game {
	
	//TODO terminer la docu des attributs
	//TODO créer tous les getters et setters nécessaires
	
	/*constants below*/
	protected static final int STARTINGGLOBALINFECTIONRATE = 2;
	protected static final int MAXNBRESEARCHCENTER = 6; // the biggest number of research center that we can have in the game 
	protected static final int MAXNBINFECTIONAMOUNT = 8; // the biggest number of Infection focus that we can have in the game 
	//exhaustive list of all actions a player can do,except for the special action of the doctor that they can do without losing one of their 4 actions per turn, that one is treated separately
		//TODO bonus : maybe there's a way to directly use the methods as elements of the list like in C, but this works as well
	protected static final ArrayList<String> ACTIONS = new ArrayList<>(
		    Collections.unmodifiableList(
		    		Arrays.asList(
		    				"discover", "move", "construct","healDisease","dontDoAnything"))); 
	
	
	/* attributes below*/
	
	/** the exhaustive list of the players in this game*/
	protected ArrayList<Player> players;
	
	/** to count how many InfectionFocus there are, if there are more than X the game ends*/
	protected int InfectionFocusAmount;
	
	/**TODO DOCU*/
	protected int GlobalInfectionRate;
	
	/**TODO DOCU*/
	protected int numberOfResearchCenter;
	
	/**TODO DOCU*/
	protected Stack<InfectionCards> infectionStack;
	
	/**TODO DOCU*/
	protected Stack<PlayersCards> playersStack;

	/**TODO DOCU*/
	protected int maxNbInfectionFocusAmount;
	
	/** the map object created from the json file*/
	protected Mappemonde map;
	
	/** will take one of the values below to signal in the play() method that the loop needs to end :
	 * "ongoing" : game goes on
	 * "wonBecauseCures" : game won by the players finding all 4 cures
	 * "lostBecauseCubes" : game lost by being unable to add a cube to a city bc the reserve for that color is empty
	 * "lostBecauseInfections" : game lost by reaching 8 infection outbreaks
	 * "lostBecauseDraw" : game lost because a player couldn't draw their 2 cards
	 */
	protected String state; //TODO facultatif mettre en enum si possible

	/** HashMap linking the amounts of disease cubes in stock for each disease. If any of them drops down to 0, the game is lost.
	  * keys : a given disease from the Disease enum
	  * values : the number of cubes left for that disease */
	protected HashMap<Disease, Integer> cubeStocks;
	
	
	
	/* getters and setters below*/

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Mappemonde getMap() {
		return map;
	}
	/* should be unused*/
	public void setMap(Mappemonde map) {
		this.map = map;
	}

	
	
	/*other methods below*/
	
	/**
	 * Builds an instance of Game by creating all its necessary components : map, players, etc.
	 *  @param mapFile The name of the file that contains city data
	 *  @param playerNumber The numbers of players for this game, should be between 2 and 4 included.
	 *  @param GlobalInfectionRate Should be 2 for the classic version of the game.
	 * @throws FileNotFoundException 
	 *	
	 */
	public Game (String mapFile, int numPlayers) throws FileNotFoundException{
		
		this.GlobalInfectionRate = STARTINGGLOBALINFECTIONRATE;
		this.InfectionFocusAmount = 0;
		this.numberOfResearchCenter = 0;
		
		
		
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
		
		this.map = new Mappemonde(mapFile, this);
		
		//TODO créer [playerNumber] objets joueurs
		for (int i=0;i<numPlayers;i++) {
			//TODO créer un objet joueur
		}
	}
	
	/*
	 * allow to set a new number of research center 
	 */
	public void setNumberOfResearchCenter(int number) {
		this.numberOfResearchCenter = number;	
	}
	

	/**
	 * @return the number of research center
	 */
	
	public int getNumberOfResearchCenter() {
		return this.numberOfResearchCenter;
	}
	
	/**
	 * @return the number of infection focus
	 */
	
	public int getNumberOfInfectionFocus() {
		return this.getNumberOfInfectionFocus();
	}
	
	/*
	 * this method allow to know if cures of all the diseases have been found or not
	 * @return true if yes or false if no
	 */
	
	public boolean findRemedy(){
	    Disease[] everyDisease = Disease.values();
	    for (Disease d : everyDisease) {
	        if (!d.isCured()) {
	            // if any disease is not cured, return false immediately
	            return false;
	        }
	    }
	    // if all diseases are cured, return true
	    return true;
	}

	
	/**
	 * the most important method in the game, the method to play
	 */
	public void play() {
		//TODO faire dans cette méthode tout ce que le main faisait 
		
		
		
		//INIT
		map.displayAllCities();
		
		//TODO FAIRE LE RESTE DE L'INIT
		
		
		
		
		
		// TURNS
		while (true) {
			//TODO : cycler parmi les joueurs avec un itérable pour leur faire jouer leurs tours
			
			/*TODO à l'intérieur des fonctions qui peuvent déclencher une win/loss de la partie, il faut :
			1. mettre qqch pour tester si la partie est finie et 
			2. faire remonter l'information en modifiant l'attribut state
			3. juste après l'appel de la fonction dans Game, tester si "state" est à autre chose que ongoing, si oui sortir immédiatement du while avec un break*/
		
			
			//rédiger code ici avec des break qd nécessaire
			break;
		}
		
		
		/* we just got out of the while because the game has ended */
		switch(this.getState()) {
			case "lostBecauseDraw": 
				System.out.println("The game has been lost because a player couldn't draw their 2 cards.");
				break;
			case "lostBecauseInfections" :
				System.out.println("The game has been lost by reaching the maximum amount of infection outbreaks");
				break;
			case "lostBecauseCubes":
				System.out.println("The game has been lost by being unable to add a cube to a city bc the reserve for that color is empty.");
				break;
			case "wonBecauseCures":
				System.out.println("The game has been won as all cures have been discovered.");
				break;
			case "ongoing":
				System.out.println("PROBLEME : ON NE DEVRAIT PAS SORTIR DE LA BOUCLE");
				break;
			default:
				System.out.println("PROBLEME : ON NE DEVRAIT PAS ATTEINDRE LE DEFAULT");
		}
	
	
	
	}
	
	public HashMap<Disease, Integer> getCubesStocks() {
		return this.cubeStocks;
	}
	
	/** decrements the corresponding cube stock and calls Cities.addCube()
	 * @param  */
	public void addCube(City city, Disease diseaseType) {
		//decrements the stock
		this.decrementStock(diseaseType);
		
		//calls Cities.addCube()
		city.addCube(diseaseType);
	}
	
	/** 
	 * increases (or decreases if negative) the corresponding cube stock, and changes the state attribute if this makes the players lose the game
	 * USING changeCubeStock() DIRECTLY OR INDIRECTLY IN THE play() METHOD SHOULD IMMEDIATELY BE FOLLOWED BY A CHECK OF THE state ATTRIBUTE TO END THE GAME IF NECESSARY
	 * eg to add one yellow cube to the reserve  : changeCubeStock(YELLOW, +1)
	 * @param diseaseType
	 * @param amountChanged The number to add to the current stock.
	 * */
	public void changeCubeStock(Disease diseaseType, int amountChanged) {
		
		int currentCubeStockForThatDisease = this.getCubesStocks().get(diseaseType) ;
		
		if( currentCubeStockForThatDisease >= -amountChanged ) { //if there are enough cubes to be taken, ie game not lost
			int newCubeStockForThatDisease = currentCubeStockForThatDisease + amountChanged;
			this.getCubesStocks().put(diseaseType, newCubeStockForThatDisease); //update with a decremented value
		} else {
			this.state = "lostBecauseCubes";
		}
	}
	
	/*this method implements a type of lost
	 * 
	 */
	
	public void missingCards() {
		
		if(this.playersStack.size() < 2) {
			this.state = "lostBecauseCards";
		}
	}
	
	/*this method implements a type of lost
	 * 
	 */
	
	public void limitOfInfectionFocus() {
		
		if(this.InfectionFocusAmount == MAXNBINFECTIONAMOUNT) {
			this.state = "lostBecauseInfectionFocus";
		}
	}
	
	/*
	 * this method allow to move a research center from a city to another one
	 * @param cityFrom, the city to move the research center from
	 * @param cityTo, the city to move the research center to
	 */
	// Not forgetting that when a city has a research center , all the cubes of the diseases in its infectionRates are removed and all the diseases are cured. So we don't have to check that in this method
	
	public void moveResearchCenter(City cityFrom , City cityTo) {
		
		if(this.numberOfResearchCenter == MAXNBRESEARCHCENTER && cityFrom.isResearchCenter) {
			cityTo.isResearchCenter = true;
			cityFrom.isResearchCenter = false;
		}
	}
	
	
	/** 
	 * decrements the corresponding cube stock
	 * */
	public void decrementStock(Disease diseaseType) {
		this.changeCubeStock(diseaseType, -1);
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
	
		void makePlayerTakeATurn(Player currentPlayer, PlayersPaquet currentDeck) {
			/* TODO : implémmenter les tests pour voir si la partie est terminée, si oui MAJ l'attribut state puis sortir de la fonction immédiatement*/
    		
			RandomListChooser<String> rlcStr = new RandomListChooser<>();

		
			PlayersCards l1=currentDeck.tirerCarte();
		    PlayersCards l2=currentDeck.tirerCarte();
		   
		    currentPlayer.addCard(l1);
		    currentPlayer.addCard(l2);
		     
		    System.out.println("Player " + currentPlayer + " "+ l1.toString() + " and "+ l2.toString());
		    ArrayList<Card> hand=currentPlayer.getCardsInHand();
		    System.out.println(currentPlayer + " has " + hand.size()+ " cards in his/her hand. \n");
		    
		    //TODO COMPLETER AVEC CE QU'IL FAUT
		    
		    
		    
		    /* player does its 4 actions*/
		    for (Player p : this.players) { /*for each player*/
		    	for (int i=0;i<4;i++) {
		    		
		    		String chosenAction = rlcStr.choose("An action will be chosen randomly for the player" + p + ".", ACTIONS);
		    		switch(chosenAction) {
			    		  case "move":
			    			 City randomlyChosenDestination = p.chooseDestination(); 		    			 
			    			  p.move(randomlyChosenDestination);
			    		    // code block
			    		    break;
			    		  case "discover":
			    		    // code block
			    			//TODO CHECKER SI FIN DU JEU A CAUSE DE CETTE ACTION
			    		    break;
			    		  case "construct":
			    			  //TODO
			    			  break;
			    		  case "healDisease":
			    			  p.healDisease();

			    			  break;
			    		  case "dontDoAnything":
			    			  p.dontDoAnything();
			    		
			    		  default:
			    		    System.out.println("ERROR, THIS SHOULD NEVER BE DISPLAYED");
			    		}
			    	}
		    	
		    	
		    	//if player is a doctor and is in a city 
		    }
		    
		}
		    
	
	
	
	/**  pas besoin de cette méthode si on teste juste après l'insertion de cubes, la création de foyers, la pioche ou la découverte de remèdes
	/** @return 0 if the game is finished, 1 if it is won by the players, and more than 1 if it has been lost by the players.*
	public int isFinished(){
		return (TODO : si remede trouvé) 
				|| InfectionFocusAmount == 8 
				|| this.playersStack.size() < 2);	
	}
	
	

	 
	 *
	 */
	



}

