package pandemic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.*;



public class MappeMonde {
	protected List<Cities> Villes ;
	
		/**
		 * this method allows the reading of a json file
		 * here we read "villes.json"
		 * @param filename
		 * @throws FileNotFoundException
		 */
		public MappeMonde(String filename) throws FileNotFoundException {
		//Creation of the file reader
//filename="villes.json" , plus tard pour l'extension du jeu
		FileReader reader = new FileReader("villes.json"); //reader allows the reading
		
	    JSONObject pandemic = new JSONObject(new JSONTokener(reader));
	    //on lit la carte des villes et on affiche cities et neighbors
		    Iterator<String> entries = pandemic.keys();
		   // System.out.println("affichage des villes");
		    while (entries.hasNext()) {
		    	System.out.println(entries.next());
		    	String entryKey = entries.next();
		    	System.out.println(entryKey);
		    	JSONObject entry = pandemic.getJSONObject(entryKey);
		    	Iterator<String> datakeys = entry.keys();
		    	while (datakeys.hasNext()) {
		    	System.out.println("\t"+datakeys.next());
		    	}	  
		
		    }}}

