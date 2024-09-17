 package View;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Button1 extends Button {
	 public Button1()
	 {
		 super();
		 this.setFont(Font.font("Broadway",FontWeight.BOLD,20));
		 this.setStyle("-fx-text-fill: GREEN");
		this.setBackground(new Background(new BackgroundFill(Color.color(1.00,0.97,0.80), CornerRadii.EMPTY, null)));
	 }
	 public Button1(String name)
	 {
		 super(name);
		 this.setStyle("-fx-text-fill: GREEN");

		 this.setFont(Font.font("Broadway",FontWeight.BOLD,20));
			this.setBackground(new Background(new BackgroundFill(Color.color(1.00,0.97,0.80), CornerRadii.EMPTY, null)));

	 //Lobster Ravie
	 }

}
