package pandemic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

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
		String filename = args[0];
		
		FileReader reader = new FileReader(filename);
		
	    JSONObject pandemic = new JSONObject(new JSONTokener(reader));
	    
	    {
		    // lecture des entrees du dictionnaire principal: villes
		    Iterator<String> entries = Pandemic.keys();
		    System.out.println("Affichage des villes");
		    while (entries.hasNext()) {
		    	System.out.println(entries.next());
		    }
	    }

	}
}
