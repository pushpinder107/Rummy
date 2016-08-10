package structures;

import java.util.ArrayList;
import java.util.List;

public abstract class Pack {
	List<Card> cards;
	
	public void makePack() {
		for (int i=Card.SPADES; i<=Card.DIAMONDS; i++) {
			for (int j=Card.TWO; j<=Card.ACE; j++) {
				cards.add(new Card(i, j));
			}
		}
	}
	
	public boolean addCard(Card c) {
		return this.cards.add(c);
	}
	
	public List<Card> getCards() {
		return new ArrayList<Card>(this.cards);
	}
}
