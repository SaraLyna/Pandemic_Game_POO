package pandemic;

public class PlayersTest {
	public static void main(String[] args) {
		// create a new player object
		Cities city1= new Cities("ville-11","3");
		Cards card1= new Cards("ville-10","bleu");
		Cards card2= new Cards("ville-12","rouge");
		Cards card3= new Cards("ville-44","jaune");
		Cards card4= new Cards("ville-20","noir");
		
		
		Players player1 = new Players("John", Roles.Doctor, city1);
		
		// get the name, role and location of the player
		System.out.println("Player name: " + player1.getName());
		System.out.println("Player role: " + player1.getRole());
		System.out.println("Player location: " + player1.getLocation());
		
		// add some cards to the player's hand
		player1.getCardsInHand().push(card1);
		player1.getCardsInHand().push(card2);
		player1.getCardsInHand().push(card3);
		player1.getCardsInHand().push(card4);
		
		// discard a card if the number of cards in hand exceeds 7
		if (player1.getCardsInHand().size() > 7) {
			player1.discard();
		}
		
		// print the remaining cards in the player's hand
		System.out.println("Cards in hand: " + player1.getCardsInHand());
	}
}
