package tracking;

import java.util.ArrayList;

public class TestRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "SDf";//pushp fn
		for(int i=1;i<input.length();i++)
		{	
			ArrayList<Row> rows =new ArrayList<Row>();//input function
			Row r = rows.get(0);
			ArrayList<Row> ans = new ArrayList<Row>() ;
			ans.add(r);
			for(int j=1;j<rows.size()-1;j++)
			{	
				ArrayList<Row> ans2 = new ArrayList<Row>() ;
				Row newRow = rows.get(j);
				for(int k = 0; k< ans.size(); k++)
				{
					int cases = newRow.getCase(ans.get(k));
					//Cases are for subset suoersett same etc
					if(cases == 1){
						ans2.add(newRow);
						ans2.add(ans.get(k));
					}
					if(cases == 2){
						ans2.add(ans.get(k));
						ans2.add(newRow);
					}
					if(cases == 3){
						Row r1 = new Row(ans.get(k).start,newRow.start-1,ans.get(k).track,ans.get(k).code);						
						//Row r2 = new Row(ans.get(k).start,newRow.start-1,ans.get(k).track,ans.get(k).code);
						Row r3 = new Row(newRow.end+1,ans.get(k).end,ans.get(k).track,ans.get(k).code);
						ans2.add(r1);
						ans2.add(newRow);
						ans2.add(r3);
					}
					if(cases == 4){
						Row r3 = new Row(newRow.end+1,ans.get(k).end,ans.get(k).track,ans.get(k).code);
						ans2.add(newRow);
						ans2.add(r3);
					}
					if(cases == 5){
						Row r1 = new Row(ans.get(k).start,newRow.start-1,ans.get(k).track,ans.get(k).code);
						ans2.addAll(r3);
						ans2.add(newRow);						
						
					}
					if(cases == 6)//exact same or newRow is superSet
					{
						ans2.add(newRow);
					}
					
					
				}
				ans = ans2;		
						
			}
			// call merge function on ans2
		}
		// call merge function on ans2
		//return ans2
	}

}
