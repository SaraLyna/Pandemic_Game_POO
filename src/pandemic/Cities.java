package pandemic;
import java.util.*;
//import java.lang.*;

/**
 * 
 *
 */
public class Cities {
	protected String name ;
	protected List<Cubes> infectionCubes;// faire une hashmap
	protected List<Cities> neighbors;
	protected String sector;
	protected boolean isReasearchCenter;
	protected boolean isInfectionFocus;
	protected Map<String,Integer> cubes;
	
	
	
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
		this.cubes= new HashMap<String,Integer>(); 
		this.cubes.put("bleu", 0);
		this.cubes.put("jaune", 0);
		this.cubes.put("noir", 0);
		this.cubes.put("rouge", 0);
		
		
		
	}
	
	
	/*public void becomeInfectionFocus(Cubes c) {// à revoir!!! mettre le paramètre (cube occasionnant l'infection)
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
	}
	*/
	
	/**
	 * allow to start an infection propagation 
	 * @param c, the cube to add
	 */
	private void infectionPropagation(Cubes c) {
		
		for(Cities neighbor : this.neighbors) {
			neighbor.addCube(c);
		}
	}
	
	/**
	 * allow to add a cube to a city if it is contaminated
	 * if the count of the cube list of the city is more than 3, this city become an infection propagation
	 * @param c, the cube to add
	 */
	public void addCube(Cubes c) {
		if(this.infectionCubes.size() < 3) {
			int  a  = this.cubes.get(c.getDiseaseName());
			this.cubes.put(c.getDiseaseName(), a++);
			//this.infectionCubes.add(c);
		}
		else {
			this.infectionPropagation(c);
			this.isInfectionFocus = true;
		}
	}
	
	public Map<String, Integer> getDiseases(){
		return this.cubes;
	}
	
	
	public int getNbDisease(String name) {
		return this.cubes.get(name);
	}
	/**
	 * @return
	 */
	public boolean isInfectionFocus() {
		
		return this.isInfectionFocus;
	}
	
	/**
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	 /**
	 * @return
	 */
	public List<Cubes> getAllCubes() {
	      return this.infectionCubes;
	   }
	 /**
	 * @return
	 */
	public List<Cities> getAllCities() {
	      return this.neighbors;
	   }
	/**
	 *
	 */
	public String toString() {
		return "the name of this city is " + this.name ;
	}
}
