package tracking;

import java.util.ArrayList;

public class TestRow {

	public static void main(String[] args) {
		while (true) {
			Row r = InputParser.getInputRow();
			if (r == null) {
				System.out.println("Ending");
				break;
			}

			System.out.println(r.toString());
		}
	}

}
