import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.Random;

public class DeckTest {
	Deck deck;
	@BeforeEach
	void init() {
		deck = new Deck();	
		
	}
	
	@Test 
	void checkSizeShuffle(){
		deck.newDeck();
		assertEquals(52,deck.getDeck().size() );
	}
	
	
	@Test
	void allSuit() {
	
		int countS =0;
		int countD=0;
		int countC =0;
		int countH =0;
		for(Card d : deck.getDeck()) {
			if(d.getSuit() =='S') {
				countS++;
			}
		}
		for(Card d : deck.getDeck()) {
			if(d.getSuit() =='D') {
				countD++;
			}
		}
		for(Card d : deck.getDeck()) {
			if(d.getSuit() =='H') {
				countH++;
			}
		}
		for(Card d : deck.getDeck()) {
			if(d.getSuit() =='C') {
				countC++;
			}
		}
		assertEquals(13,countS);
		assertEquals(13,countD);
		assertEquals(13,countH);
		assertEquals(13,countC);
		
	}
	@Test
	void simpleValue() {
		Random rand = new Random();
		int count =0;
		int num = rand.nextInt(13)+2;
		for(int i=0;i<52;i++) {
	    	 if(deck.getDeck().get(i).getValue() == num ) {
	    		 count++;
	    	 }
	     }
		assertEquals(4,count);
	}
	
	@Test 
	void all3Num(){
		int count12 =0;
		int count4 =0;
		int count9 =0;
		for(Card d : deck.getDeck()) {
			if(d.getValue() ==4) {
				count4++;
			}
		}
		for(Card d : deck.getDeck()) {
			if(d.getValue() ==9) {
				count9++;
			}
		}
		for(Card d : deck.getDeck()) {
			if(d.getValue() ==12) {
				count12++;
			}
		}
		assertEquals(4,count9);
		assertEquals(4,count4);
		assertEquals(4,count12);
		
	}
	@Test
	void shuffleSuit(){
		deck.newDeck();
		int countS =0;
		int countD=0;
		int countC =0;
		int countH =0;
		for(Card d : deck.getDeck()) {
			if(d.getSuit() =='S') {
				countS++;
			}
		}
		for(Card d : deck.getDeck()) {
			if(d.getSuit() =='D') {
				countD++;
			}
		}
		for(Card d : deck.getDeck()) {
			if(d.getSuit() =='H') {
				countH++;
			}
		}
		for(Card d : deck.getDeck()) {
			if(d.getSuit() =='C') {
				countC++;
			}
		}
		assertEquals(13,countS);
		assertEquals(13,countD);
		assertEquals(13,countH);
		assertEquals(13,countC);
		
		
	}
	
	@RepeatedTest(30)
	void repeat1Value() {
	     Random rand = new Random();
	     int num = rand.nextInt(13)+2;
	     int count =0;
	     for(int i=0;i<52;i++) {
	    	 if(deck.getDeck().get(i).getValue() == num ) {
	    		 count++;
	    	 }
	     }
	     assertEquals(4,count);
	}
	
	@RepeatedTest(30)
	void repeat1ValueShuffle() {
		 deck.newDeck();
		 
	     Random rand = new Random();
	     int num = rand.nextInt(13)+2;
	     int count =0;
	     for(int i=0;i<52;i++) {
	    	 if(deck.getDeck().get(i).getValue() == num ) {
	    		 count++;
	    	 }
	     }
	     assertEquals(4,count);
	}
	
	
	@RepeatedTest(40)
	void repeat2Value() {
		
	     Random rand = new Random();
	     int num = rand.nextInt(13)+2;
	     int count =0;
	     int count2=0;
	     for(int i=0;i<52;i++) {
	    	 if(deck.getDeck().get(i).getValue() == num ) {
	    		 count++;
	    	 }
	     }
	     assertEquals(4,count);
	     int num2 = rand.nextInt(13)+2;
	     
	     for(int i=0;i<52;i++) {
	    	 if(deck.getDeck().get(i).getValue() == num2 ) {
	    		 count2++;
	    	 }
	     }
	     assertEquals(4,count2);
	     
	     
	}
	@Test 
	void NO_ANY_ERROR_TEST() {
		deck.newDeck();
		int count;
		for(int i =2;i<15;i++) {
			count =0;
			for(int y=0;y<52;y++) {
				if(deck.getDeck().get(y).getValue()==i) {
					count++;
				}				
			}
			assertEquals(4,count);
     }
		
		
		
	}
	
	
	
	
	
	
}
