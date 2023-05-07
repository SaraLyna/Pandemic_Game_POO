/**
 * 
 */
package pandemic;
import static org.junit.Assert.*;
import org.junit.Test;

import pandemic.player.Expert;

/**
 * @author Sara Lyna
 *
 */
public class ExpertTest {
    private City ville1;
    private City ville2;
    private City ville4;
    
	@Test
	public void testBuildStation() throws ResearchCenterException {
		ville1= new City("ville-5","Secteur 2");
		ville2= new City("ville-2","Secteur 2");
		ville4= new City("ville-4","Secteur 1");
		
	//ExpertRole expert1= new ExpertRole("Sara" ,ville1);
	//ExpertRole expert2= new ExpertRole("Lyna", ville2);
	//ExpertRole expert3= new ExpertRole("Bob", ville4);
	
	assertFalse(ville4.isResearchCenter());
    Expert.BuildStationWoCard(ville1);
    assertTrue(ville1.isResearchCenter());
    
    assertFalse(ville4.isResearchCenter());
    Expert.BuildStationWoCard(ville2);
    assertTrue(ville2.isResearchCenter());
    
    assertFalse(ville4.isResearchCenter());
    Expert.BuildStationWoCard(ville4);
    assertTrue(ville4.isResearchCenter());
    
    
	}

}
