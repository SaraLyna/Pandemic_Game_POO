package pandemic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * @author saralyna.ouyahia.etu
 *
 */
public class MappeMonde {
	protected List<Cities> Villes ;
	
		public MappeMonde(String filename) throws FileNotFoundException {
		//Creation of the file reader
		FileReader reader = new FileReader(filename);
		
	    JSONObject pandemic = new JSONObject(new JSONTokener(reader));
	    
		    Iterator<String> entries = Pandemic.keys();
		    while (entries.hasNext()) {
		    	entries.next();
		    }
	    }
}
