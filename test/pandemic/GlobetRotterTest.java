package pandemic;

import static org.junit.Assert.*;

import org.junit.Test;

public class GlobetRotterTest {
	
	private Players player;
	private Cities city1;
	private Cities city2;
	
	@Test 
	public void MoveAnywhereTest(){
		
		city1 = new Cities("City 1", "Secteur 1");
        city2 = new Cities("City 2", "Secteur 2");
		player = new Players("Albert",Roles.GlobetRotter,city1);
		GlobetRotter.moveAnywhere(player,city2);
		assertFalse(player.getLocation().getName().equals(city1.getName()));
		assertTrue(player.getLocation().getName().equals(city2.getName()));
		
	}

	}

