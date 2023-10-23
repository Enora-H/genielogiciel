package genielogiciel;

import java.util.List;
import java.util.Stack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class CalculatorGUI implements CalculatorGUIInterface {
	public Stage primaryStage;
	public Scene scene;
	
	public CalculatorGUI(Stage primaryStage) {		
		this.primaryStage = primaryStage;
		
		
		
		
		
		// Creation boutons de la grille chiffres
		Button btn1 = new Button();
		btn1.setText("1");
		
		Button btn2 = new Button();
		btn2.setText("2");
		
		Button btn3 = new Button();
		btn3.setText("3");
		
		Button btn4 = new Button();
		btn4.setText("4");
		
		Button btn5 = new Button();
		btn5.setText("5");
		
		Button btn6 = new Button();
		btn6.setText("6");
		
		Button btn7 = new Button();
		btn7.setText("7");
		
		Button btn8 = new Button();
		btn8.setText("8");
		
		Button btn9 = new Button();
		btn9.setText("9");
		
		Button btn0 = new Button();
		btn0.setText("0");
		
		Button btn_virgule = new Button();
		btn_virgule.setText(",");
		
		Button btn_signe = new Button();
		btn_signe.setText("+/-");
		
		
		// Conception grille chiffres
		
        GridPane layout_chiffres = new GridPane();           
        
        layout_chiffres.add(btn1, 0, 0);
        layout_chiffres.add(btn2, 1, 0);
        layout_chiffres.add(btn3, 2, 0);
        layout_chiffres.add(btn4, 0, 1);
        layout_chiffres.add(btn5, 1, 1);
        layout_chiffres.add(btn6, 2, 1);
        layout_chiffres.add(btn7, 0, 2);
        layout_chiffres.add(btn8, 1, 2);      
        layout_chiffres.add(btn9, 2, 2);
        layout_chiffres.add(btn_virgule, 0, 3);
        layout_chiffres.add(btn0, 1, 3);
        layout_chiffres.add(btn_signe, 2, 3);
        
        
        // Conception Operations
        
        Button btn_somme = new Button();
        btn_somme.setText("+");
        
        Button btn_difference = new Button();
        btn_difference.setText("-");
        
        Button btn_produit = new Button();
        btn_produit.setText("*");
        
        Button btn_quotient = new Button();
        btn_quotient.setText("/");
        
        Button btn_jsp = new Button(); // pas compris ce que ca faisait
        btn_jsp.setText("< >");
        
        
        VBox layout_operations = new VBox();
        layout_operations.getChildren().addAll(btn_somme, btn_difference, btn_produit, btn_quotient, btn_jsp);
        
        
        
        // Grille finale
        
        GridPane layout = new GridPane();
        layout.add(layout_chiffres, 0, 0);
        layout.add(layout_operations, 1, 0);
        
        
        scene = new Scene(layout, 300, 250);
        
        
        primaryStage.setScene(scene);
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
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
