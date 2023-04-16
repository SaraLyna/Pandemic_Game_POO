package pandemic;


public class PlayersTest {
	public static void main(String[] args) {
		// create a new player object
		Cities city1= new Cities("ville-11","3");
		PlayersCards card1= new PlayersCards("ville-10","bleu");
		PlayersCards card2= new PlayersCards("ville-12","rouge");
		PlayersCards card3= new PlayersCards("ville-44","jaune");
		PlayersCards card4= new PlayersCards("ville-20","noir");
		
		
		Players player1 = new Players("John", Roles.Doctor, city1);
		
		// get the name, role and location of the player
		System.out.println("Player name: " + player1.getName());
		System.out.println("Player role: " + player1.getRole());
		System.out.println("Player location: " + player1.getLocation().toString());
		
		// add some cards to the player's hand
		player1.getCardsInHand().push(card1);
		player1.getCardsInHand().push(card2);
		player1.getCardsInHand().push(card3);
		player1.getCardsInHand().push(card4);
		System.out.println(player1.getCardsInHand().size());
		
		// discard a card if the number of cards in hand exceeds 7
		if (player1.getCardsInHand().size() > 7) {
			player1.discard();
		}
		
		// print the remaining cards in the player's hand
		System.out.println("Cards in hand: " + player1.getCardsInHand());
	}
}
