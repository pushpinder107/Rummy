package tracking;

import java.util.ArrayList;

public class TestRow2 {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Row r11 = new Row(1,10,'A',3);
		Row r22 = new Row(8,14,'A',2);
		Row r24 = new Row(2,4,'A',8);
		Row r23 = new Row(0,0,'X',0);
		ArrayList<Row> input =new ArrayList<Row>();//input function
		input.add(r11);
		input.add(r22);
		input.add(r24);
		input.add(r23);
		ArrayList<Row> ans2;//check this
		for(int i=0;i<input.size();i++)
			{
			System.out.println(input.get(i).toString());
			}
		Row r = input.get(0);
		ArrayList<Row> ans = new ArrayList<Row>() ;
		ans.add(r);		
//		for(int i=0;i<input.size();i++)
//		{				
			for(int j=1;j<input.size()-1;j++)
			{	
				ans2 = new ArrayList<Row>() ;
				Row newRow = input.get(j);
				
				for(int k = 0; k<ans.size(); k++)
				{
					int cases = newRow.getCase(ans.get(k));
					//Cases are for subset suoersett same etc
					//System.out.println(cases);
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
//					for(int i=0;i<input.size();i++)
//					{
//					System.out.println(ans2.get(i).toString());
//					}
					
				}
				ans = ans2;	
														
			}
			System.out.println("  ");
			for(int i=0;i<ans.size();i++)
			{
			System.out.println(ans.get(i).toString());
			}
			
//		}
		// call merge function on ans
		//return ans;
		//System.out.println(ans2.get(0).toString());
	}

}
