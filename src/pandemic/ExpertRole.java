package pandemic;


/**
 * this class represents the action of the Expert
 *
 */
public class ExpertRole extends Actions {
	/**
	c'est en relation avec l'action construire
	il n’a pas besoin de disposer de carte joueur pour construire une station
	 */
	
	private String name;
	
	/**
	 * constructor of the class ExpertRole
	 * @param name
	 * @param city
	 */
	public ExpertRole(String name, Cities city) {
		super();	
		this.setName(name);
	}
	
	
	/**
	 * @param city
	 * this method builds a research station without a card to build it
	 * and if there is already a station it throws an exception
	 */
	public static void BuildStationWoCard(	Cities city) throws ResearchCenterException {
		if(! city.isResearchCenter()) {
			city.addResearchCenter();
			System.out.println("A new research station was built by the expert in :" + city.getName());
		}
		else {
			throw new ResearchCenterException("this city already has a research station");
		}	
	}
	
	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
