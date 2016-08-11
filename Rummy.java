package structures;

public class Rummy {

	private Hand hand;
	private int setsOfFour = 0;
	private int setsOfThree = 0;

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
		System.out.println("Hnad : " + handString);
		String str = getSetsOfFour(handString);
		System.out.println("Sets of 4 : " + this.setsOfFour);
		String newStr = getSetsOfThree(str);
		System.out.println("Sets of 3 : " + this.setsOfThree);

	}

	public String getSetsOfFour(String str) {
		int setCount = 0;

		if (str.startsWith("000")) {
			str = str.replaceFirst("000", "");
			setCount++;
		}

		String[] setsOfFour = { "x000x", "1000x", "x0001", "10001", "000" };
		for (String s : setsOfFour) {
			while (str.contains(s)) {
				setCount++;
				str = str.replaceFirst(s, "##");
			}
		}
		this.setsOfFour = setCount;
		return str;
	}

	public String getSetsOfThree(String str) {
		if (str.equals("")) {

		}
		int setCount = 0;
		if (str.startsWith("00")) {
			str = str.replaceFirst("00", "");
			setCount++;
		}

		String[] setsOfThree = { "100x", "x001", "1001", "00" };
		for (String s : setsOfThree) {
			while (str.contains(s)) {
				setCount++;
				str = str.replaceFirst(s, "");
			}
		}
		this.setsOfThree = setCount;
		return str;
	}

	public String getSequencesOfThree(String str) {
		return "";
	}

}
