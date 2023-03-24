package pandemic;

import org.junit.Test;
import java.util.*;

/**
 * @author Sara Lyna
 *
 */
public class ScientistTest {
	

    @Test
    public void testDiscoverCure() {
        ScientistRole scientist = new ScientistRole("Scientist",4);
        List<Cards> hand = new ArrayList<>();
        hand.add(new PlayersCards("ville-11","rouge"));
        hand.add(new PlayersCards("ville-44", "rouge"));
        hand.add(new PlayersCards("ville-20", "rouge"));
        hand.add(new PlayersCards("ville-13", "rouge"));

        assertTrue(scientist.discoverCure(hand));
    }

    private void assertTrue(boolean discoverCure) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testFindRemedy() {
        ScientistRole scientist = new ScientistRole("Scientist",4);
        List<Cards> hand = new ArrayList<>();
        hand.add(new PlayersCards("ville-11", "rouge"));
        hand.add(new PlayersCards("ville-44", "rouge"));
        hand.add(new PlayersCards("ville-20", "rouge"));
        hand.add(new PlayersCards("ville-13", "rouge"));

        Diseases redDisease = Diseases.RED;
        List<Diseases> discoveredDiseases = new ArrayList<>();

        assertTrue(scientist.findRemedy(hand, discoveredDiseases, redDisease));
        assertTrue(discoveredDiseases.get(0).getDIseaseName().equals("rouge"));
    }
}