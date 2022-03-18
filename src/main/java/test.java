
import java.util.HashMap;





import java.util.HashMap;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

//JUST FOR SELF-TEST GENERAL GUI 

public class test extends Application  {
	int i = 1;
	Dealer d = new Dealer();
	Player p = new Player();
	public static void main(String[] args) 
    {
        Application.launch(args);
		
        
        
    }   
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Dealer d1 = new Dealer();
		Dealer d = new Dealer();
		d.getCard();
		p.getCard(d.dealHand());
		System.out.print(p.myCard());
		p.getCard(d.dealHand());
		p.myCard();
		System.out.print(p.myCard());   
		System.out.println(p.getWinnings());
		System.out.println(p.getMoney());
		
		VBox b = new VBox(); 
		Text txt = new Text();
		Text txtr; 
		txt.setText("hello"+Integer.toString(p.getMoney()));
		txtr = txt;
		txtr.setText("helloo");
		Button a = new Button("St");
		a.setOnAction(e->{
			increase(p);
			txt.setText(""+p.getWinnings());
		});
			
		b.getChildren().addAll(txt,a);
			
			
		Scene scene = new Scene(b, 700, 700);  
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
	}  
	public void increase(Player p) {
		p.setWinnings(1);
	}
	
	
	
	
	
	
	
}
