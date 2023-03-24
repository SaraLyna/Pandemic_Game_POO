
package pandemic;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

class ScientistRoleTest {

    @Test
    void testDiscoverCure() {
        ScientistRole scientist = new ScientistRole();
        List<Cards> hand = new ArrayList<>();
        hand.add(new Cards("ville-11", "rouge"));
        hand.add(new Cards("ville-44", "rouge"));
        hand.add(new Cards("ville-20", "rouge"));
        hand.add(new Cards("ville-13", "rouge"));

        assertTrue(scientist.discoverCure(hand));
    }

    private void assertTrue(boolean discoverCure) {
		// TODO Auto-generated method stub
		
	}

	@Test
    void testFindRemedy() {
        ScientistRole scientist = new ScientistRole();
        List<Cards> hand = new ArrayList<>();
        hand.add(new Cards("ville-11", "rouge"));
        hand.add(new Cards("ville-44", "rouge"));
        hand.add(new Cards("ville-20", "rouge"));
        hand.add(new Cards("ville-13", "rouge"));

        Diseases redDisease = new Diseases("rouge");
        List<Diseases> discoveredDiseases = new ArrayList<>();

        assertTrue(scientist.findRemedy(hand, discoveredDiseases, redDisease));
        assertEquals(discoveredDiseases.get(0), redDisease);
    }
}