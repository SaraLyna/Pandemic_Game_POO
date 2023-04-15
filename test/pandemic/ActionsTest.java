/**
 * 
 */
package pandemic;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 *
 */
public class ActionsTest {
	

	@Test
	public void testDiscover() {
		Cities city1= new Cities("ville-11","3");
		Cities city2= new Cities("ville-44","2");
		Cities city3= new Cities("ville-16","1");
		Cities city4= new Cities("ville-37","0");
		Diseases disease1=Diseases.RED;
		Diseases disease2= Diseases.BLUE;
		Players player1=new Players("Ana",Roles.Expert,city1);
		Players player2=new Players("Charles",Roles.Doctor,city4);
		Players player3=new Players("Sara",Roles.Scientist,city4);
		PlayersCards card1=new PlayersCards("ville-11","noir");
		PlayersCards card2=new PlayersCards ("ville-44","bleu");
		PlayersCards card3=new PlayersCards("ville-16","rouge");
		PlayersCards card4= new PlayersCards("ville-37","jaune");
		PlayersCards card5= new PlayersCards("ville-20","bleu");
		player1.addCard(card1);
		player1.addCard(card2);
		player1.addCard(card3);
		player1.addCard(card4);
		player1.addCard(card5);
		Actions action = new Actions();
		
		// vérifie qu'une maladie ne peut pas etre guérie si le joueur n'est pas dans une ville avec un centre de rcherche
		action.discover(player1, disease1);
		assertFalse(disease1.isCured());
		assertFalse(disease2.isCured());
		
		
		//deplacer un joueur dans une ville qui contient un centre de recherche 
		player1.setLocation(city1);
		city1.addResearchCenter();
		
		action.discover(player1, disease1);
		assertFalse(disease1.isCured());
		assertFalse(disease2.isCured());
		
		// ajoute une autre carte de la meme couleur dans la main du joueur 
		player1.addCard(new PlayersCards("ville-11","noir"));
		
		
		action.discover(player1, disease1);
		//assertTrue(disease1.isCured());
		assertFalse(disease2.isCured());
		
		//verifie si la main du joueur a été  mise à jour correctement
		
		assertEquals(6,player1.getCardsInHand().size());
		}
	/*
	@Test
	public void testDisease() {
		
	}
	*/
	

}
