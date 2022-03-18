import java.util.ArrayList;
public class Player {
	ArrayList<Card> hand;
	int anteBet;
	int playBet;
	int pairPlusBet;
	int totalWinnings=0;
	int money_gain = 0;
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public void getCard(ArrayList<Card>c){
		hand =c; 		
	}
	public void set_anteB(int x) {
		anteBet = x;
	}
	public void set_playB(int b) {
		playBet =b;
	}
	
	
	public void set_pairPlusB(int c) {
		pairPlusBet =c;
	}
	public int get_pairPlusB() {
		return pairPlusBet;
	}
	
	
	public int get_anteB() {
		 return anteBet ;
	}
	
	public int get_playB() {
		return playBet;
	}
	
	
	
	public ArrayList<Card>  myCard() {
		return hand;
	}
	public void setWinnings(int i) { // pass either 1 or -1 to this parameter
		totalWinnings+=i;   
	}
	public void setMoney(int q) {  //pass positive or negative $gain to this parameter 
		money_gain += q;
	}
	public int getWinnings() {
		return totalWinnings;
	}
	public int getMoney() {
		return money_gain ;
	}
	
	
}
