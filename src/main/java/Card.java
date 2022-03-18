
public class Card {  //have suit and value, store as 2-14, and C,D,S,H
	char suit; 
	int value;
	public Card(char suit, int value) {
		// TODO Auto-generated constructor stub
		this.suit =suit ;
		this.value =value;
		
	}
	public char getSuit() {
		return suit;
	}
	public int getValue() {
		return value;
	}
}
