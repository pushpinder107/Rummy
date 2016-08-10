package structures;

import java.util.Collections;
import java.util.List;

public class StringGenerator
{
	public String diff(Hand hand){
		
		List<Card> inHand = hand.cardsInHand();
		//Collections.sort(inHand);	
		String diff = "";
		for(int i=0;i<inHand.size();i++){
			if(isSet(inHand.get(i),inHand.get(i+1)))
			{
				diff+="0";
			}
			else if(isSeq(inHand.get(i),inHand.get(i+1)))
			{
				diff+="1";
			}
			else diff+="x";
		}
		return null;
}
	
	public boolean isSet(Card c1, Card c2)
	{
		return (c1.getFace()==c2.getFace());
	}
	
	public boolean isSeq(Card c1, Card c2)
	{
		return (((c1.getFace()==c2.getFace()-1)||(c1.getFace()==c2.getFace()+12))&&(c1.getSuit()==c2.getSuit()));
	}

	
}