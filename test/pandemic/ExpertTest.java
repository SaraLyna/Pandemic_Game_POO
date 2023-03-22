/**
 * 
 */
package pandemic;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Sara Lyna
 *
 */
public class ExpertTest {
    private Cities ville1;
    private Cities ville2;
    private Cities ville4;
    
	@Test
	public void testBuildStation() throws ResearchCenterException {
		ville1= new Cities("ville-5","Secteur 2");
		ville2= new Cities("ville-2","Secteur 2");
		ville4= new Cities("ville-4","Secteur 1");
		
	ExpertRole expert1= new ExpertRole("Sara");
	ExpertRole expert2= new ExpertRole("Lyna");
	ExpertRole expert3= new ExpertRole("lol");
	
	
	assertFalse(ville1.isResearchCenter());
    expert1.BuildStationWoCard(ville1);
    assertTrue(ville1.isResearchCenter());
    
    assertFalse(ville2.isResearchCenter());
    expert2.BuildStationWoCard(ville2);
    assertTrue(ville2.isResearchCenter());
    
    assertFalse(ville4.isResearchCenter());
    expert3.BuildStationWoCard(ville4);
    assertTrue(ville4.isResearchCenter());
    
    
	}

}
