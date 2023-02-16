package pandemic;

import java.io.*;
//import java.util.*;

//import org.json.*;



/**
 * @author saralyna.ouyahia.etu
 *
 */
public class pandemicMain {
	
	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String args[]) throws FileNotFoundException {
       MappeMonde map= new MappeMonde("villes.json");
       //System.out.println("Map");
       
       System.out.println("Etat d'une ville donnée:"+map.getVille("ville-2").getDiseases());
	}
}
