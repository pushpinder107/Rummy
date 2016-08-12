package tracking;

import java.util.ArrayList;

public class TestRow2 {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Row r11 = new Row(1,10,'A',3);
		Row r22 = new Row(8,14,'A',3);
		ArrayList<Row> input =new ArrayList<Row>();//input function
		input.add(r11);
		input.add(r22);
		ArrayList<Row> ans2;//check this
		for(int i=1;i<input.size();i++)
		{	
			System.out.println("sdf:");
			Row r = input.get(0);
			ArrayList<Row> ans = new ArrayList<Row>() ;
			ans.add(r);
			for(int j=1;j<input.size()-1;j++)
			{	
				ans2 = new ArrayList<Row>() ;
				Row newRow = input.get(j);
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
						ans2.add(r1);
						ans2.add(newRow);						
						
					}
					if(cases == 6)//exact same or newRow is superSet
					{
						ans2.add(newRow);
					}
					
					System.out.println(newRow.toString());
				}
				ans = ans2;		
						
			}
			// call merge function on ans2
		}
		// call merge function on ans2
		//return ans2;
		//System.out.println(ans2.get(0).toString());
	}

}
