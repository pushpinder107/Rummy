package structures;

public class Rummy {

	private Hand hand;
	private int setsOfFour = 0;
	private int setsOfThree = 0;
	private int seqOfFive = 0;
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
		String handString = StringGenerator.diff(this.hand);
		System.out.println("Hand : " + handString);
		String str = getSetsOfFour(handString);
		System.out.println("Sets of 4 : " + this.setsOfFour);
		System.out.println("Sets of 3 : " + this.setsOfThree);
		str = getSequencesOfFive(handString);
		System.out.println("Seqs of 5 : " + this.seqOfFive);
		str = getSequencesOfFour(str);
		System.out.println("Seqs of 4 : " + this.seqOfFour);
		str = getSequencesOfThree(str);
		System.out.println("Seqs of 3 : " + this.seqOfThree);

		int result = this.setsOfFour * 4 + this.setsOfThree * 3 + this.seqOfFive * 5 + this.seqOfFour * 4
				+ this.seqOfThree * 3;
		System.out.println("Cards consumed : " + result);

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

	public String getSequencesOfFive(String str) {
		int setCount = 0;
		if (str.startsWith("1111")) {
			str = str.replaceFirst("1111", "####");
			setCount++;
		}

		String[] setsOfFour = { "x1111x", "01111x", "x11110", "011110", "1111" };
		for (String s : setsOfFour) {
			while (str.contains(s)) {
				setCount++;
				str = str.replaceFirst(s, "##");
			}
		}
		this.seqOfFive = setCount;
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

	public boolean isSetOfFour(Hand h) {
		String str = StringGenerator.diff(h);
		return str.equals("000");
	}

	public boolean isSetOfThree(Hand h) {
		String str = StringGenerator.diff(h);
		return str.contains("00");
	}

	public boolean isSetOfTwo(Hand h) {
		String str = StringGenerator.diff(h);
		return str.contains("0");
	}

	public boolean isSeqOfFive(Hand h) {
		String str = StringGenerator.diff(h);
		return str.equals("1111");
	}

	public boolean isSeqOfFour(Hand h) {
		String str = StringGenerator.diff(h);
		return str.contains("111");
	}

	public boolean isSeqOfThree(Hand h) {
		String str = StringGenerator.diff(h);
		return str.contains("11");

	}

	public boolean isSeqOfTwo(Hand h) {
		String str = StringGenerator.diff(h);
		return str.contains("1");
	}

	public boolean needsOneForSetOfFour(Hand h) {
		return isSetOfThree(h);
	}

	public boolean needsOneForSetOfThree(Hand h) {
		return isSetOfTwo(h);
	}

	public boolean needsOneForSequenceOfFive(Hand h) {
		return isSeqOfFour(h);
	}

	public boolean needsOneForSequenceOfFour(Hand h) {
		return isSeqOfThree(h);
	}

	public boolean needsOneForSequenceOfThree(Hand h) {
		return isSeqOfTwo(h);
	}

}
