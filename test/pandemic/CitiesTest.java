package pandemic;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CitiesTest {
    private Cities city1;
    private Cities city2;
    private Cities city3;
    private Cities city4;

    @Before
    public void setUp() throws Exception {
        // Créer les villes
        city1 = new Cities("City 1", "Secteur 1");
        city2 = new Cities("City 2", "Secteur 2");
        city3 = new Cities("City 3", "Secteur 1");
        city4 = new Cities("City 4", "Secteur 2");

        // Ajouter les voisins
        city1.addNeighbors(city2);
        city1.addNeighbors(city3);
        city2.addNeighbors(city1);
        city2.addNeighbors(city4);
        city3.addNeighbors(city1);
        city3.addNeighbors(city4);
        city4.addNeighbors(city2);
        city4.addNeighbors(city3);
    }

    	@Test
    	public void testAddCube() {
    	    // Test ajouter un cube à une ville
    	    city1.addCube(Disease.BLUE);
    	    
    	    assertEquals(1, (int)city1.getAllCubes().get(Disease.BLUE));
    	    
    	    // Test ajouter un cube à la même ville avec la même maladie
    	    city1.resetTurn();
    	    city1.addCube(Disease.BLUE);
    	    assertEquals(2, (int)city1.getAllCubes().get(Disease.BLUE));
    	    
    	    // Test ajouter un cube à la même ville avec une maladie différente
    	    city1.resetTurn();
    	    city1.addCube(Disease.RED);
    	    assertEquals(1, (int)city1.getAllCubes().get(Disease.RED));
    	    
    	    // Test ajouter un cube à une ville qui a déjà été infectée ce tour
    	    city1.addCube(Disease.BLUE);
    	    assertEquals(2, (int)city1.getAllCubes().get(Disease.BLUE));
    }

    	@Test
    	public void testInfectionPropagation() {
    	    // Test propagation de l'infection
    		city1.resetTurn();
    	    city1.addCube(Disease.BLUE);
    		city1.resetTurn();
    	    city1.addCube(Disease.BLUE);
    	    city1.resetTurn();
    	    city1.addCube(Disease.BLUE);
    	    city1.resetTurn();
    	    city1.addCube(Disease.BLUE);
    	    assertEquals(3, (int)city1.getAllCubes().get(Disease.BLUE));
    	    assertEquals(1, (int)city2.getAllCubes().get(Disease.BLUE));
    	    assertEquals(1, (int)city3.getAllCubes().get(Disease.BLUE));
    	    assertEquals(0, (int)city4.getAllCubes().get(Disease.BLUE));
    	    
    	    // Test propagation de l'infection à une ville qui a déjà été infectée ce tour
    	    city2.resetTurn();
    	    city2.addCube(Disease.RED);
    	    assertEquals(0, (int)city1.getAllCubes().get(Disease.RED));
    	    assertEquals(0, (int)city4.getAllCubes().get(Disease.RED));
    }

    	@Test
    	public void testDisplayAllNeighbors() {
    	    // Test afficher tous les voisins
    	    city1.displayAllNeighbors();
    	    // Sortie attendue :
    	    // Les voisins de la City 1 sont :
    	    // City 2
    	    // City 3
    }

        
    	@Test
        public void testGetNeighbors() {
            // Test get neighbors
            List<Cities> neighbors = city1.getNeighbors();
            assertEquals(2, neighbors.size());
            assertEquals(city2, neighbors.get(0));
            assertEquals(city3, neighbors.get(1));
        }
        
        @Test
        public void testGetSector() {
            // Test get sector
            assertEquals("Secteur 1", city1.getSector());
            assertEquals("Secteur 2", city2.getSector());
        }
    }
