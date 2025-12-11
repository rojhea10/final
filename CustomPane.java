package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class CustomPane extends StackPane {

        //Constructor for gridpane
	public CustomPane(GridPane gridPane) {
		
        getChildren().add(gridPane); // Example content
        setPadding(new Insets(11.5, 12.5, 13.5, 14.5)); // Example padding
	}

        //Constructor for hbox
	public CustomPane(HBox hbox) {
		
		getChildren().add(hbox);
		setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
	}
}