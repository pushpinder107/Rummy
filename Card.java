package structures;

public class Card {
	public static int TWO = 2;
	public static int JACK = 11;
	public static int QUEEN = 12;
	public static int KING = 13;
	public static int ACE = 14;
	public static int JOKER = 15;
	
	public static int SPADES = 0;
	public static int HEARTS = 1;
	public static int CLUBS = 2;
	public static int DIAMONDS = 3;
	
	private static String[] FACE_NAMES = {"", "", "Two", "Three", "Four", "Five", "Six",
			"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	private static String[] SUIT_NAMES = {"Spades", "Hearts", "Clubs", "Diamonds"};
	
	private int suit;
	private int face;
	
	/**
	 * Constructor for Card class.
	 * @param suit Suit of the card.
	 * @param face Face value of the card.
	 */
	public Card(int suit, int face) {
		this.suit = suit;
		this.face = face;
	}
	
	/**
	 * Get suit of the card.
	 * @return suit of the card
	 */
	public final int getSuit() {
		return this.suit;
	}
	
	/**
	 * Get face value of the card.
	 * @return face value of the card
	 */
	public final int getFace() {
		return this.face;
	}
	
	public boolean equals(Card other) {
		return (this.suit == other.suit) 
				&& (this.face == other.face); 
	}
	
	public String toString() {
		if (this.face == Card.JOKER) {
			return "Joker";
		}
		return FACE_NAMES[this.face] + " of " + SUIT_NAMES[this.suit];
	}
}
