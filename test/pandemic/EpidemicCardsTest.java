package pandemic;

import org.junit.Test;

import pandemic.card.EpidemicCards;

import static org.junit.Assert.*;

public class EpidemicCardsTest {

    @Test
    public void testToString() {
        EpidemicCards card = new EpidemicCards("New York", "Blue");
        String expected = "A card Epidemic for the city named New York";
        String actual = card.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCityName() {
        EpidemicCards card = new EpidemicCards("New York", "Blue");
        String expected = "New York";
        String actual = card.getCityName();
        assertEquals(expected, actual);
    }
}
