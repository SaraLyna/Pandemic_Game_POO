package pandemic;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.junit.Test;

import pandemic.player.Doctor;

public class DoctorTest {
    
    @Test
    public void testhealDiseaseWhenThereNoLeftCube() throws FileNotFoundException {
        // Initialize a game with a city and a disease
    	Game game = new Game("villes.json", 4);
    	City city = new City("ville-11", "3", game);
        Disease disease = Disease.BLUE;
        
        // Initialize a Doctor player in the city
        Doctor doctor = new Doctor("Charles", city, game);
        
        // Initialize the disease cube stock
        HashMap<Disease, Integer> cubesStock = new HashMap<>();
        cubesStock.put(disease, 5);  // Start with 5 cubes of the disease
        city.setCubeCount(disease, 0);
	    doctor.healDisease(disease, city);
	    assertEquals(0, city.getCubeCount(disease));
	    assertEquals(5, (int) cubesStock.get(disease));
	}   

	@Test
	public void testHealDiseaseWhenTheDiseaseIsCured() throws FileNotFoundException{ 
		Game game = new Game("villes.json", 4);
    	City city = new City("ville-11", "3",game);
        Disease disease = Disease.BLUE;
        
        
        // Initialize a Doctor player in the city
        Doctor doctor = new Doctor("Charles", city, game);
        
        // Initialize the disease cube stock
        HashMap<Disease, Integer> cubesStock = new HashMap<>();
        cubesStock.put(disease, 5);
	    city.setCubeCount(disease, 3); 
	    disease.setCured(true);
	    doctor.healDisease(disease, city);
	    assertEquals(0, city.getCubeCount(disease));
	    assertEquals(8, (int) cubesStock.get(disease));
	}   

	@Test
	public void testHealDiseaseWhenTheDiseaseIsNotCured() throws FileNotFoundException { 
		Game game = new Game("villes.json", 4);
    	City city = new City("ville-11", "3",game);
        Disease disease = Disease.BLUE;
            
        // Initialize a Doctor player in the city
        Doctor doctor = new Doctor("Charles", city, game);
        
        // Initialize the disease cube stock
        HashMap<Disease, Integer> cubesStock = new HashMap<>();
        cubesStock.put(disease, 5);
	    cubesStock.put(disease, 3);
	    city.setCubeCount(disease, 3);
	    disease.setCured(false);
	    doctor.healDisease(disease, city);
	    assertEquals(2, city.getCubeCount(disease));
	    assertEquals(4, (int) cubesStock.get(disease));
	}
    
}
