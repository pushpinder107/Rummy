package tracking;

public class Row {
	
	
	int start;
	int end;
	char track;
	int code;
	
	public Row(int start2, int i, char track2, int code2) {
		// TODO Auto-generated constructor stub
		this.start = start2;
		this.end = i;
		this.track = track2;
		this.code = code2;
	}
	
	public String toString()
	{
		return this.start+" "+this.end+ " "+ this.track + " " + this.code;
		
	}

	public int getCase(Row first) {
		if (this.end < first.start)
			return 1;
		else if (this.start > first.end)
			return 2;
		else if (this.start > first.start && this.end < first.end)
			return 3;
		else if (this.start < first.start && this.end < first.end)
			return 4;
		else if (this.start > first.start && this.end > first.end)
			return 5;
		else if ((this.start <= first.start && this.end >= first.end))
			return 6;
		return 0;
	}
}
