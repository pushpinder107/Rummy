package structures;

public class Pushpinder {

	public static void main(String[] args) {
		Deck d = new Deck(2, 2);
		Hand h = new Hand();
		for (int i = 0; i < 13; i++) {
			d.shuffle();
			h.addCard(d.draw());
		}

		System.out.println(h.toString());
	}

	public int getSets(Hand hand) {
		String handStr = "0011xx00";// = //Harsh's function here
		int setCount = 0;
		String[] setsOfThree = { "00x", "x00x", "100x", "x001", "1001" };
		String[] setsOfFour = { "00x", "x000x", "1000x", "x0001", "10001" };
		String temp = "";

		if (handStr.startsWith("00")) {
			temp = temp.replaceFirst("00", "");
			setCount++;
		}

		for (String str : setsOfThree) {
			if (temp.contains(str)) {
				setCount++;
				temp = temp.replaceFirst(str, "");
			}
		}

		for (String str : setsOfFour) {
			if (temp.contains(str)) {
				setCount++;
				temp = temp.replaceFirst(str, "");
			}
		}

		return setCount;

	}

}
