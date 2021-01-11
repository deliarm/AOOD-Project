/*******************************************************************************
- Full name: Asad Choudhry, Osama Hameed, Deliar Mohammadi, Oscar Campos 
- Class: CPSC and Class Number 233
- Assignment: AOOD PROJECT!!!
- Due: Tuesday, July 30, 2019 (Second Demo)
- Professor: Nathaly Verwaal
- Source code name: Menu.Java
********************************************************************************/

import java.awt.Font;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;





public class Menu extends Application {
	
	int height = 500;
	int width = 750;
	Button button;
	
	

	@Override
	public void start(Stage primaryStage2) {

/**********************************************************************
Function name: start
Parameter list: primaryStage2
Purpose: this function has the menu, there two buttoms, one buttom for that
	runs the game, and the second buttom that has the leader board.
************************************************************************/
		
		//sets title of window
		primaryStage2.setTitle("DR.Octavious");
		
		// create new stackpane
		StackPane layout = new StackPane();
		
		//makes a "play" button
		button = new Button();
		button.setText("Play");
		button.setMinSize(100, 40);
		button.setStyle("-fx-background-color: crimson; -fx-font-size: 2em;");
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				System.out.println("test");;
				
			}
		});
				
		
		// makes a "leaderboard" button
		Button button2 = new Button();
		button2.setText("Leaderboard");
		button2.setMaxSize(150, 40);
		button2.setTranslateX(-23);
		button2.setStyle("-fx-background-color: Crimson; -fx-font-size: 2em;");
		
		// places both buttons in a vertical box and puts them in the middle of the window
		VBox vbox = new VBox(30);
		vbox.setTranslateX((width/2)-50);
		vbox.setTranslateY((height/2)-50);
		vbox.getChildren().addAll(button, button2);
		
		//sets the clouds.jpg image to the background
		Image clouds = new Image("clouds.jpg");
		ImageView iv = new ImageView();
		iv.setImage(clouds);
		iv.setFitHeight(height);
		iv.setFitWidth(width);
		
		//adds the image and vbox(which has buttons) into the main layout
		layout.getChildren().add(iv);
		layout.getChildren().add(vbox);
		
		
		// sets everything in a new window and displays it for the user
		Scene scene = new Scene(layout, width, height);
		primaryStage2.setScene(scene);
		primaryStage2.show();
		
		
	
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
	
	
	
	

	
