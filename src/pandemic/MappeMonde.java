package pandemic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;

public class MappeMonde {
	
		protected List<Cities> Villes ;
		protected String args[];
		
			String filename = args[0];
			
				
		//Creation of the file reader
		FileReader reader = new FileReader(filename);
		
	    JSONObject pandemic = new JSONObject(new JSONTokener(reader));
	    
	    {
		    Iterator<String> entries = Pandemic.keys();
		    System.out.println("Affichage des villes");
		    while (entries.hasNext()) {
		    	System.out.println(entries.next());
		    }
	    }

}
