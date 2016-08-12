package tracking;

import java.util.Scanner;

public class InputParser {

	public static Row getInputRow(String line) {
		Row r = null;	

		if (line.matches("[0-9]+ [0-9]+ [A-Z] [0-9]")) {
			String[] split = line.split(" ");
			int start = Integer.parseInt(split[0]);
			int end = Integer.parseInt(split[1]);
			char transfer = split[2].charAt(0);
			int tracking = Integer.parseInt(split[3]);
			r = new Row(start, end, transfer, tracking);
		} else {
			System.out.println(line);
		}
		return r;
	}

}
