package structures;

import java.util.ArrayList;

public class TestRummy {
	public static void main(String[] args) {
		ArrayList<Card> allSameFaces = new ArrayList<>();
		for (int i = 0; i < 13; i++) {
			allSameFaces.add(new Card(1, 4));
		}

		Hand h = new Hand(allSameFaces);
		Rummy game = new Rummy(h);
		StringGenerator s = new StringGenerator();
		System.out.println(s.diff(h));
		System.out.println();
		game.evaluate();
		ArrayList<Card> mixedHand = new ArrayList<>();
		mixedHand.addAll(getNofSameFace(3, 4));
		mixedHand.addAll(getNofSameFace(2, 5));
		mixedHand.addAll(getNofSameFace(4, 6));
		mixedHand.addAll(getNofSameFace(1, 9));
		mixedHand.addAll(getNofSameFace(1, 3));
		mixedHand.addAll(getNofSameFace(2, 8));
		Hand mixed = new Hand(mixedHand);
		Rummy game2 = new Rummy(mixed);
		game2.evaluate();

		ArrayList<Card> seqHand = new ArrayList<>();
		seqHand.addAll(getNofSameFace(1, 4));
		seqHand.addAll(getNofSameFace(1, 5));
		seqHand.addAll(getNofSameFace(1, 6));
		seqHand.addAll(getNofSameFace(1, 7));
		seqHand.addAll(getNofSameFace(2, 8));
		seqHand.addAll(getNofSameFace(1, 9));
		seqHand.addAll(getNofSameFace(1, 10));
		Hand seq = new Hand(seqHand);
		Rummy game3 = new Rummy(seq);
		game3.evaluate();

	}

	public static ArrayList<Card> getNofSameFace(int n, int face) {
		ArrayList<Card> allSameFaces = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			allSameFaces.add(new Card(i % 4, face));
		}

		return allSameFaces;
	}

}
