package structures;

public class Rummy {

	private Hand hand;

	public Rummy() {

		Deck d = new Deck(2, 2);
		Hand h = new Hand();
		for (int i = 0; i < 13; i++) {
			d.shuffle();
			h.addCard(d.draw());
		}

		this.hand = h;
	}

}
