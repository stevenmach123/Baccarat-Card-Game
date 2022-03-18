import java.util.ArrayList;
import java.util.Random;
public class Deck extends ArrayList<Card> {
	ArrayList<Card> myDeck = new ArrayList<Card>(52); 
	char suit[] = {'C','D','S','H'};

	public Deck() {
		// TODO Auto-generated constructor stub
		
		for(int i=0;i<4;i++) {
			char x = suit[i];
			for(int y=2; y<15;y++) {
				myDeck.add(new Card(x,y)); 
			}
		}
		Shuffle();  //after generate ordered ArrayList<Card>, then shuffle
		
	}
	public void newDeck() {  // do reshuffle 
		myDeck.clear();
		myDeck = new ArrayList<Card>(52);
		
		for(int i=0;i<4;i++) {
			char x = suit[i];
			for(int y=2; y<15;y++) {
				myDeck.add(new Card(x,y)); 
			}
		}
		Shuffle();
		
	}      
	
	private void Shuffle() {
		for(int i=0;i<52;i++) {
			Random random = new Random();
			int b = random.nextInt(52);
			Card c =  myDeck.get(i);
			myDeck.set(i,myDeck.get(b)); 
			myDeck.set(b,c);
					
		}
	}
	//useful for Dealer call holdDeck().getDeck() to access myDeck;
	public ArrayList<Card> getDeck() {
		return myDeck;
		
	}
	
}
