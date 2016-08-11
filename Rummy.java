package structures;

import java.util.ArrayList;
import java.util.List;

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
		play();

	}

	public void play() {

		if (hasSeqOfFive(hand)) {
			System.out.println("hasSeqOfFive");
			consumeSequenceOfFive();
		}

		while (hasSeqOfFour(hand)) {
			System.out.println("hasSeqOfFour");
			consumeSequenceOfFour();
		}

		while (hasSeqOfThree(hand)) {
			System.out.println("hasSeqOfThree");
			consumeSequenceOfThree();
		}

		while (hasSetOfFour(hand)) {
			System.out.println("hasSetOfFour");
			consumeSetOfFour();
		}

		while (hasSetOfThree(hand)) {
			System.out.println("hasSetOfFour");
			consumeSetOfThree();
		}

		if (hand.cardsInHand().size() == 0) {
			System.out.println("No cards needed");
			return;
		}

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
		//System.out.println("String " + str);
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
		this.hand.sortByFace();
		String str = StringGenerator.diff(this.hand);
		int startIndex = str.indexOf("1111", 0);
		int endIndex = startIndex + 4;
		System.out.println(hand.toString());
		System.out.println("Removing cards at :" + startIndex + " to :" + endIndex);
		List<Card> copyList = new ArrayList<Card>();
		copyList.addAll(this.hand.cardsInHand());
		for (int i = startIndex; i <= endIndex; i++) {
			Card cardToRemove = copyList.get(i);
			System.out.println("Removing : " + cardToRemove.toString());
			hand.removeCard(cardToRemove);
		}
		System.out.println(hand.toString());
	}

	public void consumeSequenceOfFour() {
		String str = StringGenerator.diff(this.hand);
		int startIndex = str.indexOf("111", 0);
		int endIndex = startIndex + 3;
		System.out.println(hand.toString());
		System.out.println("Removing cards at :" + startIndex + " to :" + endIndex);
		List<Card> copyList = new ArrayList<Card>();
		copyList.addAll(this.hand.cardsInHand());
		for (int i = startIndex; i <= endIndex; i++) {
			Card cardToRemove = copyList.get(i);
			System.out.println("Removing : " + cardToRemove.toString());
			hand.removeCard(cardToRemove);
		}
		System.out.println(hand.toString());

	}

	public void consumeSequenceOfThree() {
		String str = StringGenerator.diff(this.hand);
		int startIndex = str.indexOf("11", 0);
		int endIndex = startIndex + 2;
		System.out.println(hand.toString());
		System.out.println("Removing cards at :" + startIndex + " to :" + endIndex);
		List<Card> copyList = new ArrayList<Card>();
		copyList.addAll(this.hand.cardsInHand());
		for (int i = startIndex; i <= endIndex; i++) {
			Card cardToRemove = copyList.get(i);
			System.out.println("Removing : " + cardToRemove.toString());
			hand.removeCard(cardToRemove);
		}
		System.out.println(hand.toString());

	}

	public void consumeSetOfFour() {
		String str = StringGenerator.diff(this.hand);
		int startIndex = str.indexOf("000", 0);
		int endIndex = startIndex + 3;
		System.out.println(hand.toString());
		System.out.println("Removing cards at :" + startIndex + " to :" + endIndex);
		List<Card> copyList = new ArrayList<Card>();
		copyList.addAll(this.hand.cardsInHand());
		for (int i = startIndex; i <= endIndex; i++) {
			Card cardToRemove = copyList.get(i);
			System.out.println("Removing : " + cardToRemove.toString());
			hand.removeCard(cardToRemove);
		}
		System.out.println(hand.toString());

	}

	public void consumeSetOfThree() {

	}

}
