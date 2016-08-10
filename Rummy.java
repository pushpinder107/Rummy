package structures;

public class Rummy {
	 
	Rummy()
	{
		
	int num_of_decks = 2;
	int num_of_jokers_per_deck = 2;
	int numOfCardsInHand = 13;
	Deck D = new Deck(num_of_decks,num_of_jokers_per_deck);
	D.shuffle();
	Card newJoker = D.draw();
	
	Hand hand = new hand(D.draw(numOfCardsInHand));
	}
	
	
	
	
    }
