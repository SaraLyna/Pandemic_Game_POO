package pandemic;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

//import org.junit.Test;

public class GlobetRotterTest {
	
	private Players player;
	private Cities city1;
	private Cities city2;
	
	
	/*
	@Test 
	public void MoveAnywhereTest(){
		
		city1 = new Cities("City 1", "Secteur 1");
        city2 = new Cities("City 2", "Secteur 2");
		player = new Players("Albert",Roles.GlobetRotter,city1);
		GlobetRotter.moveAnywhere(player,city2);
		assertFalse(player.getLocation().getName().equals(city1.getName()));
		assertTrue(player.getLocation().getName().equals(city2.getName()));
		
	}
	*/
	
	public void moveTest() { 
		MappeMonde m1 = new MappeMonde("data/carte.json");
		city1 = m1.getVilles()[2];
		player = new Players("Albert",Roles.GlobetRotter, city1 );
		
		city2 = city1.getNeighbors().get(0); //premier voisin listé
		
		assertTrue(player.getLocation().getName().equals(city1.getName()));
		
		//simulation de l'utilisateur qui prends le 1er choix, pour les détails, cf https://stackoverflow.com/questions/31635698/junit-testing-for-user-input-using-scanner
		String input = "1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		GlobetRotter.move(player, m1); //todo : voir si globetrotter est statique ou non
		
		assertFalse(player.getLocation().getName().equals(city1.getName()));
		assertTrue(player.getLocation().getName().equals(city2.getName()));
	}

	}

