package pandemic;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayersPaquetTest {

    @Test
    public void testInitCards() {
        PlayersPaquet paquet = new PlayersPaquet();
        assertEquals(52, paquet.nbCartes());
    }
    
    @Test
    public void testAddCarte() {
        PlayersPaquet paquet = new PlayersPaquet();
        PlayersCards card = new PlayersCards("ville-50", "noir");
        paquet.addCarte(card);
        assertEquals(53, paquet.nbCartes());
        assertFalse(paquet.tirerCarte().equals(card));
    }
    
    @Test
    public void testMelanger() {
        PlayersPaquet paquet = new PlayersPaquet();
        PlayersCards firstCard = paquet.tirerCarte();
        paquet.melanger();
        assertFalse(paquet.tirerCarte().equals(firstCard));
    }
    
    @Test
    public void testTirerCarte() {
        PlayersPaquet paquet = new PlayersPaquet();
        PlayersCards firstCard = paquet.tirerCarte();
        assertEquals(51, paquet.nbCartes());
        assertTrue(paquet.tirerCarte() != firstCard);
    }
    
    @Test
    public void testNbCartes() {
        PlayersPaquet paquet = new PlayersPaquet();
        assertEquals(52, paquet.nbCartes());
        paquet.tirerCarte();
        assertEquals(51, paquet.nbCartes());
    }
}
