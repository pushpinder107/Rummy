package wordsFreq;

import java.util.Collections;
import java.util.List;

public class StringGenerator
{
	@SuppressWarnings("unchecked")
	public static String diff(Hand hand){
		
		List<Card> inHand = hand.cardsInHand();
		Collections.sort(inHand);	
		String diff = "";
		for(int i=0;i<inHand.size()-1;i++){
			if(hasSameFaceValue(inHand.get(i),inHand.get(i+1)))
			{
				diff+="0";
			}
			else if(partOfSeq(inHand.get(i),inHand.get(i+1)))
			{
				diff+="1";
			}
			else diff+="x";
		}
		return diff;
}
	
	public static boolean hasSameFaceValue(Card c1, Card c2)//can change it to non-static just to check from main I converted them to static
	{
		return (c1.getFace()==c2.getFace());
	}
	
	public static boolean partOfSeq(Card c1, Card c2)//can change it to non-static just to check from main I converted them to static
	{
		return (((c1.getFace()==c2.getFace()-1)||(c1.getFace()==c2.getFace()+12))&&(c1.getSuit()==c2.getSuit()));
	}
	
	public static void main(String[] args){
		int num_of_decks = 2;
		int num_of_jokers_per_deck = 2;
		int numOfCardsInHand = 5;
		Deck D = new Deck(num_of_decks,num_of_jokers_per_deck);
		D.shuffle();
		Card newJoker = D.draw();
		
		Hand hand = new Hand(D.pick(numOfCardsInHand));
		System.out.println(hand.toString());
		List<Card> inHand = hand.cardsInHand();
		Collections.sort(inHand);
		System.out.println(inHand.toString());
		String dif = diff(hand);
		System.out.println(dif);
	}

	
}