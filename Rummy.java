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

	public Rummy(Hand h) {
		this.hand = h;
	}

	public void evaluate() {
		System.out.println("Hand is : " + this.hand.toString());
		this.hand.sortByFace();
		System.out.println("Sorted hand is : " + this.hand.toString());
		StringGenerator s = new StringGenerator();
		String handString = s.diff(this.hand);

		System.out.println("Sets of 4 : " + this.getSetsOfFour(handString));
		System.out.println("Sets of 3 : " + this.getSetsOfThree(handString));

	}

	public int getSetsOfFour(String str) {
		int setCount = 0;

		if (str.startsWith("000")) {
			str = str.replaceFirst("000", "");
			setCount++;
		}

		String[] setsOfFour = { "000", "x000x", "1000x", "x0001", "10001" };
		for (String s : setsOfFour) {
			if (str.contains(s)) {
				setCount++;
				str.replaceFirst(s, "");
			}
		}

		return setCount;
	}

	public int getSetsOfThree(String str) {
		int setCount = 0;
		if (str.startsWith("00")) {
			str = str.replaceFirst("00", "");
			setCount++;
		}

		String[] setsOfThree = { "00", "100x", "x001", "1001" };
		for (String s : setsOfThree) {
			if (str.contains(s)) {
				setCount++;
				str.replaceFirst(s, "");
			}
		}

		return setCount;
	}

}
