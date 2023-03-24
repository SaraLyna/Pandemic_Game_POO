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
       
       
       
      // PlayersCards CartesJoueurs = new PlayersCards(Cities, String);
      // InfectionCards CartesInfection = new InfectionCards(Cities, String);
       
     //  CartesJoueurs.addCarte(new PlayersCards("ville-10","rouge"));
       //CartesInfection.addCarte(new InfectionCards("ville-15","bleu"));
       
       
     //  PlayersCards.melanger();
      // InfectionCards.melanger();

       
	}
	
}
