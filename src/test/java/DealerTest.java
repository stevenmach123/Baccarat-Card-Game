import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.Random;


public class DealerTest {
	Dealer d;
	Player p1;
	Player p2;
	@BeforeEach
	void init() {
		d = new Dealer();
		p1= new Player();
		p2 = new Player();;
	}
	
	@Test
	void checkSize(){
		d.getCard();
		p1.getCard(d.dealHand());
		p1.getCard(d.dealHand());
		p1.getCard(d.dealHand());
		p1.getCard(d.dealHand());
		p1.getCard(d.dealHand());
		assertEquals(34,d.holdDeck().getDeck().size());
		
		
	}
	@Test 
	void newDeck_Exist(){
		d.getCard();
		p1.getCard(d.dealHand());
		p1.getCard(d.dealHand());
		p1.getCard(d.dealHand());
		p1.getCard(d.dealHand());
		p1.getCard(d.dealHand());
		p1.getCard(d.dealHand());
		
		assertEquals(31,d.holdDeck().getDeck().size());
		p1.getCard(d.dealHand());
		
		
		assertEquals(49,d.holdDeck().getDeck().size());
	}
	
	
	
	@Test
	void first3Card(){
		ArrayList<Card> card= new ArrayList<Card>();
		card.add(d.holdDeck().getDeck().get(51));
		card.add(d.holdDeck().getDeck().get(50));
		card.add(d.holdDeck().getDeck().get(49));
		d.getCard();
		
		assertEquals(card.get(0),d.myCard().get(0));
		assertEquals(card.get(1),d.myCard().get(1));
		assertEquals(card.get(2),d.myCard().get(2));
		
	}
	@Test
	void noReceiveSame() {
		d.getCard();
		p1.getCard(d.dealHand());
		assertNotEquals(p1.myCard().get(0),d.myCard().get(0));
		assertNotEquals(p1.myCard().get(1),d.myCard().get(1));
		assertNotEquals(p1.myCard().get(2),d.myCard().get(2));
	}
	@Test
	void receiveSameSize() {
		d.getCard(); 
		p1.getCard(d.dealHand());
		assertEquals(p1.myCard().size(),d.myCard().size() );
	}
	
	@Test
	void ValueforPlayer() {
		ArrayList<Card> card= new ArrayList<Card>();
		card.add(d.holdDeck().getDeck().get(45));
		card.add(d.holdDeck().getDeck().get(44));
		card.add(d.holdDeck().getDeck().get(43));
		d.getCard();
		p1.getCard(d.dealHand());
		p1.getCard(d.dealHand());
		
		assertEquals(card.get(0).getValue(),p1.myCard().get(0).getValue())  ;
		assertEquals(card.get(1).getValue(),p1.myCard().get(1).getValue())  ;
		assertEquals(card.get(2).getValue(),p1.myCard().get(2).getValue())  ;
	}
	
	@Test
	void SuitforPlayer() {
		ArrayList<Card> card= new ArrayList<Card>();
		card.add(d.holdDeck().getDeck().get(45));
		card.add(d.holdDeck().getDeck().get(44));
		card.add(d.holdDeck().getDeck().get(43));
		d.getCard();
		p1.getCard(d.dealHand());
		p1.getCard(d.dealHand());
		
		assertEquals(card.get(0).getSuit(),p1.myCard().get(0).getSuit())  ;
		assertEquals(card.get(1).getSuit(),p1.myCard().get(1).getSuit())  ;
		assertEquals(card.get(2).getSuit(),p1.myCard().get(2).getSuit())  ;
	}
	
	
	
	@Test
	void second3forPlayer(){
		ArrayList<Card> card= new ArrayList<Card>();
		
		
		
		card.add(d.holdDeck().getDeck().get(51));
		card.add(d.holdDeck().getDeck().get(50));
		card.add(d.holdDeck().getDeck().get(49));
		card.add(d.holdDeck().getDeck().get(48));
		card.add(d.holdDeck().getDeck().get(47));
		card.add(d.holdDeck().getDeck().get(46));
		d.getCard();
		p1.getCard(d.dealHand());
		
		assertEquals(card.get(0),d.myCard().get(0));
		assertEquals(card.get(1),d.myCard().get(1));
		assertEquals(card.get(2),d.myCard().get(2));
		
		assertEquals(card.get(3),p1.myCard().get(0));
		assertEquals(card.get(4),p1.myCard().get(1));
		assertEquals(card.get(5),p1.myCard().get(2));
			
	}
	@Test
	void third3forPlayer(){
		ArrayList<Card> card= new ArrayList<Card>();
				
		card.add(d.holdDeck().getDeck().get(45));
		card.add(d.holdDeck().getDeck().get(44));
		card.add(d.holdDeck().getDeck().get(43));
		
		
		d.getCard();
		p1.getCard(d.dealHand());
		p2.getCard(d.dealHand());
				
		assertEquals(card.get(0),p2.myCard().get(0));
		assertEquals(card.get(1),p2.myCard().get(1));
		assertEquals(card.get(2),p2.myCard().get(2));
			
	}
	
	
	
	
	
	
	
	
}
