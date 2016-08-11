package tracking;

import java.util.Scanner;

public class InputParser {

	public static Row getInputRow() {
		Row r = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter :\n");

		String line = input.nextLine();
		if (line.equals("0")) {
			System.out.println("Terminating");
			input.close();
			return null;
		}

		if (line.matches("[0-9]+ [0-9]+ [A-Z] [0-9]")) {
			String[] split = line.split(" ");
			int start = Integer.parseInt(split[0]);
			int end = Integer.parseInt(split[1]);
			char transfer = split[2].charAt(0);
			int tracking = Integer.parseInt(split[1]);
			r = new Row(start, end, transfer, tracking);
		} else {
			System.out.println(line);
		}
		return r;
	}

}
