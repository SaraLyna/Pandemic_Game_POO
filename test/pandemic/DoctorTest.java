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
	     DoctorRole doctor = new DoctorRole("Charles", city);
	     city.setCube(0);   
	     assertEquals(city.getCube(Diseases.BLUE),0);
	     doctor.RemoveCubes(Diseases.BLUE);
	     assertEquals(0, city.getCube(Diseases.BLUE));
	}

}
