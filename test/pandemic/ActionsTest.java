/**
 * 
 */
package pandemic;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

/**
 * 
 *
 */
public class ActionsTest {
	

	@Test
	public void testDiscover() {
		Cities city1= new Cities("ville-11","3");
	
		Diseases disease1=Diseases.RED;
		Diseases disease2= Diseases.BLUE;
		Players player1=new Players("Ana",Roles.Expert,city1);
		
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
	
	
	
	// pour la méthode move , il nous faut prévoir deux tests différents , car le joueur est susceptible d'entrer une destination invalide , 
	// on crée donc un test pour un move avec une destination valide , et l'autre pour un move vers une destination invalide  
	@Test
	public void testMoveValid() {
		Cities city1=new Cities("vile-11","3");
		Cities city2= new Cities("ville-44","2");
		Cities city3= new Cities("ville-16","1");
		city1.neighbors.add(city2);
		city2.neighbors.add(city1);
		city2.neighbors.add(city3);
		city3.neighbors.add(city2);
		Players player = new Players("Ana",Roles.Expert,city1);
		Actions.move(player,city2);
		assertEquals(city2,player.getLocation());
	}
	@Test
	public void testMoveInvalid() {
		Cities city1=new Cities("vile-11","3");
		Cities city2= new Cities("ville-44","2");
		Cities city3= new Cities("ville-16","1");
		city1.neighbors.add(city2) ;
		city2.neighbors.add(city1);
		city2.neighbors.add(city3);
		city3.neighbors.add(city2);
		Players player = new Players("Charles", Roles.Doctor,city1);
		try {
			Actions.move(player, city3);
			fail("Expected an IllegalArgumentException to be thrown");
		}
		catch(IllegalArgumentException e) {
			assertEquals("the destination is not among the Player's neighboring cities ",e.getMessage());
			}
		assertEquals(city1,player.getLocation());
	}
	
	@Test
	public void testConstruct() {
		Cities city1=new Cities("vile-11","3");
		Cities city2= new Cities("ville-44","2");
		
		Players player = new Players ("Samuel", Roles.GlobetRotter,city2);
		//city1.addPlayer(player);
		player.setLocation(city1);
		PlayersCards card1= new PlayersCards ("ville-20","bleu");
		PlayersCards card2= new PlayersCards("ville-37","jaune");
		player.addCard(card1);
		player.addCard(card2);
		
		Actions.construct(player);
		assertFalse(city1.isReasearchCenter);
		//assertFalse(player.getCardsInHand().contains(card1));
		assertTrue(player.getCardsInHand().contains(card2));
		
		Cities newcity = new Cities("ville-37","0");
		newcity.addPlayer(player);
		player.setLocation(newcity);
		
		Actions.construct(player);
		assertFalse(newcity.isReasearchCenter);
		assertTrue(player.getCardsInHand().contains(card2));
		
		
		
	}
	
	
	@Test
	public void testHealDisease() { 
		Cities city1=new Cities("vile-11","3");
		Diseases disease = Diseases.RED;
		HashMap<Diseases,Integer> cubesStock = new HashMap<> ();
		cubesStock.put(disease, 3);
		
		// premier cas : quand il ne reste plus aucun cube de la maladie dans la ville 
		city1.setCube(0);
		Actions action = new Actions();
		action.HealDisease(disease,city1,cubesStock);
		assertEquals(0,city1.getCubeCount(disease));
		assertEquals(3,(int)cubesStock.get(disease));
		
		// deuxieme cas: la maladie est guérie
		city1.setCube(3);
		disease.setCured(true);
		action.HealDisease(disease, city1, cubesStock);
		assertEquals(0,city1.getCubeCount(disease));
		assertEquals(4,(int)cubesStock.get(disease));
		
		
		// troisieme cas: la maladie n'est pas guérie et il reste encore des cubes 
		city1.setCube(3);
		disease.setCured(false);
		action.HealDisease(disease, city1, cubesStock);
		assertEquals(2,city1.getCubeCount(disease));
		assertEquals(4,(int)cubesStock.get(disease));
		
	}
	

	
	
	

}
