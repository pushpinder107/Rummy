package structures;

public class Pushpinder {

	public int getSets(Hand hand) {
		String handStr = "0011xx00";// = //Harsh's function here
		int setCount = 0;
		String setOfThree = "000";
		String setOfFour = "0000";

		if (handStr.startsWith("00")) {
			handStr = handStr.replaceFirst("00", "");
			setCount++;
			hand.cardsInHand().remove(0);
			hand.cardsInHand().remove(1);
		} else if (handStr.startsWith("000")) {
			handStr = handStr.replaceFirst("000", "");
			hand.cardsInHand().remove(0);
			hand.cardsInHand().remove(1);
			hand.cardsInHand().remove(2);
			setCount++;
		}

		if (handStr.contains(setOfFour)) {

			for (int i = 0; i < handStr.length() - 4; i++) {
				if (handStr.charAt(i) == '0' && handStr.charAt(i + 1) == '0' && handStr.charAt(i + 2) == '0'
						&& handStr.charAt(i + 3) == '0') {
					hand.cardsInHand().remove(i);
					hand.cardsInHand().remove(i + 1);
					hand.cardsInHand().remove(i + 2);
					hand.cardsInHand().remove(i + 3);
				}
				handStr.replaceFirst(setOfFour, "");
			}
			setCount++;
		}

		if (handStr.contains(setOfThree)) {
			for (int i = 0; i < handStr.length() - 4; i++) {
				if (handStr.charAt(i) == '0' && handStr.charAt(i + 1) == '0' && handStr.charAt(i + 2) == '0') {
					hand.cardsInHand().remove(i);
					hand.cardsInHand().remove(i + 1);
					hand.cardsInHand().remove(i + 2);
				}
			}
			handStr.replaceFirst(setOfThree, "");
			setCount++;
		}

		return setCount;

	}
}
