package pandemic;
import java.util.*;

public class Cities {
	protected String name ;
	protected List<Cubes> infectionCubes;
	protected List<Cities> neighbors;
	
	
	
	public Cities(String name ) {
		this.name=name;
	}
	//public boolean isInfectionFocus() {
		
	//}
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
