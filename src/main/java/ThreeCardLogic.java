import java.awt.peer.LabelPeer;
import java.util.*;
import java.util.ArrayList;

public class ThreeCardLogic {
		
	public ThreeCardLogic() {
		// TODO Auto-generated constructor stub
	}
	
	// check if there a pair 
	public static int pair(ArrayList<Card> hand) {
		if(hand.get(0).getValue()== hand.get(1).getValue() ) {
			return 1;
		}
		else if(hand.get(0).getValue()== hand.get(2).getValue()) {
			return 1;
		}
		else if(hand.get(1).getValue()== hand.get(2).getValue()) {
			return 1;
		}
		else {
			return 0;
		}						
	}
	
	// check if there a flush
	public static int flush(ArrayList<Card> hand) {
		if(hand.get(0).getSuit()== hand.get(1).getSuit() || hand.get(0).getSuit()== hand.get(2).getSuit() 
				|| hand.get(1).getSuit()== hand.get(2).getSuit()  ){
			return 2;
		}
		else {
			return 0;
		}
	}
	// check if there a straight hhhhh
	public static int straight(ArrayList<Card> hand) {
		int s = hand.get(0).getValue();
		if( hand.get(1).getValue() == s+1 && hand.get(2).getValue() == s+2 ) {
			return 3;
		}
		else {
			return 0;
		}
		
	}
	// check if there a three kind 
	public static int three_kind(ArrayList<Card> hand) {
		if( hand.get(0).getValue()== hand.get(1).getValue() && hand.get(0).getValue()== hand.get(2).getValue() 
				&& hand.get(1).getValue()== hand.get(2).getValue() ) {
			return 4;
		}
		else {
			return 0;
		}
	}
	// check if there a straight_flush
	public static int straight_flush(ArrayList<Card> hand) {
		if(flush(hand) != 0 && straight(hand) !=0 ) {
			return 5;		
		}
		else {
			return 0;
		}
	}
	
	
	public static int evalHand(ArrayList<Card> hand) {
		
	   //reorder 3 card from increment of its value. 
		for(int i=0;i<3;i++) {
			for(int x=2;x>i;x--) {
				if(hand.get(x).getValue() < hand.get(x-1).getValue()) {
					Card c =  hand.get(x);
					hand.set(x,hand.get(x-1)); 
					hand.set(x-1,c);
				}
			}
		}
		
		int b =0;  //pass edited hand, and wait for return value.
		//we value most beneficial occurence of 3 card in this if else chain
		if(straight_flush(hand)!=0) {
			b= 5;
		}
		else if(three_kind(hand) !=0) {
			b= 4;
		}
		else if(straight(hand)!=0 ) {
			b=3;
		}
		else if(flush(hand) != 0) {
			b= 2;
		}
		else if(pair(hand)!=0) {
			b= 1;
		}
		return b;
			
	}
	
	
	
	public static int evalPPWinnings(ArrayList<Card> hand, int bet) {
		return bet * evalHand(hand);	
		
	}
	
	//against dealer with total value of 3 cards.
	public static int compareHands(ArrayList<Card> dealer,
	ArrayList<Card> player) {
		int sum_p=0;
		int sum_d=0;
		
		for(Card x : dealer) {
			sum_d += x.getValue();
		}
		for(Card y : player) {
			sum_p += y.getValue();
		}
		
		if(sum_d < sum_p) {
			return 1; 
		}
		else if(sum_d >sum_p) {
			return 2;
		}
		else {
			return 0;
		}
		
	}
	public static String suitDisplay(char suit) {
	    char s =suit;
		if(suit=='D') {
		  s = '♦';
		}
		if(suit=='H') {
			s = '♥';
		}
		if(suit=='S') {
			s = '♠';
		} 
		if(suit== 'C') {
			s = '♣';
		}
		return Character.toString(s);
		
}	
		
		
public static String valueDisplay(int value) {
	 String x  = Integer.toString(value);
	if(value==11) {
		x = "J";
	}
	if(value==12) {
		x = "Q";
	}
	if(value==13) {
		x = "K";
	}
	if(value==14) {
		x = "A";
	}
	return x;
}

	
	

}
