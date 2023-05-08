package pandemic;
import static org.junit.Assert.*;
import java.util.HashMap;

import org.junit.Test;

import pandemic.player.Doctor;

public class DoctorTest {
    
    @Test
    public void testhealDiseaseWhenThereNoLeftCube() {
        // Initialize a game with a city and a disease
    	City city = new City("ville-11", "3");
        Disease disease = Disease.BLUE;
        Game game = null;
        
        // Initialize a Doctor player in the city
        Doctor doctor = new Doctor("Charles", city, game);
        
        // Initialize the disease cube stock
        HashMap<Disease, Integer> cubesStock = new HashMap<>();
        cubesStock.put(disease, 5);  // Start with 5 cubes of the disease
        city.setCubeCount(disease, 0);
	    doctor.healDisease(disease, city, cubesStock);
	    assertEquals(0, city.getCubeCount(disease));
	    assertEquals(5, (int) cubesStock.get(disease));
	}   

	@Test
	public void testHealDiseaseWhenTheDiseaseIsCured(){ 
    	City city = new City("ville-11", "3");
        Disease disease = Disease.BLUE;
        Game game = null;
        
        // Initialize a Doctor player in the city
        Doctor doctor = new Doctor("Charles", city, game);
        
        // Initialize the disease cube stock
        HashMap<Disease, Integer> cubesStock = new HashMap<>();
        cubesStock.put(disease, 5);
	    city.setCubeCount(disease, 3); 
	    disease.setCured(true);
	    doctor.healDisease(disease, city, cubesStock);
	    assertEquals(0, city.getCubeCount(disease));
	    assertEquals(8, (int) cubesStock.get(disease));
	}   

	@Test
	public void testHealDiseaseWhenTheDiseaseIsNotCured() { 
    	City city = new City("ville-11", "3");
        Disease disease = Disease.BLUE;
        Game game = null;        
        // Initialize a Doctor player in the city
        Doctor doctor = new Doctor("Charles", city, game);
        
        // Initialize the disease cube stock
        HashMap<Disease, Integer> cubesStock = new HashMap<>();
        cubesStock.put(disease, 5);
	    cubesStock.put(disease, 3);
	    city.setCubeCount(disease, 3);
	    disease.setCured(false);
	    doctor.healDisease(disease, city, cubesStock);
	    assertEquals(2, city.getCubeCount(disease));
	    assertEquals(4, (int) cubesStock.get(disease));
	}
    
}
