package pandemic;

public class Players {
	private String name;
	private Roles role;
	private Cities location;
	
	public Players(String name, Roles role, Cities location) {
		this.name=name;
		this.role=role;
		this.location=location;
		
		
	}
	public String getName() {
		return this.name;
	}
	public Roles getRole() {
		return this.role;
	}
	public Cities getLocation() {
		return this.location;
	}

}
