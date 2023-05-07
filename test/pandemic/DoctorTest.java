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
public class DoctorTest {

	@Test
	public void testRemoveCubes() {
		 Cities city = new Cities("ville-2","Secteur 1");
	     city.setCubeCount(Disease.BLUE, 3);   
	     assertEquals(city.getCubeCount(Disease.BLUE),3);
	     DoctorRole.RemoveCubes(Disease.BLUE, city);
	     assertEquals(city.getCubeCount(Disease.BLUE),0);
	   
	}

}
