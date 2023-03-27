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
       MappeMonde Map= new MappeMonde("villes.json");
       //System.out.println("Map");
       System.out.println();
       Map.displayAllCities();
       Cities v1 = Map.Villes[0];
       Cities v2 = Map.Villes[1];
       v1.addCube(Diseases.RED);
       v2.addCube(Diseases.RED);
       Map.endInfectionTurn();
       v1.addCube(Diseases.RED);
       v2.addCube(Diseases.RED);
       Map.endInfectionTurn();
       v1.addCube(Diseases.RED);
       v2.addCube(Diseases.RED);
       Map.endInfectionTurn();
       System.out.println();
       System.out.println("Etat de la ville v1");
       System.out.println(v1);
       System.out.println();
       v1.addCube(Diseases.RED);
       
       
        
   	   
       PlayersPaquet paquetPlayers=new PlayersPaquet();
       System.out.println(paquetPlayers.nbCartes());
       InfectionPaquet paquetInfection=new InfectionPaquet();
       System.out.println(paquetInfection.nbCartes());
    
       
       
       
       paquetPlayers.melanger();
       paquetInfection.melanger();
       
       Players Sara = new Players("Sara",Roles.Doctor,v1);
       Players Lyna = new Players("Lyna",Roles.Expert, v1);
       Players Anais = new Players("Anais",Roles.Scientist,v1);
       Players Charles = new Players("Charles",Roles.GlobetRotter, v1);
       
       put(Lyna,Map);
       put(Sara,Map);
       put(Anais,Map);
       put(Charles,Map);
       
       
       PlayersCards l1=paquetPlayers.tirerCarte();
       PlayersCards l2=paquetPlayers.tirerCarte();
       
       InfectionCards un = paquetInfection.tirerCarte();
       InfectionCards deux=paquetInfection.tirerCarte();
       System.out.println("Première carte infection: " + un);
       System.out.println("Deuxième carte infection : " + deux);
       
       			
       
//       un.addCube(Diseases.RED);
//       deux.addCube(Diseases.RED);
       
       Lyna.addCard(l1);
       Lyna.addCard(l2);
       System.out.println("Sara" + l1.toString());
       System.out.println("Sara" + l2.toString());
       
       Stack<Cards> lyna=Lyna.getCardsInHand();
       System.out.println(lyna.size());
       //System.out.println(lyna.get(1));
       
       PlayersCards l3=paquetPlayers.tirerCarte();
       PlayersCards l4=paquetPlayers.tirerCarte();
       
       Sara.addCard(l3);
       Sara.addCard(l4);
       System.out.println("Lyna" + l3.toString());
       System.out.println("Lyna" +l4.toString());
       
       Stack<Cards> sara=Sara.getCardsInHand();
       System.out.println(sara.size());
       //System.out.println(sara.get(1));
       
       
       PlayersCards l5=paquetPlayers.tirerCarte();
       PlayersCards l6=paquetPlayers.tirerCarte();
       
       Anais.addCard(l5);
       Anais.addCard(l6);
       System.out.println("Anais" + l5.toString());
       System.out.println("Anais" + l6.toString());
       
       Stack<Cards> anais=Anais.getCardsInHand();
       System.out.println(anais.size());
       //System.out.println(anais.get(1));
       
       PlayersCards l7=paquetPlayers.tirerCarte();
       PlayersCards l8=paquetPlayers.tirerCarte();
       
       Charles.addCard(l7);
       System.out.println("Charles" + l7.toString());
       System.out.println("Charles" + l8.toString());
       //System.out.println("Charles a tiré une carte epidemie");
       
       Stack<Cards> charles=Charles.getCardsInHand();
       System.out.println(charles.size());
       //l8.infectionPropagation(l8.getDiseaseName());
       //l8.getCityName();
       //l8.addCube();
       
	}

	private static void put(Players player, MappeMonde map) {
		// TODO Auto-generated method stub
		
	}
	
}
