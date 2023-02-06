package pandemic;


/**
 * @author saralyna.ouyahia.etu
 *
 */
public class Diseases {
	protected String diseases;
	
	/**
	 * @param diseases
	 */
	public Diseases(String diseases) {
		this.diseases=diseases;
	}
	/**
	 * @return
	 */
	public String getName() {
		return this.diseases;
	}
	/**
	 *
	 */
	public String toString() {
		return "the name of this city is :"+this.getName();
	}
}
