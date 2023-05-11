/**
 * 
 */
package pandemic;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import pandemic.player.Expert;



public class ExpertTest {
    private City ville1;
    
	@Test
	public void testBuildStation() throws ResearchCenterException, FileNotFoundException {
		Game game = new Game ("villes.json", 4);
		ville1= new City("ville-5","Secteur 2", game);
		Expert expert  = new Expert("Charles",ville1,game);
		assertFalse(ville1.isResearchCenter);
		expert.construct();
		assertTrue(ville1.isResearchCenter);
		assertEquals(1,game.getNumberOfResearchCenter());
		
	
    
    
	}

}
