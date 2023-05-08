package pandemic;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import pandemic.player.Doctor;

public class DoctorTest {
    
    @Test
    public void testhealDiseaseWhenThereNoLeftCube() throws FileNotFoundException {
        
    	Game game = new Game("villes.json", 4);
    	City city = new City("ville-11", "3", game);
        Disease disease = Disease.BLUE;
        
        // Initialize a Doctor player in the city
        Doctor doctor = new Doctor("Charles", city, game);
	    doctor.healDisease();
	    assertEquals(0, city.getCubeCount(disease));
	}   

    
}
