package pandemic;


/**
 * this class represents the action of the Expert
 *
 */
public class ExpertRole extends Actions {
	//en relation avec l'action construire
	//n’a pas besoin de disposer de carte joueur pour construire une station
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
	 * 
	 * @param city
	 * this method builds a research station without a card to build it
	 * and if there is already a station it throws an exception
	 */
	public void BuildStationWoCard(	Cities city) throws ResearchCenterException {
		if(! city.isResearchCenter()) {
			city.addResearchCenter();
			System.out.println("Une nouvelle station de recherche a été construite par l'expert dans :" + city.getName());
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
