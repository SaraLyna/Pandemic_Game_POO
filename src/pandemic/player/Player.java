package pandemic.player;
import java.util.*;

import pandemic.City;
import pandemic.Disease;
import pandemic.Game;
import pandemic.ResearchCenterException;
import pandemic.card.Card;
import pandemic.chooser.RandomListChooser;


/**
 * An abstract class to model players in the game.
 * No Player object must be instantiated, use one of the availaible roles. (see child classes)
 */
public abstract class Player {
	protected String name;
	protected City location;
	protected ArrayList<Card> CardsInHand; /* the stack of cards in the player's hand */
	protected Game game; /* the Game instance this player has been created in, will be useful for instance to access the cubesStocks*/


	/** 
	 * constructor of the class Players
	 * @param name
	 * @param location
	 * @param game the Game instance this player has been created in
	 */
	public Player(String name, City location, Game game) {
		this.name=name;
		this.location=location;
		this.CardsInHand = new ArrayList<Card>();
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}

	/* should be unused for what we're doing*/
	public void setGame(Game game) {
		this.game = game;
	}

	
	/**
	 * This method overrides toString method and is a getter of the "name" attribute
	 * @return the name of the player
	 */
	public String toString() {
		return this.name;
	}
	
	/**
	 * Getter of the class Players
	 * @return the location of the player
	 */
	public City getLocation() {
		return this.location;
	}
	

	
	
	/**
	 * defausse la carte demandée de la main du joueur
	 */
	public void removeCard(Card c) {
		Iterator<Card> it= CardsInHand.iterator();
		while(it.hasNext()) {
			Card card = it.next();
			if(card.getCityName()==c.getCityName()) {
				it.remove();
			}		
		}
	}
	
	
	/**
	 * Getter of the class Players
	 * @return the player's hand of cards
	 */
	public ArrayList<Card> getCardsInHand() {
	    return this.CardsInHand;
	}

	/**
	 * Setter of the class Players
	 * @param cardsInHand the new stack of cards in the player's hand
	 */
	public void setCardsInHand(ArrayList<Card> cardsInHand) {
	    this.CardsInHand = cardsInHand;
	}
	
	/**
	 * allows to set a new location to the player
	 * @param city ; the city to set
	 */
	
	public void setLocation(City city) {
		this.location = city;
	}
	
	 /**
	  * add a card in the hand of the player 
	 * @param c
	 */
	public void addCard(Card c ) { 
		 this.CardsInHand.add(c); 
	}
	
	
	
	/** will be overriden in the Scientist class
     * @param p
     * @param Disease
	 * check if the city has a Research Center and discover a Cure for a specific disease.
	 * Then discard the 5 players cards.
     */
    public void discover(Disease Disease){
		//TODO IMPLEMENTER RANDOMLISTCHOOSER DANS CETTE METHODE POUR AUTOMATISER
    	int cpt = 0;
		ArrayList<Card> hand = this.getCardsInHand();
		City city = this.getLocation();
		if (city.isResearchCenter()){
			Iterator<Card> it = hand.iterator();
			while (it.hasNext()) {	
				Card card = it.next();
				if(card.getDiseaseName()==Disease.getDiseaseName()) {
					cpt += 1;
				}
			}
			if (cpt > 4) {
				Disease.setCured(true);
				while (it.hasNext()) {
					Card card = it.next();
					if(card.getDiseaseName()==Disease.getDiseaseName()) {
						this.removeCard(card);
					}
				}
			System.out.println("A cure has been found for the disease " + Disease.getDiseaseName());
			}
			else {
				System.out.println(this + " has not enough cards to cure the disease " + Disease.getDiseaseName());
			}
		}
		else {
			System.out.println(this + ", please build a research Center to discover a Cure for the disease " + Disease.getDiseaseName());
		}
    }
	
	
	
	/** will be overriden in Globetrotter
	 * @param playerToMove the player to be moved
	 * @param destination the wanted destination
	 * @throws IllegalArgumentException see above
	 * Calls setLocation() on a random location among the neighboring cities.
	 */
	public void move() throws IllegalArgumentException {
		
		/* note : if we want to add the possibility of using an InputListChooser we need a boolean somewhere that is retrieved by this function to use the correct ListChooser*/
		
		List<City> neighborsList = this.getLocation().getNeighbors();	
		
		RandomListChooser<City> rlc = new RandomListChooser<>();
		City chosenCity = rlc.choose("A city will be chosen randomly for the player " + this + " to move.",neighborsList); /* we use the random list chooser to automatically pick a city*/
				
		/* code à supprimer vu que le randomListChooser est ici cantonné à neighborsList
			if (! neighborsList.contains(destination)){
				//System.out.println("the destination is not among the Player's neighboring cities ");
				//throw new IllegalArgumentException("the destination is not among the Player's neighboring cities ");
				
						
							//choose("false destination", neighborsList);
			}else {*/
		
		this.setLocation(chosenCity);
		System.out.print(this + " has been moved to " + chosenCity.getName()+"\n"); /*here "playerToMove" will output the players name via toString*/
	}
	
	
	
	/**
	 * @param player
	 * this action consist to build a research center
	 * in the same city where the player card is
	 */
	public void construct() throws ResearchCenterException {
		
		//TODO IMPLEMENTER RANDOMLISTCHOOSER DANS CETTE METHODE POUR AUTOMATISER
		ArrayList<Card> cards= this.getCardsInHand();
		City city = this.getLocation();
		Iterator<Card> it= cards.iterator();
		boolean a = false;
		while(it.hasNext()) {
			Card card = it.next();
			if (card.getCityName().equals(city.getName())) {
				if (city.isResearchCenter() == false) {
					city.addResearchCenter();
					this.removeCard(card);
					a = true;
					System.out.println(this + " built a research center in " + city.getName()+"\n");
				}       
		        break; // Exit the loop once a research center is built
			}		
		}
		if(a == false) {
			System.out.println(this + " did not built a research center in " + city.getName()+"\n");
		}

	}
	
	
	/** will be overriden for the Scientist subclass
	 *  this method allow to heal a specific disease from the city the player is in, will be overriden for the Doctor role
	 */
	public void healDisease(){	
		
		City currentCity = this.getLocation();
		ArrayList<Disease> allDiseasesInTheCity = currentCity.getAllDiseases(); //TODO rédiger allDiseasesInTheCity dans City
		
		
		RandomListChooser<Disease> rlc = new RandomListChooser<>();
		Disease chosenDisease = rlc.choose("A disease will be randomly chosen among all those present in the city.", allDiseasesInTheCity);
		
		
		int lastCubes = currentCity.getCubeCount(chosenDisease);// number of cubes of the Disease disease
		 HashMap<Disease, Integer> cubesStock = this.getGame().getCubesStocks(); /*reference to the attribute in Game*/
		
		 if (lastCubes == 0) {
		    System.out.println("There is no cubes of the disease " + chosenDisease.getDiseaseName() + " in the city "+ currentCity.getName() + " anymore" );
		    return;
		 }	
		 
		 else if (chosenDisease.isCured()) {
			 for(int i = 0; i < lastCubes ; i++){
				 currentCity.reduceInfection(chosenDisease);//  the cube of the Disease disease is removed
				cubesStock.put(chosenDisease,cubesStock.get(chosenDisease) + 1);// the removed cube is added to the cubeStock
			 }
			 System.out.println("The disease " + chosenDisease.getDiseaseName()+"  was successfully treated thanks to the discovery of the cure !");
			 return; 
		 }	
		 
		 else { 
			 currentCity.reduceInfection(chosenDisease);//  the cube of the Disease disease is removed
			 cubesStock.put(chosenDisease,cubesStock.get(chosenDisease) + 1);
			 System.out.println("a cube of the disease "+ chosenDisease.getDiseaseName() +" is removed from the city " + currentCity.getName());
			 return;
		 }
	}

	
	
	/**
	 * this action is to do nothing,
	 * 
	 */
	public void dontDoAnything(){ 
		System.out.println(this + "does not do anything"); /* this will use toString*/
	}
	

	/*
	 * @return the name of the player 
	public String getName() {
		return this.name;
	}*/
	
	

}
