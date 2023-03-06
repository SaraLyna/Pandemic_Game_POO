package pandemic;

/**
 * this class represent the cubes of diseases
 *
 */
public class Cubes {
	
	protected String diseasename;
	
	
	
	/**
	 * @param diseasename
	 */
	public Cubes (String diseasename) {
		this.diseasename=diseasename;
	}
	
	/**
	 * @return the name of the disease
	 */
	public String getDiseaseName() {
		return this.diseasename;
	}
	
	
   
	/**
	 *Returns a string representation of the object.
	 */
	public String toString() {
		return this.diseasename;
		
	}

}
