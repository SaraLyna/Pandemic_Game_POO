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
	     city.setCubeCount(Diseases.BLUE, 3);   
	     assertEquals(city.getCubeCount(Diseases.BLUE),3);
	     DoctorRole.RemoveCubes(Diseases.BLUE, city);
	     assertEquals(city.getCubeCount(Diseases.BLUE),0);
	   
	}

}
