package View;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameWinWindow {
	public static boolean answer;
	public static void display(String title, String message)
	{
		Stage window=new Stage();
		window.initModality(Modality.WINDOW_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		window.setMinHeight(500);
		Label l=new Label(message);
		Button tryagain = new Button ("Yes ! Let's Go !");
		Button giveup = new Button ("Exit");
		
		tryagain.setOnAction(e -> {
			answer = true;
			window.close();
			
		});
		giveup.setOnAction(e -> {
			answer = false;
			window.close();
			
		});
		
		
		HBox layout = new HBox(30);
		//layout.setStyle("-fx-bckground-color: blue");
		layout.getChildren().addAll(tryagain, giveup);
		layout.setAlignment(Pos.CENTER);
		
		
		VBox lay=new VBox(30);
		lay.getChildren().addAll(l,layout);
		Scene s=new Scene(lay,600,100);
		//window.getIcons().add(new Image("redbutton0.png"));
		window.setScene(s);
		window.showAndWait();
	}

}
