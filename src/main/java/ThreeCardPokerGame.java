import javafx.application.Application;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
//NAME: KHANG G MACH 
// CS342 PROJECT 2 
public class ThreeCardPokerGame extends Application {

	

	//feel free to remove the starter code from this method
	
	Player me= new Player();
	Player player = new Player();
	Dealer d = new Dealer();
	
	
	int turn_i =1; // for display a cycle. 
    int turn =0;  // for display turn 
    
	private TextArea detailArea = new TextArea("");
	private TextArea errorArea = new TextArea("");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Let's Play Three Card Poker!!!");
		
		
		
		
	
		
		//TextAreas for  comment and details
		VBox sideB = new VBox(20);
		sideB.setStyle("-fx-border-style: solid;"
		            + "-fx-border-width: 1;"
		            + "-fx-border-color: purple");
		
		
		sideB.setPrefWidth(300);
		sideB.setMinHeight(400);
		errorArea.setEditable(false);
		detailArea.setEditable(false);
		errorArea.setMaxSize(300,100);
		
		Text comment = new Text("COMMENT");
		Text detail = new Text("DETAILS");
	    sideB.getChildren().addAll(comment,errorArea,detail,detailArea);
		
		
		//---- cenB  //central Box, 3 table.
		HBox cenB = new HBox();
		
		cenB.setStyle("-fx-border-style: solid;"
		            + "-fx-border-width: 1;"
		            + "-fx-border-color: yellow");
		cenB.setPrefWidth(100);
		cenB.setMinHeight(300);
		
		
		//--- p1
		VBox p1 = new VBox();
		p1.setStyle("-fx-border-style: solid;"
	            + "-fx-border-width: 1;"
	            + "-fx-border-color: orange");
		
		p1.setMinWidth(200);
		p1.setAlignment(Pos.BOTTOM_CENTER);
		
		HBox info =new HBox(20);
		info.setAlignment(Pos.CENTER);
		
		
		//money and totalWinnings 
		Text win_p1 =  new Text();
		Text mon_p1 = new Text();
		
		win_p1.setStyle("-fx-font: 13px Verdana");
		mon_p1.setStyle("-fx-font: 13px Verdana"); 
		
		
		mon_p1.setText("$gain "+Integer.toString(me.getMoney()) );
		win_p1.setText("totalWin "+Integer.toString(me.getWinnings()));
		 
		
		
		
		
		info.getChildren().addAll(mon_p1,win_p1);
		
		//nice pink table
		HBox card_p1 = new HBox(12);
		card_p1.setAlignment(Pos.CENTER);
		card_p1.setStyle("-fx-border-style: solid;"
	            + "-fx-border-width: 1;"
	            + "-fx-border-color: pink");
		card_p1.setPrefHeight(50);
		
				
	
	    Text fme1 = new Text("FOLD"); 
	    Text fme2 = new Text("FOLD"); 
	    Text fme3  =new Text("FOLD"); 
	   
	    card_p1.getChildren().addAll(fme1,fme2,fme3);
		
	    //Any name for you, in this case it is me :)
		Text name_p1 = new Text(); 
		name_p1.setText("Khang");
		name_p1.setStyle("-fx-font: 13px Verdana");
	          
		
	
		
		
		p1.getChildren().addAll(name_p1,card_p1,info);
		
		//--p1
		
		
		//--d1
		VBox d1 = new VBox();
		d1.setMinWidth(200);
		d1.setAlignment(Pos.TOP_CENTER);
		
		
		
		Text name_d1 = new Text(); 
		name_d1.setText("Dealer");
		name_d1.setStyle("-fx-font: 13px Verdana");
		
		
		
		HBox card_d1 = new HBox(12);
		card_d1.setAlignment(Pos.CENTER);
		card_d1.setStyle("-fx-border-style: solid;"
	            + "-fx-border-width: 1;"
	            + "-fx-border-color: pink");
		card_d1.setPrefHeight(50);
		
		 Text fd1 = new Text("FOLD"); 
		 Text fd2 = new Text("FOLD"); 
		Text fd3  =new Text("FOLD"); 
		card_d1.getChildren().addAll(fd1,fd2,fd3);	
		
		d1.getChildren().addAll(card_d1,name_d1);
			
		
		//--d1
					
		//--p2	
		VBox p2 = new VBox();
		p2.setMinWidth(200);
		p2.setAlignment(Pos.BOTTOM_CENTER);
		
		
		HBox card_p2 = new HBox(12);
		card_p2.setAlignment(Pos.CENTER);
		card_p2.setStyle("-fx-border-style: solid;"
	            + "-fx-border-width: 1;"
	            + "-fx-border-color: pink");
		card_p2.setPrefHeight(50);
		
		Text fp1 = new Text("FOLD"); 
		Text fp2 = new Text("FOLD"); 
		Text fp3  =new Text("FOLD"); 
		card_p2.getChildren().addAll(fp1,fp2,fp3);	
		
		
		
		
		Text name_p2 = new Text(); 
		name_p2.setText("Angle");
		name_p2.setStyle("-fx-font: 13px Verdana");
	                  
		
		HBox info2 =new HBox(20);
		info.setAlignment(Pos.CENTER);
		Text win_p2 =  new Text();
		win_p2.setText("totalWin "+Integer.toString(player.getWinnings()) );
		win_p2.setStyle("-fx-font: 13px Verdana");
		
		Text mon_p2 = new Text();
		mon_p2.setText("$gain "+ Integer.toString(player.getMoney())  );
		mon_p2.setStyle("-fx-font: 13px Verdana");
		info2.getChildren().addAll(mon_p2,win_p2);
	
	
	    p2.getChildren().addAll(name_p2,card_p2,info2);	
	    
	    //--p2
	    
		cenB.getChildren().addAll(p1,d1,p2);
		
		//---- cenB end
		
		
		//--botB
		HBox botB = new HBox(50);
		botB.setAlignment(Pos.CENTER);
		botB.setStyle("-fx-border-style: solid;"
		            + "-fx-border-width: 1;"
		            + "-fx-border-color: green");
		botB.setPrefHeight(100);
		botB.setAlignment(Pos.CENTER);
		
		//start if you want to play 
		//continue, if you done insert text for play wager and pair plus
		Button  start = new Button("START");	
		Button con = new Button("CONTINUE");
		VBox bot22 = new VBox(20);
		
		
		//give up or do deal wager buttons. 
		bot22.setAlignment(Pos.CENTER);
		Button giveup = new Button("GIVE UP");
		Button wager = new Button("PLAY WAGER");
		bot22.getChildren().addAll(wager,giveup);
		
		VBox input = new VBox(10);
		Text dpw  = new Text("PLAY-WAGER BET");
	    Text dpp = new Text("PAIR PLUS BET");
	    //later setText for either playwager or pairplus
		TextField pp = new TextField();
		TextField pw = new TextField();
		
		pp.setDisable(true); 
		pw.setDisable(true);
		giveup.setDisable(true);
		wager.setDisable(true);
		con.setDisable(true);

		input.getChildren().addAll(dpp,pp,dpw,pw);
		
		botB.getChildren().addAll(start,con,bot22,input);
		
		//--botB
		
		
		
	
		start.setOnAction(e->{
			detailArea.setEditable(true);  //when start, AreaText is editable. Hope not write anything there, it will display as we went through buttons and bets
			detailArea.setEditable(true);     
			player = new Player(); 
			me = new Player();
			d = new Dealer();
		 
			detailArea.setText("");
			errorArea.setText("");
			
			
			turn =0; turn_i=1;
			
			resetTable(fme1,fme2,fme3);  //set new table from previous game
			resetTable(fp1,fp2,fp3);
			resetTable(fd1,fd2,fd3);
			
			
			 win_p2.setText("totalWin "+ player.getWinnings()) ;// new players with 0 winnings and $gain 
			  mon_p2.setText("$gain "+player.getMoney() );	 
			  win_p1.setText("totalWin "+ me.getWinnings()   );
			  mon_p1.setText("$gain "+ me.getMoney() ); 
			
			pp.setDisable(false);  //play wager, pair plus to  continue, activated 
			pw.setDisable(false);   //while start deactivated
			con.setDisable(false);
			start.setDisable(true);
			detailArea.appendText("Start a new game\n");
			errorArea.appendText("Card is also resorted\n");
			errorArea.appendText("Please input moneys, can leave blank or 0 to Pair-Plus. Error will display if input inappropriately");
			//detailArea.setEditable(false);
			//detailArea.setEditable(false);
			
		});
		
		
		
		
		con.setOnAction(e->{
			errorArea.appendText("Please input moneys, can leave blank or 0 to Pair-Plus. Error will display if input inappropriately \n");			
			start.setDisable(true);
			
			
			resetTable(fme1,fme2,fme3); 
			resetTable(fp1,fp2,fp3);
			resetTable(fd1,fd2,fd3);
			
			//number evaluation if you insert inappropriate text
			if(evalText(pw.getText())==true && ( evalText(pp.getText())==true || pp.getText().isEmpty() )  ) {
				// if pair plus not empty, then evaluate pp and pw within range. Assume 0 is ok if bypass pair plus.
				if(!(pp.getText().isEmpty()) && ( Integer.parseInt(pp.getText()) >=5 && Integer.parseInt(pp.getText()) <=  25 || Integer.parseInt(pp.getText()) ==0  )   
					&& 	Integer.parseInt(pw.getText())  >=5	 && 	Integer.parseInt(pw.getText()) <=25 ) {
					
					//distribute cards
					if( d.holdDeck().getDeck().size() <34) {			
						errorArea.appendText("Card is resorted, less than 34\n");
					} 
					d.getCard();
					if( d.holdDeck().getDeck().size() <34) {			
						errorArea.appendText("Card is resorted, less than 34\n");
					}  
					me.getCard(d.dealHand());
					if( d.holdDeck().getDeck().size() <34) {			
						errorArea.appendText("Card is resorted, less than 34\n");
					} 
					
					player.getCard(d.dealHand());
					  
				    
					//set ante and pair plus bet to me if pp and pw is appropriate
					me.set_anteB(Integer.valueOf(pw.getText()));
				    me.set_pairPlusB(Integer.parseInt(pp.getText()));
				  	giveup.setDisable(false);
				  	wager.setDisable(false);
				  	
				  	pp.setDisable(true);
				  	pw.setDisable(true);
				  	con.setDisable(true);
				  	unfold(fme1,fme2,fme3,me.myCard()); //face up for me, while other still down
				}
				
				//if pp is empty, then know no pair plus bet, evaluate pp within range
				else if(pp.getText().isEmpty() &&  Integer.parseInt(pw.getText())  >=5	&& Integer.parseInt(pw.getText()) <=25 ) {
					  d.getCard();
					  me.getCard(d.dealHand());
					  player.getCard(d.dealHand());
					  
					  me.set_pairPlusB(0);
					  me.set_anteB(Integer.valueOf(pw.getText()));
					  
					  giveup.setDisable(false);
					  wager.setDisable(false);
					  con.setDisable(true);
					  pp.setDisable(true);
					  pw.setDisable(true);
					  unfold(fme1,fme2,fme3,me.myCard());
				}
				else {
					if( Integer.parseInt(pw.getText())  <5	|| Integer.parseInt(pw.getText()) >25) {
						errorArea.appendText("Play-Wager not within 5 and 25, retry!\n");
					}
					if(Integer.parseInt(pp.getText()) < 5 || Integer.parseInt(pp.getText()) > 25 ) {
						errorArea.appendText("Pair-Plus not within 5 and 25, retry!\n");
					}
					
					
					
				}
				
						
				
			}
			else {
				errorArea.appendText("Please input appropriate Play-Wager and/or Pair-Plus, retry!\n");
				
			}
			//random options for pair plus and ante bet for player
			Random rand  =new Random();
			int prand  = rand.nextInt(4);
			player.set_anteB(5+rand.nextInt(21));
			
			if(prand!=0) {
				prand  =5+rand.nextInt(21);
			}
			
			player.set_pairPlusB(prand);
		});   
		
		giveup.setOnAction(e->{
			 turn++;
			  //you lose
			 me.setWinnings(-1);
			 //detail evaluation from the round
			 detailArea.appendText("----Round "+turn+ "----\n");
			 detailArea.appendText("Khang\n");
			  evalGiveUp(me);
			  			  			  			  
			  detailArea.appendText("Angle\n");
			  
			   int pp_player =ThreeCardLogic.evalPPWinnings(player.myCard(), player.get_pairPlusB());
			   int decision = automate(player,pp_player);
			   if(decision ==1) {
				   int b_player =0;
				   if(d.evalQ()==true) {
					   b_player =ThreeCardLogic.compareHands(d.myCard(),player.myCard());

				   }
				   evalRound(player,d,pp_player,b_player);
			   }
			  
			
			  
			  //update $gain and totalWinnings
			  win_p2.setText("totalWin "+ Integer.toString(player.getWinnings() ));	 
			  mon_p2.setText("$gain "+ Integer.toString(player.getMoney() ));	 
			  win_p1.setText("totalWin "+ Integer.toString(me.getWinnings() )  );
			  mon_p1.setText("$gain "+ Integer.toString(me.getMoney() ));
			  
			  
			  //round and cycle evaluate, you need done 4 round before can click start.
			  if(turn %4 !=0) {
				  errorArea.appendText("There "+(4*turn_i-turn)+" more round before have restart option, show your spirit!");
			  }
			  if(turn %4 ==0) {
				  turn_i++;
				  errorArea.appendText("You can restart new game, otherwise need play another 3 game");
				  start.setDisable(false);
			  }
			
			  giveup.setDisable(true);
			  wager.setDisable(true);
			  con.setDisable(false);   //pp and pw to continue is activated again
			  pp.setDisable(false);     //while option to deal with players is deactivated
			  pw.setDisable(false);	
			  pp.clear();
			  pw.clear();
			  
			  unfold(fd1,fd2,fd3,d.myCard());
			  unfold(fp1,fp2,fp3,player.myCard());

			  
		});
		   
		//player wager deal
		wager.setOnAction(e->{
			 
			 
			 me.set_playB(me.get_anteB());	// set up play wager bet
			 player.set_playB(player.get_anteB());
		     //evaluate total $gain from pair plus
			 int pp_me = ThreeCardLogic.evalPPWinnings(me.myCard(),me.get_pairPlusB());
			 int pp_player =ThreeCardLogic.evalPPWinnings(player.myCard(), player.get_pairPlusB());
			
					 
			 
			int b_me ;
			int b_player;
		    if(d.evalQ()==true) {
		    	// who will win against ? 1 for win.  2 for lost. 0 for draw
		    	b_me = ThreeCardLogic.compareHands(d.myCard(),me.myCard());
				b_player =ThreeCardLogic.compareHands(d.myCard(),player.myCard());
		    }
		    else {  //draw if dealer no Q or higher
		    	b_me =0;
		    	b_player =0;
		    }
			unfold(fd1,fd2,fd3,d.myCard()); // you can see other cards
			unfold(fp1,fp2,fp3,player.myCard());
		    		    				
			adjustWinnings(b_me,me);
			adjustWinnings(b_player,player);
			
		
				
			  giveup.setDisable(true);  //pp and pw to continue is activated again
			  							//while options to deal with players is deactivated 
			  wager.setDisable(true);
			  con.setDisable(false);
			  pp.setDisable(false);
			  pw.setDisable(false);	
			  pp.clear();
			  pw.clear();
			  
			  turn++;
			  detailArea.appendText("----Round "+turn+ "----\n");
			  detailArea.appendText("Khang\n");
			  evalRound(me,d,pp_me,b_me);
			  			  			  			  
			  detailArea.appendText("Angle\n");
			  evalRound(player,d,pp_player,b_player);
			  
			  win_p2.setText("totalWin "+ Integer.toString(player.getWinnings() ));	 
			  mon_p2.setText("$gain "+ Integer.toString(player.getMoney() ));	 
			  win_p1.setText("totalWin "+ Integer.toString(me.getWinnings() )  );
			  mon_p1.setText("$gain "+ Integer.toString(me.getMoney() )); 
			
			  if(turn %3 !=0) {
				  errorArea.appendText("There "+(3*turn_i-turn)+" more round before have restart option, show your spirit!");
			  }
			  if(turn %3 ==0) {
				  turn_i++;
				  errorArea.appendText("You can restart new game, otherwise need play another 4 game");
				  start.setDisable(false);
			  }
			
		});     
		
		
		
		
		BorderPane borderPane = new BorderPane(); 	
			
		
		
		borderPane.setLeft(sideB);
		borderPane.setMargin(sideB,new Insets(10,10,10,10));			
		borderPane.setCenter(cenB);
		borderPane.setMargin(cenB,new Insets(10,10,10,10));
	    borderPane.setBottom(botB);
	    borderPane.setMargin(botB,new Insets(10,10,10,10));
	      
	    
		Scene scene = new Scene(borderPane);
		primaryStage.setScene(scene);
		primaryStage.show();      
	    
		
	}
	//eval string is integer
	public boolean evalText(String p) {
		try { 
	        Integer.parseInt(p); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    
	    return true;
	}
	//evaluate Pair-Plus gain (if made one) , Play wager gain from one round per player
	public void evalRound(Player p,Dealer d, int evalPP,int b_me) {
		int Gain =0;
		if(p.get_pairPlusB() !=0 ) {
		  if(evalPP ==0) {
			  detailArea.appendText(" Lost Pair-Plus"+"("+p.get_pairPlusB()*-1+")\n");  
			  Gain  += p.get_pairPlusB()  *-1;
		  }
		  else {
			  detailArea.appendText(" Win Pair-Plus "+PP_name(evalPP/p.get_pairPlusB())+ " ("+"+"+evalPP/p.get_pairPlusB()+"*"+p.get_pairPlusB()+")\n"   );
			  Gain  += p.get_pairPlusB()* (evalPP/p.get_pairPlusB() ) ;
		  }
		}
		else {
		  detailArea.appendText(" No Pair-Plus bet\n"); 
		}
	 	
		if(b_me ==0) {
			  if(d.evalQ() == true) {
				  detailArea.appendText(" Draw Game by against card, Gain 0 from Play-wager and Ante bet \n");
			  }
			  else if(d.evalQ() ==false){
				  detailArea.appendText(" Draw Game, since Dealer no higher than Q, Gain 0 from Play-wager and Ante bet\n");
		  		}
			  
		  }
		else if(b_me !=0) {
			  if(b_me ==1) {
				  detailArea.appendText(" Win playWager "+"("+p.get_playB()+"), so ("+"+"+p.get_playB()*2+") \n");
				  Gain +=  p.get_playB()*2;
			  }
			  else if(b_me==2) {
				  detailArea.appendText(" Lost playWager "+"("+p.get_playB()*-1+")\n");
				  Gain +=  p.get_playB()*-1;
			  }
		     
		  }
	   detailArea.appendText(" Gain "+Gain+"\n");
	  
	   p.setMoney(Gain);
	
	
	}
	//evaluate give up round each player per round
   public void evalGiveUp(Player p) {
	   int Gain =0;
   		if(p.get_pairPlusB() !=0 ) {
   			detailArea.appendText(" Lost Pair-Plus by Give Up"+"("+p.get_pairPlusB()*-1+")\n");
   			Gain += p.get_pairPlusB()*-1;
   		}
   		else {
   			detailArea.appendText(" No Pair-Plus bet\n"); 
   		}
   
		 detailArea.appendText(" Give up Play-Wager"+"("+p.get_anteB()*-1+")\n");
		 Gain += p.get_anteB()*-1;
		 detailArea.appendText(" Gain "+Gain+"\n");
		  
		 p.setMoney(Gain);
	
   		
   }
	
	// unfold 3 cards
	public void unfold(Text f1, Text f2,Text f3, ArrayList<Card> l ) {
		
		
		f1.setText(ThreeCardLogic.suitDisplay(l.get(0).getSuit()) +ThreeCardLogic.valueDisplay(l.get(0).getValue()) );
		f2.setText(ThreeCardLogic.suitDisplay(l.get(1).getSuit()) +ThreeCardLogic.valueDisplay(l.get(1).getValue()) );
		f3.setText(ThreeCardLogic.suitDisplay(l.get(2).getSuit()) +ThreeCardLogic.valueDisplay(l.get(2).getValue()) );
		f1.setFont(Font.font("Verdana",20));
		f2.setFont(Font.font("Verdana",20));
		f3.setFont(Font.font("Verdana",20));
		if(l.get(0).getSuit() =='D' || l.get(0).getSuit() =='H') {
			f1.setFill(Color.RED);
		}
		if(l.get(1).getSuit() =='D' || l.get(1).getSuit() =='H') {
			f2.setFill(Color.RED);
		}
		if(l.get(2).getSuit() =='D' || l.get(2).getSuit() =='H') {
			f3.setFill(Color.RED);
		}
		
		
		
	}
	// display kind of pair plus win, for extra clarity
	public String PP_name(int win) {
		if(win ==5) {
			return "Straight Flush";
		}
		if(win ==4) {
			return "Three of Kind";
		}
		if(win ==3) {
			return "Straight";
		}
		if(win==2) {
			return "Flush";
		}
		if(win ==1) {
			return "Pair";
		}
		return "0";
	}
	
	public int automate(Player p,int pp_player) {
		int decision =1;
		int p_sum =0;
		for(Card x : p.myCard()){
		   p_sum += x.getValue();
		   
		}

		 if (p.get_pairPlusB()  > p.get_playB() ){
			    if( pp_player ==0){ 
			    	if(p_sum < 15){
			        evalGiveUp(p);
			        p.setWinnings(-1);
			        decision =0; 
			    }
			  } 
		}
		else{
			 if(p_sum < 15){
				
			     if(new Integer(p.get_playB()/3).floatValue() >  p.get_pairPlusB() && pp_player ==0 ) {
			        evalGiveUp(p);
			     	p.setWinnings(-1);
			     	decision =0; 
			     }
			 }
		}
			    
		 return decision;  
		
	}
	
	
	public void adjustWinnings(int b, Player p) {
		int win=0;
		if(b ==1) {
			win =1;		
		}
		if(b==2) {
			win = -1;
		}
		
		p.setWinnings(win);
	}
	
	public void resetTable(Text f1, Text f2, Text f3) {
		f1.setText("FOLD"); f1.setFill(Color.BLACK);
		f2.setText("FOLD");f2.setFill(Color.BLACK);
		f3.setText("FOLD");f3.setFill(Color.BLACK);
	}
	
	
	
	
	

}
