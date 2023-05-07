package pandemic;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Test;

import pandemic.player.GlobetRotter;
import pandemic.player.Player;
import pandemic.player.Roles;

public class GlobetRotterTest {
	
	private Player player;
	private City city1;
	private City city2;
	
	
	
	@Test
	/* 
	public void MoveAnywhereTest(){
		
		city1 = new Cities("City 1", "Secteur 1");
        city2 = new Cities("City 2", "Secteur 2");
		player = new Players("Albert",Roles.GlobetRotter,city1);
		GlobetRotter.moveAnywhere(player,city2);
		assertFalse(player.getLocation().getName().equals(city1.getName()));
		assertTrue(player.getLocation().getName().equals(city2.getName()));		
	}
	*/
	
	public void moveTest() throws FileNotFoundException { 
		MappeMonde m1 = new MappeMonde("villes.json");
		city1 = m1.getVilles()[2];
		player = new Player("Albert",Roles.GlobetRotter, city1 );
		
		city2 = city1.getNeighbors().get(0); //premier voisin listé
		
		assertTrue(player.getLocation().getName().equals(city1.getName()));
		
		//simulation de l'utilisateur qui prends le 1er choix, pour les détails, cf https://stackoverflow.com/questions/31635698/junit-testing-for-user-input-using-scanner
		String input = "1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		GlobetRotter.moveAnywhere(player, city2); //todo : voir si globetrotter est statique ou non
		
		assertFalse(player.getLocation().getName().equals(city1.getName()));
		assertTrue(player.getLocation().getName().equals(city2.getName()));
	}

	}

