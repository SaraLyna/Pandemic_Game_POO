package pandemic;

public class Cubes {
	
	protected String diseasename;
	
	
	/**
	 * constructor of the class Cubes
	 * @param diseasename
	 */
	public Cubes (String diseasename) {
		this.diseasename=diseasename;
	}
	
	/**
	 * Getter of the class Cubes
	 * @return the name of the disease
	 */
	public String getDiseaseName() {
		return this.diseasename;
	}
	
	
    /**
     * @return a string representation of the object.
     */
	public String toString() {
		return this.diseasename;
		
	}

}
