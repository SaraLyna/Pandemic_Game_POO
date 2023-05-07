package pandemic.player;
import java.util.*;

import pandemic.City;
import pandemic.Disease;
import pandemic.card.Card;
import pandemic.chooser.RandomListChooser;


/**
 * An abstract class to model players in the game.
 * No Player object must be instantiated, use one of the availaible roles. (see child classes)
 */
public abstract class Player {
	private String name;
	private City location;
	private ArrayList<Card> CardsInHand; /* the stack of cards in the player's hand */
						
						//protected  List<Player> thePlayers; //voir si utilisable, pb d'actualisations entre les listes des différents joueurs, pour qu'elles soient synchronisées il faudrait utiliser addPlayer sur chacun des joueurs
																//ça ferait plus de sens de stocker ça dans Game je pense

	/** 
	 * constructor of the class Players
	 * @param name
	 * @param location
	 */
	public Player(String name, City location) {
		this.name=name;
		this.location=location;
		this.CardsInHand = new ArrayList<Card>();
	}
	

	/**
	 * Getter of the class Players
	 * @return the name of the player
	 */
	public String getName() {
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
	 *this method allows to discard a card from the player's stack cards if the stack 's size (number of cards it contains) extends 7 (MAX)
	 
	public void discard() {	
		
		this.CardsInHand.remove(this.CardsInHand[0]);
	}
	*/
	
	
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
	
	
	
	/**
     * @param p
     * @param Disease
	 * check if the city has a Research Center and discover a Cure for a specific disease.
	 * Then discard the 5 players cards.
     */
    public void discover(Player p, Disease Disease){
		//TODO IMPLEMENTER RANDOMLISTCHOOSER DANS CETTE METHODE POUR AUTOMATISER
    	int cpt = 0;
		Stack<Card> hand = p.getCardsInHand();
		City city = p.getLocation();
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
	public void move(Player playerToMove) throws IllegalArgumentException {
		
		/* note : if we want to add the possibility of using an InputListChooser we need a boolean somewhere that is retrieved by this function to use the correct ListChooser*/
		
		List<City> neighborsList = playerToMove.getLocation().getNeighbors();	
		
		RandomListChooser<City> rlc = new RandomListChooser<>();
		City chosenCity = rlc.choose("A city will be chosen randomly for the player " + playerToMove.getName() + " to move.",neighborsList); /* we use the random list chooser to automatically pick a city*/
				
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
	public void construct( Player player) {
		
		//TODO IMPLEMENTER RANDOMLISTCHOOSER DANS CETTE METHODE POUR AUTOMATISER
		Stack<Card> cards= player.getCardsInHand();
		City city = player.getLocation();
		Iterator<Card> it= cards.iterator();
		boolean a = false;
		while(it.hasNext()) {
			Card card = it.next();
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
	public void healDisease(Disease disease, City city,HashMap <Disease, Integer> cubesStock){	
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
		System.out.println(this + "does not do anything");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * 	
	 * 
	 * 
	 * 
	 * @return the list of the Players

	public List<Player> getPlayers(){
		return this.thePlayers;
	}
	

	


	 * @param player
	 * add a player in the game

	public void addPlayer(Player player) {
		this.getPlayers().add(player);
	}

	 	 */

}
