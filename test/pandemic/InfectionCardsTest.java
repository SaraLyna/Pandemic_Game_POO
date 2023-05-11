package pandemic;
import org.junit.Test;

import pandemic.card.InfectionCards;

import static org.junit.Assert.*;

public class InfectionCardsTest {
    
    @Test
    public void testToString() {
        InfectionCards card = new InfectionCards("Paris", "Blue");
        String expected = " A card Infection for the city named Paris and the disease Blue";
        assertEquals(expected, card.toString());
    }
    
    @Test
    public void testGetCityName() {
        InfectionCards card = new InfectionCards("Paris", "Blue");
        String expected = "Paris";
        assertEquals(expected, card.getCityName());
    }
    
    @Test
    public void testGetDiseaseName() {
        InfectionCards card = new InfectionCards("Paris", "Blue");
        String expected = "Blue";
        assertEquals(expected, card.getDiseaseName());
    }
}
