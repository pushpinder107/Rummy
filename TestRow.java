package tracking;

import java.util.ArrayList;

public class TestRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "SDf";
		for(int i=1;i<input.length();i++)
		{	
			ArrayList<Row> r =new ArrayList<Row>();//call pushp fn instead new
			for(int j=0;j<r.size()-1;j++)
			{
				Row r1 = r.get(j);
				Row r2 = r.get(j+1);
				//help me here how to divide into cases 
				//we can have 3 cases completely within each other -> result in one row
				if(r2s range does not intersect with r1 && values are not same ){	//make a boolean fn
				//new copy into new rows	
				}
				if(r2s range does not intersect with r1 && values are same ){	//make a boolean fn
					//new copy into new rows	
					}
						
			}
		}

	}

}
