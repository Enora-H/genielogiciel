package genielogiciel;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.util.ArrayList;
import javafx.event.EventHandler;

public class Bouton {
	private ArrayList<Button> boutons = new ArrayList<Button>();
	
		
	    public static Button createBoutonChiffre(String label, CalculatorGUI gui) {
	        Button btn = new Button(label);
			btn.setOnAction((event) -> {
				gui.boutonChiffreEvent(label);
				});
			btn.setPrefSize(50, 50);
			btn.setStyle("-fx-border-color: grey; -fx-border-width: 2px; -fx-background-color: lightgrey; -fx-font-family: \"System\";-fx-font-size: 14px;");
	        return btn;
	    }

	    public static Button createBoutonOperation(String label, CalculatorGUI gui) {
	        Button btn = new Button(label);
			btn.setOnAction((event) -> {
				gui.boutonOperationEvent(label);
				});
			btn.setPrefSize(70, 35);
			btn.setStyle("-fx-border-color: grey; -fx-border-width: 2px; -fx-background-color: lightgrey; -fx-font-family: \"System\";-fx-font-size: 14px;");
	        return btn;
	    }

	    public static Button createBoutonAutre(String label, CalculatorGUI gui) {
	        Button btn = new Button(label);
			btn.setOnAction((event) -> {
				gui.boutonAutreEvent(label);
				});
			if (label == "+/-") {
				btn.setPrefSize(50, 50);
				btn.setStyle("-fx-border-color: grey; -fx-border-width: 2px; -fx-background-color: lightgrey; -fx-font-family: \"System\";-fx-font-size: 14px;");
			}
			else {
				btn.setPrefSize(70, 35);
			}
			btn.setStyle("-fx-border-color: grey; -fx-border-width: 2px; -fx-background-color: lightgrey; -fx-font-family: \"System\";-fx-font-size: 12px;");
	        return btn;
	    }
	}

