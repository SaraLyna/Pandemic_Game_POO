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
	     city.setCube(3);   
	     assertEquals(city.getCube(Diseases.BLUE),0);
	     doctor.RemoveCubes(Diseases.BLUE);
	   
	}

}
