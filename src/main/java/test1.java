import java.util.ArrayList;
public class test1 {
	//JUST FOR SELF-TEST ARRAY AND CLASSES.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p = new Player();
		Dealer d = new Dealer(); 
		d.getCard();
		for(Card n: d.myCard()) {
		System.out.print(n.getValue()+" "+n.getSuit());  
		
		}
		p.getCard(d.dealHand());
		for(Card z: p.myCard()) {
			System.out.print(z.getValue()+" "+z.getSuit());  
			
			}
		System.out.println(d.holdDeck().getDeck().size());
		
		
	}

}
