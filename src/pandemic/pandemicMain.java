package pandemic;

import java.io.*;
import java.util.*;

//import org.json.*;

/**
 * en quelques sorte c'est le plateau de jeu
 * this class displays all the code we have been coding
 */
public class pandemicMain {
	
	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String args[]) throws FileNotFoundException {
		
		//INIT
		
		//System.out.println( "\u001B[40m");
		int overallInfectionRate = 2; // Le taux global d'infection 
       MappeMonde Map= new MappeMonde("villes.json");
       //System.out.println("Map");
       Map.displayAllCities();
       Cities v1 = Map.Villes[0];
       Cities v2 = Map.Villes[1];
       Cities v3 = Map.Villes[2];
       Cities v4 = Map.Villes[3];
       v1.addCube(Diseases.RED);
       v2.addCube(Diseases.RED);
       Map.endInfectionTurn();
       System.out.println();
       v1.addCube(Diseases.RED);
       v2.addCube(Diseases.RED);
       Map.endInfectionTurn();
       System.out.println();
       v1.addCube(Diseases.RED);
       v2.addCube(Diseases.RED);
       Map.endInfectionTurn();
       System.out.println();
       System.out.println();
       System.out.println("Etat de la ville v1");
       System.out.println(v1);
       System.out.println();
       v1.addCube(Diseases.RED);
       System.out.println();
       //
       v3.addCube(Diseases.BLUE);
       v4.addCube(Diseases.BLACK);
       Map.endInfectionTurn();
       System.out.println();
       v3.addCube(Diseases.RED);
       v4.addCube(Diseases.YELLOW);
       Map.endInfectionTurn();
       System.out.println();
       v3.addCube(Diseases.RED);
       v4.addCube(Diseases.BLACK);
       Map.endInfectionTurn();
       System.out.println();
       System.out.println();
       System.out.println("Etat de la ville v3");
       System.out.println(v3);
       System.out.println();
       v3.addCube(Diseases.BLUE);
       System.out.println();
       System.out.println();
       
       
        
       System.out.println("Display the number of cards in each pack of cards :");
       PlayersPaquet paquetPlayers=new PlayersPaquet();
       System.out.println("The number of cards Players is : " + paquetPlayers.nbCartes());
       InfectionPaquet paquetInfection=new InfectionPaquet();
       System.out.println("The number of cards Infection is : " + paquetInfection.nbCartes());
       HashMap<Diseases, Integer> cubesStock = new HashMap<>();// the stock of the cubes
       cubesStock.put(Diseases.BLACK,4);// there are 4 cubes of the diseases black in the stock
       cubesStock.put(Diseases.RED,4);// there are 4 cubes of the diseases red in the stock
       cubesStock.put(Diseases.BLUE,4);// there are 4 cubes of the diseases blue in the stock
       cubesStock.put(Diseases.YELLOW,4);// there are 4 cubes of the diseases yellow in the stock
       
       
    
       
       
       System.out.println("Start by shuffling the cards ,");
       paquetPlayers.melanger();
       paquetInfection.melanger();
       
       
       System.out.println("We create the four players by assigning each a specific role :");
       System.out.println("Sara is Doctor");
       System.out.println("Lyna is Expert");
       System.out.println("Anais is Scientist");
       System.out.println("Charles is GlobetRotter");
       Players Sara = new Players("Sara",Roles.Doctor,v1);
       Players Lyna = new Players("Lyna",Roles.Expert, v1);
       Players Anais = new Players("Anais",Roles.Scientist,v1);
       Players Charles = new Players("Charles",Roles.GlobetRotter, v1);
       System.out.println();
       System.out.println();
       System.out.println();
       
       
       System.out.println("After that, we put the players on the city map ,");
       /*
       put(Lyna,Map);
       put(Sara,Map);
       put(Anais,Map);
       put(Charles,Map);
       */
       System.out.println();
       System.out.println("We start the game !");
       System.out.println();
       

       
       System.out.println("First of all, we draw two Infection cards : ");
       InfectionCards une = paquetInfection.tirerCarte();
       InfectionCards deux=paquetInfection.tirerCarte();
       System.out.println("First card Infection : " + une.toString());
       System.out.println("Second card infection : " + deux.toString());
       System.out.println();

       for(Cities city : Map.getVilles()) {
    	   if( city.getName().equals(une.getCityName())) {
    		   city.addCube(Diseases.nameToDisease(une.getDiseaseName()));
    		   city.toString();
    		   System.out.println("City state : " + city.getName());
    		   System.out.println(city);
    	   }
    	   
       }
       

       for(Cities city : Map.getVilles()) {
    	   if( city.getName().equals(deux.getCityName())) {
    		   city.addCube(Diseases.nameToDisease(deux.getDiseaseName()));
    		   city.toString();
    		   System.out.println("City state : " + city.getName());
    		   System.out.println(city);
    	   }
    	   
       }
       
       
       System.out.println();
       
       System.out.println("Then each player in turn draws two player cards :"); //because there is four players
       System.out.println("************");
       System.out.println(" First turn ");
       System.out.println("************");
       System.out.println();
       
       
       //FIRST TURN FOR EACH PLAYER
       System.out.println("First player : Sara ");
       pandemicMain.makePlayerTakeATurn(Sara, paquetPlayers);
       Actions.move(Sara, v2); //allowed because v1 and v2 are neighboring cities
       DoctorRole.RemoveCubes(Diseases.RED, v2);//retire tous les cubes
       Actions.DontDoAnything(); //ne fait rien
       
       System.out.println("Second player : Lyna");
       pandemicMain.makePlayerTakeATurn(Lyna, paquetPlayers);
       Actions.DontDoAnything();   //  4 ACTIONs POUR LYNA
       Actions.healDisease(Diseases.RED, v1, cubesStock);
       try { ExpertRole.BuildStationWoCard(v1);
       } catch (ResearchCenterException e) { 
    	   // TODO Auto-generated catch block e.printStackTrace(); }
       }
       Actions.move(Lyna, v1);
       
       
       System.out.println("Third player: Anais");
       pandemicMain.makePlayerTakeATurn(Anais, paquetPlayers);
       
      	
       System.out.println();
       System.out.println("Fourth player: Charles");
       pandemicMain.makePlayerTakeATurn(Charles, paquetPlayers);
       
       System.out.println(Charles.getName()+ " must do 4 actions ");
       System.out.println();
       System.out.println("moving action");
       //déplacer charles dans la ville 3
       GlobetRotter.moveAnywhere(Charles,v3);
       System.out.println();
       System.out.println();
       System.out.println("Do nothing action");
       Actions.DontDoAnything();
       System.out.println();
       System.out.println("constructing action");
       Charles.addCard(new PlayersCards("ville-3", "rouge"));
       Actions.construct(Charles);
       // we added 4 player cards of the disease rouge to charles's hand so he can find the cure of this disease
       Charles.addCard(new PlayersCards("ville-19", "rouge"));
       Charles.addCard(new PlayersCards("ville-23", "rouge"));
       Charles.addCard(new PlayersCards("ville-24", "rouge"));
       Charles.addCard(new PlayersCards("ville-25", "rouge"));
       Charles.addCard(new PlayersCards("ville-29", "rouge"));
       System.out.println();
       System.out.println("discovering action");
       Actions.discover(Charles,Diseases.RED);
       System.out.println();
       System.out.println("healing action ");
       Actions.healDisease(Diseases.RED, v3, cubesStock);
       
       System.out.println();
       
       
       System.out.println("*************");
       System.out.println(" Second turn ");
       System.out.println("*************");
       
       System.out.println();
       
       System.out.println("First player : Sara ");
       PlayersCards l1=paquetPlayers.tirerCarte();
       PlayersCards l2=paquetPlayers.tirerCarte();
       Sara.addCard(l1);
       Sara.addCard(l2);
       System.out.println("Sara" + l1.toString());
       System.out.println("Sara" + l2.toString());
       Stack<Cards> sara=Sara.getCardsInHand();
       System.out.println("Sara has " + sara.size()+ " cards in her hand ");
       //System.out.println(sara.get(1));
       System.out.println();
       Actions.move(Sara, v3); 
       DoctorRole.RemoveCubes(Diseases.RED, v3);//retire tous les cubes
       Actions.DontDoAnything(); //ne fait rien
       
       System.out.println("Second player : Lyna");
       PlayersCards l3=paquetPlayers.tirerCarte();
       PlayersCards l4=paquetPlayers.tirerCarte();       
       Lyna.addCard(l3);
       Lyna.addCard(l4);
       System.out.println("Lyna" + l3.toString());
       System.out.println("Lyna" +l4.toString());
       Stack<Cards> lyna=Lyna.getCardsInHand();
       System.out.println("Lyna has "+ lyna.size() +" cards in her hand");
       //System.out.println(lyna.get(1));
       //4 ACTIONs POUR LYNA 
       try { ExpertRole.BuildStationWoCard(v4);
       } catch (ResearchCenterException e) { 
    	   // TODO Auto-generated catch block e.printStackTrace(); }
       }
       Actions.move(Lyna,v4);  
       Actions.healDisease(Diseases.BLACK, v4, cubesStock);
       Actions.discover(Lyna, Diseases.BLACK);
      
       System.out.println();
       
       
       System.out.println("Third player: Anais");
       PlayersCards l5=paquetPlayers.tirerCarte();
       PlayersCards l6=paquetPlayers.tirerCarte();       
       Anais.addCard(l5);
       Anais.addCard(l6);
       System.out.println("Anais" + l5.toString());
       System.out.println("Anais" + l6.toString());       
       Stack<Cards> anais=Anais.getCardsInHand();
       System.out.println("Anais has " + anais.size() +" cards in her hand");
       //System.out.println(anais.get(1));
       System.out.println();
       System.out.println();
       System.out.println(Anais.getName() + " must do 4 actions ");
       System.out.println();
       System.out.println("constructing action");
       // Anais 's action (heal the disease red)
       Actions.construct(Anais);// method construct
       System.out.println();
       System.out.println("Discovering action");
       Actions.discover(Anais, Diseases.RED); // method discover 
       System.out.println();
       System.out.println("healing action");
       System.out.println("Before healing: " + v1);
       Actions.healDisease(Diseases.RED, v1, cubesStock);// cause Anais is not a doctor and the disease red is not healed, she can only remove on cube of this disease in the city v1
       System.out.println("After healing: " + v1);
       System.out.println("the number of cubes of the disease red in the cubsStock rises to "+ cubesStock.get(Diseases.RED));
       System.out.println();
       System.out.println("Do nothing action");
       Actions.DontDoAnything();//Do nothing method
       System.out.println();
       
       
       System.out.println("Fourth player : Charles");
       PlayersCards l7=paquetPlayers.tirerCarte();// a players card
       PlayersCards l8=paquetPlayers.tirerCarte(); // this is an epidemic card
       //todo? faire en sorte que la carte en question soit réellement de type EpidemicCards ?
       overallInfectionRate ++; // we increase the global rate of infection
       System.out.println("Charles picked an Epidemic card" + l8 + ", he must now pick an Infection card");
       InfectionCards l9=paquetInfection.tirerCarte(); 
       Charles.addCard(l7);
       System.out.println("Charles" + l7.toString());   
       Stack<Cards> charles=Charles.getCardsInHand();
       System.out.println("Charles has " + charles.size()+" cards in his hand");
       System.out.println("A cube of the disease " + l9.getDiseaseName() + " is added to the city named " + l9.getCityName()  );
       
       //discover action combined to heal action (charles's action)
       System.out.println();
       System.out.println();
       System.out.println(Charles.getName()+ " must do 4 actions ");
       System.out.println();
       System.out.println("discovering Action");
       Actions.discover(Charles,Diseases.RED);//method discover
       System.out.println();
       System.out.println(" healing action");
       System.out.println("Before healing: " + v3);
       Actions.healDisease(Diseases.RED, v3, cubesStock);//healing method
       System.out.println("After healing: " +v3);
       System.out.println("the number of cubes of the disease red in the cubsStock rises to "+ cubesStock.get(Diseases.RED));
       System.out.println();
       System.out.println( " do nothing action");
       Actions.DontDoAnything();// Do nothing action
       System.out.println();
       System.out.println("moving action");
       GlobetRotter.moveAnywhere(Charles, v3.neighbors.get(3));// move action
       System.out.println();
       System.out.println();
       
       for(Cities city : Map.getVilles()) {
    	   if( city.getName().equals(l9.getCityName())) {
    		   city.addCube(Diseases.nameToDisease(l9.getDiseaseName()));
    		   city.toString();
    		   System.out.println("City state : " + city.getName());
    		   System.out.println(city);
    	   }
    	   
       }
       
       System.out.println("we re-put the discarded  card Infection  in the InfectionPaquet ");
       paquetInfection.addCarte(l9);
       
       System.out.println();
       System.out.println("the global rate of infection is : "+overallInfectionRate);      
       System.out.println();
       System.out.println("...");
       
       
       
	}
	
	
	/**
	 * Acts everything a player is supposed to do during their turn, except for the action that must be manually acted out after using this method.
	 * @param currentPlayer the player that will take this turn
	 * @param currentDeck the PlayersPaquet deck that is currently in use for this game
	 * 
	 * NB : cette méthode est améliorable en incluant le message "tour du [n]ième joueur qui est [nom du joueur]" si les parties à codées sont longues et/ou de longueur variable
	 */
	
	static void makePlayerTakeATurn(Players currentPlayer, PlayersPaquet currentDeck) {
					PlayersCards l1=currentDeck.tirerCarte();
				   PlayersCards l2=currentDeck.tirerCarte();
				   
				   currentPlayer.addCard(l1);
				   currentPlayer.addCard(l2);
				   
				   System.out.println("Player " + currentPlayer.getName() + " "+ l1.toString() + " and "+ l2.toString());
				   Stack<Cards> hand=currentPlayer.getCardsInHand();
				   System.out.println(currentPlayer.getName() + " has " + hand.size()+ " cards in his/her hand. \n");
				   
				   //si on veut mettre des actions aléatoires et/ou du choix d'actions ça peut être à cet endroit
	}
	
	
	/*
	private static void put(Players player, MappeMonde map) {
		// TODO Auto-generated method stub
		
	}*/
	
}
