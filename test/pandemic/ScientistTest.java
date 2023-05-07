package pandemic;

import org.junit.Test;

import pandemic.card.Card;
import pandemic.card.PlayersCards;
import pandemic.player.Player;
import pandemic.player.Roles;
import pandemic.player.Scientist;

import static org.junit.Assert.*;


import java.util.*;

/**
 * @author Sara Lyna
 *
 */
public class ScientistTest {
	

	@Test
	public void testdiscover() {
		City city1= new City("ville-11","3");
		Disease disease1=Disease.RED;
		Disease disease2= Disease.BLUE;
		Player player1=new Player("Ana",Roles.Expert,city1);	
		PlayersCards card1=new PlayersCards("ville-11","noir");
		PlayersCards card3=new PlayersCards("ville-16","rouge");
		player1.addCard(card1);
		player1.addCard(card3);
		
		// vérifie qu'une maladie ne peut pas etre guérie si le joueur n'est pas dans une ville avec un centre de recherche
		Scientist.discoverCure(player1, disease1);
		assertFalse(disease1.isCured());
		assertFalse(disease2.isCured());	
		
		//deplacer un joueur dans une ville qui contient un centre de recherche 
		city1.addResearchCenter();
		
		Scientist.discoverCure(player1, disease1);
		assertFalse(disease1.isCured());
		assertFalse(disease2.isCured());
		
		// ajoute une autre carte de la meme couleur dans la main du joueur
		PlayersCards card6=new PlayersCards("ville-12","rouge");
		PlayersCards card7=new PlayersCards ("ville-45","rouge");
		PlayersCards card8=new PlayersCards("ville-17","rouge");
		player1.addCard(card6);
		player1.addCard(card7);
		player1.addCard(card8);

		
		Scientist.discoverCure(player1, disease1);
		assertTrue(disease1.isCured());
		assertFalse(disease2.isCured());
		
		}

    private void assertTrue(boolean discoverCure) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testFindRemedy() {
        Scientist scientist = new Scientist("Scientist",4);
        List<Card> hand = new ArrayList<>();
        hand.add(new PlayersCards("ville-11", "rouge"));
        hand.add(new PlayersCards("ville-44", "rouge"));
        hand.add(new PlayersCards("ville-20", "rouge"));
        hand.add(new PlayersCards("ville-13", "rouge"));

        Disease redDisease = Disease.RED;
        List<Disease> discoveredDiseases = new ArrayList<>();

        assertTrue(scientist.findRemedy(hand, discoveredDiseases, redDisease));
        assertTrue(discoveredDiseases.get(0).getDiseaseName().equals("rouge"));
    }
}