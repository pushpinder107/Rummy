package structures;

import java.util.ArrayList;

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
		/*
		 * System.out.println("Hand is : " + this.hand.toString());
		 * this.hand.sortByFace(); System.out.println("Sorted hand is : " +
		 * this.hand.toString()); String handString =
		 * StringGenerator.diff(this.hand); System.out.println("Hand : " +
		 * handString); String str = getSetsOfFour(handString);
		 * System.out.println("Sets of 4 : " + this.setsOfFour);
		 * System.out.println("Sets of 3 : " + this.setsOfThree); str =
		 * getSequencesOfFive(handString); System.out.println("Seqs of 5 : " +
		 * this.seqOfFive); str = getSequencesOfFour(str);
		 * System.out.println("Seqs of 4 : " + this.seqOfFour); str =
		 * getSequencesOfThree(str); System.out.println("Seqs of 3 : " +
		 * this.seqOfThree);
		 * 
		 * int result = this.setsOfFour * 4 + this.setsOfThree * 3 +
		 * this.seqOfFive * 5 + this.seqOfFour * 4 + this.seqOfThree * 3;
		 * System.out.println("Cards consumed : " + result);
		 */

		System.out.println("Hand : " + hand.toString());
		System.out.println("String : " + StringGenerator.diff(hand));
		System.out.println("Is seq of 5 : " + hasSeqOfFive(hand));

	}

	public void play(Hand h) {
		while (hasSeqOfFive(h)) {
			consumeSequenceOfFive();
		}

		while (hasSeqOfFour(h)) {
			consumeSequenceOfFour();
		}

		while (hasSeqOfThree(h)) {
			consumeSequenceOfThree();
		}

		while (hasSetOfFour(h)) {
			consumeSetOfFour();
		}

		while (hasSetOfThree(h)) {
			consumeSetOfThree();
		}

		// if hand is still non empty, check if one card needed for seq of 5,
		// etc
	}

	public boolean hasSetOfFour(Hand h) {
		String str = StringGenerator.diff(h);
		return str.equals("000");
	}

	public boolean hasSetOfThree(Hand h) {
		String str = StringGenerator.diff(h);
		return str.contains("00");
	}

	public boolean isSetOfTwo(Hand h) {
		String str = StringGenerator.diff(h);
		return str.contains("0");
	}

	public boolean hasSeqOfFive(Hand h) {
		String str = StringGenerator.diff(h);
		return str.contains("1111");
	}

	public boolean hasSeqOfFour(Hand h) {
		String str = StringGenerator.diff(h);
		return str.contains("111");
	}

	public boolean hasSeqOfThree(Hand h) {
		String str = StringGenerator.diff(h);
		return str.contains("11");

	}

	public boolean isSeqOfTwo(Hand h) {
		String str = StringGenerator.diff(h);
		return str.contains("1");
	}

	public boolean needsOneForSetOfFour(Hand h) {
		return hasSetOfThree(h);
	}

	public boolean needsOneForSetOfThree(Hand h) {
		return isSetOfTwo(h);
	}

	public boolean needsOneForSequenceOfFive(Hand h) {
		return hasSeqOfFour(h);
	}

	public boolean needsOneForSequenceOfFour(Hand h) {
		return hasSeqOfThree(h);
	}

	public boolean needsOneForSequenceOfThree(Hand h) {
		return isSeqOfTwo(h);
	}

	public void consumeSequenceOfFive() {

	}

	public void consumeSequenceOfFour() {

	}

	public void consumeSequenceOfThree() {

	}

	public void consumeSetOfFour() {

	}

	public void consumeSetOfThree() {

	}

}
