package structures;

public class getSequence1 {
	
	public static void main(String[] args) {
		Deck d = new Deck(2, 2);
		Hand h = new Hand();
		for (int i = 0; i < 13; i++) {
			d.shuffle();
			h.addCard(d.draw());
		}
       // int res = getSequence(h);
        String test = "00111x00";
        String res1 = getSequenceOfFour(test);
        String res2 = getSequenceOfThree(res1);
        
        
		System.out.println(h.toString());
	}

	
	public static String getSequenceOfFour(String str) {
		int sequenceCount = 0;

		if (str.startsWith("111")) {
			str = str.replaceFirst("111", "");
			sequenceCount++;
		}

		String[] sequenceOfFour = { "x111x", "0111x", "x1110", "01110", "111" };
		for (String s : sequenceOfFour) {
			while (str.contains(s)) {
				sequenceCount++;
				str = str.replaceFirst(s, "##");
			}
		}
		System.out.println( sequenceCount);
		return str;
	}

	public static String getSequenceOfThree(String str) {
		if (str.equals("")) {

		}
		int sequenceCount = 0;
		if (str.startsWith("11")) {
			str = str.replaceFirst("11", "");
			sequenceCount++;
		}

		String[] sequenceOfThree = { "011x", "x110", "0110", "11" };
		for (String s : sequenceOfThree) {
			while (str.contains(s)) {
				sequenceCount++;
				str = str.replaceFirst(s, "");
			}
		}
		System.out.println( sequenceCount);
		return str;
	}

}