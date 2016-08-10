package structures;

import java.util.ArrayList;

public class PackWithJoker extends Pack {
	public static int DEFAULT_JOKERS = 2;
	
	public PackWithJoker(int jokers) {
		this.cards = new ArrayList<Card>();
		this.makePack();
		this.addJokers(jokers);
	}
	
	public PackWithJoker() {
		this(DEFAULT_JOKERS);
	}
	
	public void addJokers(int jokers) {
		for (int i=0; i<jokers; i++) {
			this.addCard(new Card(Card.JOKER, Card.JOKER));
		}
	}
}
