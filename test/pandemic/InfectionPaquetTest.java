package pandemic;

import static org.junit.Assert.*;

import org.junit.Test;


public class InfectionPaquetTest {

	
//private InfectionPaquet paquet;
    
    @Test
    public void testInitCards() {
    	InfectionPaquet paquet= new InfectionPaquet();
        assertEquals(48, paquet.nbCartes());
    }

    @Test
    public void testAddCarte() {
    	InfectionPaquet paquet= new InfectionPaquet();
        paquet.addCarte(new InfectionCards("ville-50", "bleu"));
        assertEquals(49, paquet.nbCartes());
    }

    @Test
    public void testMelanger() {
    	InfectionPaquet paquet= new InfectionPaquet();
    	// Vérifier que les cartes sont mélangées
    	
        InfectionCards carte1 = paquet.tirerCarte();
        InfectionCards carte2 = paquet.tirerCarte();
        assertNotEquals(carte1, carte2);
    }

    @Test
    public void testTirerCarte() {
    	InfectionPaquet paquet= new InfectionPaquet();
        InfectionCards carte = paquet.tirerCarte();
        assertNotNull(carte);
        assertEquals(47, paquet.nbCartes());
    }
    @Test
    public void testNbCartes() {
    	InfectionPaquet paquet= new InfectionPaquet();
        assertEquals(48, paquet.nbCartes());
        paquet.tirerCarte();
        assertEquals(47, paquet.nbCartes());
    }
    
    

}
