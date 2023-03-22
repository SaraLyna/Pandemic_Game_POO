package pandemic;

/**
 * this class represent the action of the Expert
 *
 */
public class ExpertRole extends Actions {
	//en relation avec l'action construire
	//n’a pas besoin de disposer de carte joueur pour construire une station
	private String name;
	
	public ExpertRole(String name) {
		super();	
		this.name=name;
	}
	/**
	 * 
	 * @param city
	 */
	public void BuildStationWoCard(	Cities city) throws ResearchCenterException {
		if(! city.isResearchCenter()) {
			city.addResearchCenter();
			System.out.println("La station de recherche construite dans la ville est :" + city);
		}
		else {
			throw new ResearchCenterException("this city already has a research station");
		}
			
		
		
	}
	
	

}
