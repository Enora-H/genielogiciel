package genielogiciel;

import java.util.List;
import java.util.Stack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class CalculatorGUI implements CalculatorGUIInterface {
	public Stage primaryStage;
	public Scene scene;
	
	public CalculatorGUI(Stage primaryStage) {		
		this.primaryStage = primaryStage;
		
		Button button1 = new Button();
		button1.setText("Test");
		
		Button button2 = new Button();
		button2.setText("2");
		
        StackPane layout = new StackPane();           
        layout.getChildren().addAll(button1, button2);
        scene = new Scene(layout, 300, 250);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
	}
	
	
	@Override
	public void affiche() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double change(String accu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Stack<Double> change(List<Double> stackData) {
		// TODO Auto-generated method stub
		return null;
	}

}
