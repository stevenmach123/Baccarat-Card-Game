import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
class ThreeCardLogicTest {
	
	ArrayList<Card> cards;
	
	@BeforeEach
	void init() {
		cards = new ArrayList<Card>();
	}
	
	@Test
	void pair1() {
		cards.add(new Card('C',10));
		cards.add(new Card('C',10));
		cards.add(new Card('H',11));
		
		assertEquals(1,ThreeCardLogic.evalHand(cards) ) ;
		
	}
	@Test
	void pair2() {
		cards.add(new Card('H',10));
		cards.add(new Card('H',8));
		cards.add(new Card('H',11));
		
		assertNotEquals(1,ThreeCardLogic.evalHand(cards) ) ;
		
	}
	@Test
	void pair3() {
		cards.add(new Card('S',10));
		cards.add(new Card('H',10));
		cards.add(new Card('C',10));
		
		assertNotEquals(1,ThreeCardLogic.evalHand(cards) ) ;
		
	}
	@Test
	void pair4() {
		cards.add(new Card('S',9));
		cards.add(new Card('H',8));
		cards.add(new Card('H',10));
		
		assertNotEquals(1,ThreeCardLogic.evalHand(cards) ) ;
		
	}
	@Test
	void pair5() {
		cards.add(new Card('H',9));
		cards.add(new Card('H',8));
		cards.add(new Card('H',10));
		
		assertNotEquals(1,ThreeCardLogic.evalHand(cards) ) ;
		
	}
	@Test
	void flush1() {
		cards.add(new Card('H',9));
		cards.add(new Card('H',8));
		cards.add(new Card('H',9));
		
		assertEquals(2,ThreeCardLogic.evalHand(cards) ) ;
		
	}
	@Test
	void flush2() {
		cards.add(new Card('H',9));
		cards.add(new Card('H',8));
		cards.add(new Card('H',10));
		
		assertNotEquals(2,ThreeCardLogic.evalHand(cards) ) ;
		
	}
	@Test
	void flush3() {
		cards.add(new Card('H',10));
		cards.add(new Card('D',13));
		cards.add(new Card('H',14));
		
		assertNotEquals(2,ThreeCardLogic.evalHand(cards) ) ;
		
	}
	@Test
	void flush4() {
		cards.add(new Card('H',11));
		cards.add(new Card('H',11));
		cards.add(new Card('H',11));
		
		assertNotEquals(2,ThreeCardLogic.evalHand(cards) ) ;
		
	}
	@Test
	void flush5() {
		cards.add(new Card('H',8));
		cards.add(new Card('H',8));
		cards.add(new Card('H',10));
		
		assertEquals(2,ThreeCardLogic.evalHand(cards) ) ;
		
	}
	@Test
	void straight1() {
		cards.add(new Card('H',10));
		cards.add(new Card('C',9));
		cards.add(new Card('H',8));
		
		assertEquals(3,ThreeCardLogic.evalHand(cards) ) ;
		
	}
	
	@Test
	void straight2() {
		cards.add(new Card('H',8));
		cards.add(new Card('H',8));
		cards.add(new Card('C',10));
		
		assertNotEquals(3,ThreeCardLogic.evalHand(cards) ) ;
		
	}
	@Test
	void straight3() {
		cards.add(new Card('S',8));
		cards.add(new Card('S',10));
		cards.add(new Card('S',9));
		
		assertNotEquals(3,ThreeCardLogic.evalHand(cards) ) ;
		
	}
	@Test
	void straight4() {
		cards.add(new Card('S',14));
		cards.add(new Card('S',12));
		cards.add(new Card('D',13));
		
		assertEquals(3,ThreeCardLogic.evalHand(cards) ) ;
		
	}

	
	@Test
	void Three_kind_1() {
		cards.add(new Card('S',8));
		cards.add(new Card('S',8));
		cards.add(new Card('S',8));
		

		assertEquals(4,ThreeCardLogic.evalHand(cards) ) ;
	}
	@Test
	void Three_kind_2() {
		cards.add(new Card('S',8));
		cards.add(new Card('S',9));
		cards.add(new Card('S',8));
		

		assertNotEquals(4,ThreeCardLogic.evalHand(cards) ) ;
	}
	@Test
	void Three_kind_3() {
		cards.add(new Card('S',8));
		cards.add(new Card('H',8));
		cards.add(new Card('S',8));
		

		assertEquals(4,ThreeCardLogic.evalHand(cards) ) ;
	}
	@Test 
	void Straigth_flush_1(){
		cards.add(new Card('D',8));
		cards.add(new Card('D',9));
		cards.add(new Card('D',10));
		assertEquals(5,ThreeCardLogic.evalHand(cards) ) ;
	}
	
	@Test 
	void Straigth_flush_2(){
		cards.add(new Card('D',8));
		cards.add(new Card('H',9));
		cards.add(new Card('D',10));
		assertNotEquals(5,ThreeCardLogic.evalHand(cards) ) ;
	}
	@Test 
	void Straigth_flush_3(){
		cards.add(new Card('H',9));
		cards.add(new Card('H',10));
		cards.add(new Card('H',8));
		assertEquals(5,ThreeCardLogic.evalHand(cards) ) ;
	}
	
	@Test 
	void Straigth_flush_4(){
		cards.add(new Card('H',9));
		cards.add(new Card('H',13));
		cards.add(new Card('H',8));
		assertNotEquals(5,ThreeCardLogic.evalHand(cards) ) ;
	}


}
