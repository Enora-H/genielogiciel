package genielogiciel;

import java.util.ArrayList;
import javafx.scene.text.Text;
import java.util.List;
import java.util.Stack;

import javafx.application.Application;
import javafx.event.EventHandler;
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
	public String inputs; // faire une liste strings, mettre en private avec un getter
	private ArrayList<Button> boutons = new ArrayList<Button>();
	private CalculatorControler controller; 
	private Text accu_display;
	private Text result_display;
	
	public CalculatorGUI(Stage primaryStage) {		
		this.primaryStage = primaryStage;
		
		
		// creation grille boutons chiffres
		
		for (int i = 1; i<10; i++) {
			Button btn = new Button(String.valueOf(i));
			btn.setOnAction((event) -> {
				  inputs += String.valueOf(btn.getText());
				  controller.update(String.valueOf(btn.getText()));
				});				
			boutons.add(btn);
		}
		
		Button btn0 = new Button();
		btn0.setText("0");
		btn0.setOnAction((event) -> {
			  inputs += "0";
			});		
		boutons.add(btn0);
		
		Button btn_virgule = new Button();
		btn_virgule.setText(",");
		btn_virgule.setOnAction((event) -> {
			  inputs += ",";
			});	
		boutons.add(btn_virgule);

		
		Button btn_signe = new Button();
		btn_signe.setText("+/-");
		btn_signe.setOnAction((event) -> {
			  inputs += "+/-";
			});	
		boutons.add(btn_signe);
		
		
		// Conception grille chiffres
		
        GridPane layout_chiffres = new GridPane();           
        
        layout_chiffres.add(boutons.get(0), 0, 0);
        layout_chiffres.add(boutons.get(1), 1, 0);
        layout_chiffres.add(boutons.get(2), 2, 0);
        layout_chiffres.add(boutons.get(3), 0, 1);
        layout_chiffres.add(boutons.get(4), 1, 1);
        layout_chiffres.add(boutons.get(5), 2, 1);
        layout_chiffres.add(boutons.get(6), 0, 2);
        layout_chiffres.add(boutons.get(7), 1, 2);      
        layout_chiffres.add(boutons.get(8), 2, 2);
        layout_chiffres.add(btn_virgule, 0, 3);
        layout_chiffres.add(btn0, 1, 3);
        layout_chiffres.add(btn_signe, 2, 3);
        
        
        // Conception Operations
        
        Button btn_somme = new Button("+");
		btn_somme.setOnAction((event) -> {
			  inputs += "+";
			});	
        
        Button btn_difference = new Button("-");
		btn_difference.setOnAction((event) -> {
			  inputs += "-";
			});	
        
        Button btn_produit = new Button("*");
		btn_produit.setOnAction((event) -> {
			  inputs += "*";
			});	
        
        Button btn_quotient = new Button("/");
		btn_quotient.setOnAction((event) -> {
			  inputs += "/";
			});	
        Button btn_enter = new Button("<>");
		btn_enter.setOnAction((event) -> {
			  inputs += "e";
			});	
        
        
        VBox layout_operations = new VBox();
        layout_operations.getChildren().addAll(btn_somme, btn_difference, btn_produit, btn_quotient, btn_enter);
        
        
        // Conception affichage calculs
        
        accu_display = new Text("accu");
        result_display = new Text("resultat");
        
        VBox layout_affichage = new VBox();
        
        layout_affichage.getChildren().addAll(accu_display, result_display);
        
        
        
        // Grille finale
        
        GridPane layout = new GridPane();
        layout.add(layout_affichage, 0, 0);
        layout.add(layout_chiffres, 0, 1);
        layout.add(layout_operations, 1, 1);
        
        
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
	
	public void addController(CalculatorControler controller) {
		this.controller = controller;
	}
	
	
	
	
	public void update(String resultat, String accu){
		accu_display.setText(accu);
		result_display.setText(resultat);
	}

}
