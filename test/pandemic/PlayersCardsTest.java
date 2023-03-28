package pandemic;

import org.junit.Test;
import static org.junit.Assert.*;


public class PlayersCardsTest {

    @Test
    public void testToString() {
        PlayersCards card = new PlayersCards("France", "Red");
        String expected = " has a player card for the city named France and the disease Red";
        assertEquals(expected, card.toString());
    }

    @Test
    public void testGetCityName() {
        PlayersCards card = new PlayersCards("London", "Red");
        String expected = "London";
        assertEquals(expected, card.getCityName());
    }

    @Test
    public void testGetDiseaseName() {
        PlayersCards card = new PlayersCards("Tokyo", "Yellow");
        String expected = "Yellow";
        assertEquals(expected, card.getDiseaseName());
    }
}

