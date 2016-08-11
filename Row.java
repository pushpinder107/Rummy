package tracking;

public class Row {

	private int start;
	private int end;
	private char trackingId;
	private int transferCode;

	public Row(int s, int e, char t, int tc) {
		this.start = s;
		this.end = e;
		this.trackingId = t;
		this.transferCode = tc;
	}

	public String toString() {
		String str = "Start : " + start + " End : " + end + " Tracking : " + trackingId + " Transfer : " + transferCode;
		return str;
	}
}
