package pandemic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;




/**
 * 
 *
 */
public class MappeMonde {
	protected List<Cities> Villes ;
	
		/**
		 * this method allows the reading of a json file
		 * here we read "villes.json"
		 * @param filename
		 * @throws FileNotFoundException
		 */
	
	public MappeMonde(String filename) throws FileNotFoundException {
	    //filename="villes.json" , plus tard pour l'extension du jeu
		FileReader reader = new FileReader("villes.json"); //reader allows the reading	
		JSONObject pandemic = new JSONObject(new JSONTokener(reader));
		// Creation d'un object JSON pour lire seulement les villes.
		JSONObject villes = pandemic.getJSONObject("cities");
		Iterator<String> villes_entries = villes.keys();
		System.out.println("affichage des villes:");
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
		String[] liste_villes = new String[villes.length()];
		while (villes_entries.hasNext()) {
			// Obtient le nom de la ville.
			String nomVille = villes_entries.next();
			// Obtient le numéro de la ville (basé sur le nom).
			String numberVille = nomVille.replaceAll("[^0-9]", "");
			// La liste des villes commence par 1, mais un tableau en Java 
			// commence à l'index 0. De cette manière, il est nécessaire d'utiliser -1.
			liste_villes[Integer.parseInt(numberVille)-1] = nomVille;
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
		System.out.println("affichage des voisins:");
		while (voisins_entries.hasNext()) {
	        String nomVille = voisins_entries.next();
	        System.out.print(nomVille+" : ");
	    	JSONArray liste_voisins = voisins.getJSONArray(nomVille);
	    	for (int i = 0; i < liste_voisins.length(); i++) {
	    	    System.out.print(liste_voisins.get(i)+" ");
	    	}
	    	System.out.println();
	    }
		
	}
}

