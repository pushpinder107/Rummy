package structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author ashish
 *
 */
public class Deck {
	private List<Card> cards;
	
	public Deck(int n) {
		this.cards = new ArrayList<Card>();
		addPacks(n, PackWithoutJoker.class);
	}
	
	public Deck() {
		this(1);
	}
	
	public Deck(int n, int j) {
		this.cards = new ArrayList<Card>();
		addPacks(n, PackWithJoker.class);
	}
	
	private boolean addPacks(int n, Class<? extends Pack> c) {
		ArrayList<Card> packs = new ArrayList<Card>();
		for (int i=0; i<n; i++) {
			Pack pack;
			try {
				pack = c.newInstance();
				packs.addAll(pack.getCards());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
				return false;
			}
		}
		this.cards.addAll(packs);
		return true;
	}
	
	public boolean remove(Card card) {
		return this.cards.remove(card);
	}
	
	public List<Card> getAndRemoveSuit(int suit) {
		ArrayList<Card> cardsOfSuit = new ArrayList<Card>();
		for (Card c : this.cards) {
			if (c.getSuit() == suit) {
				cardsOfSuit.add(c);
				this.remove(c);
			}
		}
		return cardsOfSuit;
	}
	
	public void removeSuit(int suit) {
		for (Card c : this.cards) {
			if (c.getSuit() == suit) {
				this.remove(c);
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(this.cards);
	}
	
	public List<Card> pick(int n) {
		ArrayList<Card> hand = new ArrayList<Card>();
		int count = 0;
		if (n > this.cardsLeft()) {
			return null;
		}
		while (count < n) {
			Card card = draw();
			hand.add(card);
			count++;
		}
		return hand;
	}
	
	public Card draw() {
		Card c = this.cards.get(0);
		this.remove(c);
		return c;
	}
	
	public int cardsLeft() {
		return this.cards.size();
	}
	
	public String toString() {
		return this.cards.toString();
	}
	
	public static void main(String[] args) {
		Deck deck = new Deck(2, 2);
		deck.shuffle();
	}
}
