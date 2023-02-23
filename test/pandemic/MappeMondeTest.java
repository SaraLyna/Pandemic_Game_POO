package pandemic;

import org.junit.Test;
import java.io.FileNotFoundException;

public class MappeMondeTest {
	/**
     * Teste la création d'une carte du monde à partir d'un fichier JSON, l'affichage de toutes les villes et 
     * la fin du tour des épidémies.
     * @throws FileNotFoundException si le fichier JSON spécifié n'est pas trouvé
     */
    @Test
    public void testMappeMonde() {
        try {
            MappeMonde map = new MappeMonde("villes.json");
            map.displayAllCities();
            map.endInfectionTurn();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}