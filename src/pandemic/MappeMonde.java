package pandemic;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

//import java.util.List;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;

/**
 *this class is the representation of the World of pandemic (Carte du monde de la pandémie)
 *this class allows the reading of villes.json (json file)
 */
public class MappeMonde {

	protected City[] Villes ;
	
		/**
		 * this method allows the reading of a json file
		 * constructor of the class MappeMonde
		 * here we read "villes.json" which countains informations about cities and neighbors
		 * @param filename, the name of the json file villes.json
		 * @throws FileNotFoundException if filename can not be found
		 */
	public MappeMonde(String filename) throws FileNotFoundException {
	    //filename="villes.json" , plus tard pour l'extension du jeu
		FileReader reader = new FileReader(filename); //reader allows the reading	
		JSONObject pandemic = new JSONObject(new JSONTokener(reader));
		// Creation d'un object JSON pour lire seulement les villes.
		JSONObject villes = pandemic.getJSONObject("cities");
		Iterator<String> villes_entries = villes.keys();
		System.out.println("Cities :");
		/*Les villes du fichier ne sont pas lues en ordre à cause des 
		 * caractéristiques de la bibliothèque JSON pour JAVA. Ce n'est pas 
		 * un problème ni un bug. Le site de la documentation JSON précise que 
		 * « vous ne pouvez pas et ne devez pas vous fier à l'ordre des 
		 * éléments dans un objet JSON ». Il a également précisé que JSON est un
		 * format de données structurées sous forme de paires « clé/valeur ». 
		 * Par conséquent, les bibliothèques JSON peuvent réorganiser l'ordre 
		 * des éléments comme bon leur semble.
		 * 
		 * Pour les classer, je vous conseille de créer un tableau et d'utiliser 
		 * les commandes suivantes.
		 */
		this.Villes= new City[villes.length()];
		String[] liste_villes = new String[villes.length()];
		while (villes_entries.hasNext()) {
			// Obtient le nom de la ville.
			String nomVille = villes_entries.next();
			// Obtient le numéro de la ville (basé sur le nom).
			String numberVille = nomVille.replaceAll("[^0-9]", "");
			// La liste des villes commence par 1, mais un tableau en Java 
			// commence à l'index 0. De cette manière, il est nécessaire d'utiliser -1.
			liste_villes[Integer.parseInt(numberVille)-1] = nomVille;
			this.Villes[Integer.parseInt(numberVille)-1]= new City(nomVille, villes.get(nomVille).toString());//erreur
			
		}
		// Imprimer la liste des villes. 
		for(int j = 0; j < liste_villes.length; j++) {
			System.out.println(liste_villes[j]);		
		}
		/*Le programme lira maintenant les voisins. J'ai suivi l'ordre établi 
		 * par JSON ici. Vous pouvez les trier en suivant la procédure ci-dessus.
		 */
		JSONObject voisins = pandemic.getJSONObject("neighbors");
		Iterator<String> voisins_entries = villes.keys();
		System.out.println("Neighbors :");
		while (voisins_entries.hasNext()) {
	        String nomVille = voisins_entries.next();
	        System.out.print(nomVille+" : ");
	    	JSONArray liste_voisins = voisins.getJSONArray(nomVille);
	    	String numberVille = nomVille.replaceAll("[^0-9]", "");
	    	for (int i = 0; i < liste_voisins.length(); i++) {
	    		String nomNeighbor = liste_voisins.get(i).toString();
	    		String numberNeighbor = nomNeighbor.replaceAll("[^0-9]", "");
	    		this.Villes[Integer.parseInt(numberVille)-1].addNeighbors(this.Villes[Integer.parseInt(numberNeighbor)-1]);
	    		
	    	    System.out.print(liste_voisins.get(i)+" ");
	    	}
	    	System.out.println();
	    }
	}
	
	
	/**
	 * this method displays all the cities in the Map world
	 * it goes all over elements of the list of cities and displays them with toString() method of the class Cities
	 */
	public void displayAllCities() {
		for(City cities : this.Villes) {
			System.out.println(cities);
		}
	}
	
	
	/**
	 * @return a list of the cities
	 */
	public City[] getVilles() {
		return this.Villes;
	}

	
	/**
	 * this method is used for the final tour of infection
	 * it goes all over the cities of the map world and initialize the boolean hasBeenInfectedTurn
	 * of each city with calling the method resetTurn of the class Cities
	 */
	public void endInfectionTurn() {
		for(City cities : this.Villes) {
			cities.resetTurn();
		}
	}
	    
	}
	
	
	
	
	
	
	
	



