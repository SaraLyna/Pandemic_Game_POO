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
       
       
       
       List<PlayersCards> CartesJoueurs = new ArrayList<PlayersCards>();
       InfectionCards CartesInfection = new InfectionCards("ville1", "bleu");
       
      // CartesJoueurs.addCarte(new PlayersCards("ville-10","rouge"));
      // CartesInfection.addCarte(new InfectionCards("ville-15","bleu"));
       
       
       PlayersCards.melanger();
       InfectionCards.melanger();
       
       Players Sara = new Players("Sara",Roles.Doctor,v1);
       Players Lyna = new Players("Lyna",Roles.Expert, v1);
       Players Anais = new Players("Anais",Roles.Scientist,v1);
       Players Charles = new Players("Charles",Roles.GlobetRotter, v1);
       
       //Map.addPlayer(Lyna);
       //Sara.addCard(Cards);
       //Lyna.tirerCarte(CartesJoueurs);
       //Anais.tirerCarte(CartesJoueurs);
      // Charles.tirerCarte(CartesJoueurs);
       
       
	}
	
}
