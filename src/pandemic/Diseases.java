package pandemic;


public class Diseases {
	protected String diseases;
	
	public Diseases(String diseases) {
		this.diseases=diseases;
	}
	public String getName() {
		return this.diseases;
	}
	public String toString() {
		return "the name of this city is :"+this.getName();
	}
}
