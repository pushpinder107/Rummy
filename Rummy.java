package structures;

public class Rummy {

	private Hand hand;
	private int setsOfFour = 0;
	private int setsOfThree = 0;
	private int seqOfFour = 0;
	private int seqOfThree = 0;

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
		System.out.println("Hand : " + handString);
		String str = getSetsOfFour(handString);
		System.out.println("Sets of 4 : " + this.setsOfFour);
		String newStr = getSetsOfThree(str);
		System.out.println("Sets of 3 : " + this.setsOfThree);
		handString = s.diff(this.hand);
		newStr = getSequencesOfFour(handString);
		System.out.println("Seqs of 4 : " + this.seqOfFour);
		newStr = getSequencesOfThree(newStr);
		System.out.println("Seqs of 3 : " + this.seqOfThree);

	}

	public String getSetsOfFour(String str) {
		int setCount = 0;

		if (str.startsWith("000")) {
			str = str.replaceFirst("000", "###");
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
			str = str.replaceFirst("00", "##");
			setCount++;
		}

		String[] setsOfThree = { "100x", "x001", "1001", "00" };
		for (String s : setsOfThree) {
			while (str.contains(s)) {
				setCount++;
				str = str.replaceFirst(s, "##");
			}
		}
		this.setsOfThree = setCount;
		return str;
	}

	public String getSequencesOfFour(String str) {
		int setCount = 0;
		if (str.startsWith("111")) {
			str = str.replaceFirst("111", "###");
			setCount++;
		}

		String[] setsOfFour = { "x111x", "0111x", "x1110", "01110", "111" };
		for (String s : setsOfFour) {
			while (str.contains(s)) {
				setCount++;
				str = str.replaceFirst(s, "##");
			}
		}
		this.seqOfFour = setCount;
		return str;
	}

	public String getSequencesOfThree(String str) {
		int setCount = 0;

		String[] setsOfFour = { "x11x", "011x", "x110", "0110", "11" };
		for (String s : setsOfFour) {
			while (str.contains(s)) {
				setCount++;
				str = str.replaceFirst(s, "##");
			}
		}
		this.seqOfThree = setCount;
		return str;
	}

}
