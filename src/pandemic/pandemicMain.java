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
		int overallInfectionRate = 2; // Le taux global d'infection 
       MappeMonde Map= new MappeMonde("villes.json");
       //System.out.println("Map");
       System.out.println();
       Map.displayAllCities();
       System.out.println("/n");
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
       
       
        
       System.out.println("Affichage du nombre de cartes dans chaque paquet");
       PlayersPaquet paquetPlayers=new PlayersPaquet();
       System.out.println("le nombre de cartes players est " + paquetPlayers.nbCartes());
       InfectionPaquet paquetInfection=new InfectionPaquet();
       System.out.println("le nombre de cartes infection est " + paquetInfection.nbCartes());
       //System.out.println("creation of the discarded cards deck");
       
    
       
       
       System.out.println("on commence par mélanger les cartes");
       paquetPlayers.melanger();
       paquetInfection.melanger();
       
       
       System.out.println("on crée les quatres joueurs en attribuant à chacun un role spécifique");
       System.out.println("Sara est Doctor");
       System.out.println("Lyna est Expert");
       System.out.println("Anais est Scientist");
       System.out.println("Charles est GlobetRotter");
       Players Sara = new Players("Sara",Roles.Doctor,v1);
       Players Lyna = new Players("Lyna",Roles.Expert, v1);
       Players Anais = new Players("Anais",Roles.Scientist,v1);
       Players Charles = new Players("Charles",Roles.GlobetRotter, v1);
       System.out.println();
       System.out.println();
       System.out.println();
       
       
       System.out.println("on met les joueurs sur la carte des villes ");
       put(Lyna,Map);
       put(Sara,Map);
       put(Anais,Map);
       put(Charles,Map);
       System.out.println();
       System.out.println("On commence la partie !");
       System.out.println();
       
       
       System.out.println("on tire deux cartes infection: ");
       InfectionCards une = paquetInfection.tirerCarte();
       InfectionCards deux=paquetInfection.tirerCarte();
       System.out.println("Première carte infection : " + une.toString());
       System.out.println("Deuxième carte infection : " + deux.toString());
       System.out.println();

       for(Cities city : Map.getVilles()) {
    	   if( city.getName().equals(une.getCityName())) {
    		   city.addCube(Diseases.nameToDisease(une.getDiseaseName()));
    		   city.toString();
    		   System.out.println("Etat de la ville " + city.getName());
    		   System.out.println(city);
    	   }
    	   
       }
       

       for(Cities city : Map.getVilles()) {
    	   if( city.getName().equals(deux.getCityName())) {
    		   city.addCube(Diseases.nameToDisease(deux.getDiseaseName()));
    		   city.toString();
    		   System.out.println("Etat de la ville " + city.getName());
    		   System.out.println(city);
    	   }
    	   
       }
       
       
       System.out.println();
     
      // public int addCubeCity(int i, Diseases d) {
    	//   List[i].addCube(d);
       //}
      // Map.addCube(parseInt(Villes[],d));
       //un.addCube();
      // deux.addCube(Diseases.RED);
       
       
       System.out.println("Puis chaque joueur tire à son tour deux cartes joueurs :");
       
       System.out.println("premier joueur: Sara ");
       PlayersCards l1=paquetPlayers.tirerCarte();
       PlayersCards l2=paquetPlayers.tirerCarte();
       Sara.addCard(l1);
       Sara.addCard(l2);
       System.out.println("Sara" + l1.toString());
       System.out.println("Sara" + l2.toString());
       Stack<Cards> sara=Sara.getCardsInHand();
       System.out.println("Sara a " + sara.size()+ " cartes players dans sa main");
       //System.out.println(sara.get(1));
       System.out.println();
       
       
       System.out.println("deuxieme joueur; Lyna");
       PlayersCards l3=paquetPlayers.tirerCarte();
       PlayersCards l4=paquetPlayers.tirerCarte();       
       Lyna.addCard(l3);
       Lyna.addCard(l4);
       System.out.println("Lyna" + l3.toString());
       System.out.println("Lyna" +l4.toString());
       Stack<Cards> lyna=Lyna.getCardsInHand();
       System.out.println("Lyna a "+ lyna.size() +" cartes players dans sa main");
       //System.out.println(lyna.get(1));
       System.out.println();
      
       
       
       System.out.println("troisieme joueur: Anais");
       PlayersCards l5=paquetPlayers.tirerCarte();
       PlayersCards l6=paquetPlayers.tirerCarte();       
       Anais.addCard(l5);
       Anais.addCard(l6);
       System.out.println("Anais" + l5.toString());
       System.out.println("Anais" + l6.toString());       
       Stack<Cards> anais=Anais.getCardsInHand();
       System.out.println("Anais a " + anais.size() +" cartes players dans main");
       //System.out.println(anais.get(1));
       System.out.println();
       
       
       System.out.println("quatrieme joueur: Charles");
       PlayersCards l7=paquetPlayers.tirerCarte();// a players card
       PlayersCards l8=paquetPlayers.tirerCarte(); // this is an epidemic card
       overallInfectionRate ++; // we increase the global rate of infection
       System.out.println("Charles picked an epidemic card, he must now pick an infection card");
       InfectionCards l9=paquetInfection.tirerCarte(); 
       Charles.addCard(l7);
       System.out.println("Charles" + l7.toString());   
       Stack<Cards> charles=Charles.getCardsInHand();
       System.out.println("Charles has in his hand " + charles.size()+" player card(s)");
       System.out.println(" a cube of the disease " + l9.getDiseaseName() + " is added to the city named " + l9.getCityName()  );
       
       for(Cities city : Map.getVilles()) {
    	   if( city.getName().equals(l9.getCityName())) {
    		   city.addCube(Diseases.nameToDisease(l9.getDiseaseName()));
    		   city.toString();
    		   System.out.println("Etat de la ville " + city.getName());
    		   System.out.println(city);
    	   }
    	   
       }
       
       System.out.println("we re-put the discarded  infection card  in the InfectionPaquet ");
       paquetInfection.addCarte(l9);
       
       
       System.out.println();
       System.out.println();
       System.out.println("Suite à venir..");
       
	}

	private static void put(Players player, MappeMonde map) {
		// TODO Auto-generated method stub
		
	}
	
}
