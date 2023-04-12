package pandemic;

import java.io.*;
import java.util.*;

//import org.json.*;

/**
 * en quelques sorte c'est les plateau de jeu
 * 
 *this class displays all the code we have been coding
 */

public class pandemicMain {
	
	
	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String args[]) throws FileNotFoundException {
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
       //System.out.println("creation of the discarded cards deck");
       
    
       
       
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
       put(Lyna,Map);
       put(Sara,Map);
       put(Anais,Map);
       put(Charles,Map);
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
       
       System.out.println("Then each player in turn draws two player cards :");
       
       System.out.println("First player : Sara ");
       PlayersCards l1=paquetPlayers.tirerCarte();
       PlayersCards l2=paquetPlayers.tirerCarte();
       Sara.addCard(l1);
       Sara.addCard(l2);
       System.out.println("Sara" + l1.toString());
       System.out.println("Sara" + l2.toString());
       Stack<Cards> sara=Sara.getCardsInHand();
       System.out.println("Sara has " + sara.size()+ " cards Players in her hand");
       //System.out.println(sara.get(1));
       System.out.println();
       
       
       System.out.println("Second player : Lyna");
       PlayersCards l3=paquetPlayers.tirerCarte();
       PlayersCards l4=paquetPlayers.tirerCarte();       
       Lyna.addCard(l3);
       Lyna.addCard(l4);
       System.out.println("Lyna" + l3.toString());
       System.out.println("Lyna" +l4.toString());
       Stack<Cards> lyna=Lyna.getCardsInHand();
       System.out.println("Lyna has "+ lyna.size() +" cards Players in her hand");
       //System.out.println(lyna.get(1));
       System.out.println();
      
       
       
       System.out.println("Third player: Anais");
       PlayersCards l5=paquetPlayers.tirerCarte();
       PlayersCards l6=paquetPlayers.tirerCarte();       
       Anais.addCard(l5);
       Anais.addCard(l6);
       System.out.println("Anais" + l5.toString());
       System.out.println("Anais" + l6.toString());       
       Stack<Cards> anais=Anais.getCardsInHand();
       System.out.println("Anais has " + anais.size() +" cards Players in her hand");
       //System.out.println(anais.get(1));
       System.out.println();
       
       
       System.out.println("Fourth player : Charles");
       PlayersCards l7=paquetPlayers.tirerCarte();// a players card
       PlayersCards l8=paquetPlayers.tirerCarte(); // this is an epidemic card
       overallInfectionRate ++; // we increase the global rate of infection
       System.out.println("Charles picked an Epidemic card" + l8 + ", he must now pick an Infection card");
       InfectionCards l9=paquetInfection.tirerCarte(); 
       Charles.addCard(l7);
       System.out.println("Charles" + l7.toString());   
       Stack<Cards> charles=Charles.getCardsInHand();
       System.out.println("Charles has " + charles.size()+" card Players in his hand");
       System.out.println("A cube of the disease " + l9.getDiseaseName() + " is added to the city named " + l9.getCityName()  );
       
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

	private static void put(Players player, MappeMonde map) {
		// TODO Auto-generated method stub
		
	}
	
}
