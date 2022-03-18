import java.util.ArrayList;
public class Dealer {
	Deck theDeck;     
	ArrayList<Card> dealersHand; 
	public Dealer() {
		// TODO Auto-generated constructor stub
		theDeck = new Deck();
		
	}
	//dealer will hand 3 cards to him or s/o if dealHand() called
	public ArrayList<Card> dealHand(){
		ArrayList<Card> l = new ArrayList<Card>();
		
		if(theDeck.getDeck().size()<34) {
			theDeck.newDeck();
		}
		//receive a single card and remove single card in theDeck.getDeck()
		
		l.add(theDeck.getDeck().get(theDeck.getDeck().size()-1));
		theDeck.getDeck().remove(theDeck.getDeck().size()-1);
		
		l.add(theDeck.getDeck().get(theDeck.getDeck().size()-1));
		theDeck.getDeck().remove(theDeck.getDeck().size()-1);
		
		l.add(theDeck.getDeck().get(theDeck.getDeck().size()-1));
		theDeck.getDeck().remove(theDeck.getDeck().size()-1);
		
		return l;
	}
	public Deck holdDeck(){ //access ArrayList<Card> myDeck through this
		return theDeck;
	}
	public void getCard() {  //get 3 cards for players
		dealersHand = dealHand();
	}
	public ArrayList<Card> myCard(){
		return dealersHand;
	}
	public boolean evalQ(){  // check if dealer cards has at least a higher Q
		boolean have =false;
		for(Card n :dealersHand) {
			if(n.getValue()>11) {
			  have =true;
			}
		}
		return have;
	}
	
}
