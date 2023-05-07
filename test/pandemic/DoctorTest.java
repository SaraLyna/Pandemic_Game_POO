/**
 * 
 */
package pandemic;

import static org.junit.Assert.*;
import org.junit.Test;

import pandemic.player.DoctorRole;

/**
 * @author Sara Lyna
 *
 */
public class DoctorTest {

	@Test
	public void testRemoveCubes() {
		 City city = new City("ville-2","Secteur 1");
	     city.setCubeCount(Disease.BLUE, 3);   
	     assertEquals(city.getCubeCount(Disease.BLUE),3);
	     DoctorRole.RemoveCubes(Disease.BLUE, city);
	     assertEquals(city.getCubeCount(Disease.BLUE),0);
	   
	}

}
