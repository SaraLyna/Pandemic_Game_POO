package pandemic;
import java.util.*;
import java.lang.*;

public class Cities {
	protected String name ;
	protected List<Cubes> infectionCubes;// faire une hashmap
	protected List<Cities> neighbors;
	protected String sector;
	protected boolean isReasearchCenter;
	protected boolean isInfectionFocus;
	
	
	
	
	/**
	 * @param name
	 * @param neighbors
	 * @param sector
	 */
	public Cities(String name, List<Cities>neighbors, String sector) {
		this.name=name;
		this.neighbors = neighbors;
		this.sector = sector;
		this.isReasearchCenter = false;
		this.isInfectionFocus = false;
		
	}
	
	
	/**public void becomeInfectionFocus() {
		Map <String,Integer> count = new HashMap<>();
		Set<String> theKeys = count.keySet();
		Iterator<Cubes>it_key = this.infectionCubes.iterator();
		 while(!this.isInfectionFocus){
			Cubes c = it_key.next();
			if(! count.containsKey(c.getDiseaseName())){
				count.put(c.getDiseaseName(),1);
			}
			else {
				
				count.put(c.getDiseaseName(),count.get(c.getDiseaseName()+1));
				if(count.get(c.getDiseaseName()) == 3) {
					this.isInfectionFocus = true;
					//this.infectionPropagation();
				}
			}
		}
	}*/
	
	
	
	private void infectionPropagation() {
		
		for(Cities c : this.neighbors) {
			c.infectionCubes.add(new cubes());
		}
	}
	
	
	public boolean isInfectionFocus() {
		
		return this.isInfectionFocus;
	}
	
	
	public String getName() {
		return this.name;
	}
	 
	public List<Cubes> getAllCubes() {
	      return this.infectionCubes;
	   }
	 
	public List<Cities> getAllCities() {
	      return this.neighbors;
	   }
	
	public String toString() {
		return "the name of this city is " + this.name ;
	}
}
