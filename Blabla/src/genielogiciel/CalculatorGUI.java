package genielogiciel;

import java.util.ArrayList;
import javafx.scene.text.Text;
import java.util.List;
import java.util.Stack;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class CalculatorGUI implements CalculatorGUIInterface {
	public Stage primaryStage;
	public Scene scene;
	private List<String> inputs;
	private ArrayList<Button> boutons = new ArrayList<Button>();
	private CalculatorControler controller; 
	private String nombre;
    private Text display0;
    private Text display1;
    private Text display2;
    private Text display3;
	
	public List<String> getInputs() {
		return inputs;
	}


	public void setInputs(List<String> inputs) {
		this.inputs = inputs;
	}


	public CalculatorGUI(Stage primaryStage) {		
		this.primaryStage = primaryStage;
		inputs = new ArrayList<String>();
		nombre = "";
	    display0 = new Text("");
	    display1 = new Text("");
	    display2 = new Text("");
	    display3 = new Text("");
		
		// creation grille boutons chiffres
		
		for (int i = 1; i<10; i++) {
			Button btn = Bouton.createBoutonChiffre(String.valueOf(i), this);			
			boutons.add(btn);
		}
		
		Button btn0 = Bouton.createBoutonChiffre("0", this);
		boutons.add(btn0);
		
		Button btn_virgule = Bouton.createBoutonChiffre(".", this);
		boutons.add(btn_virgule);

		
		Button btn_signe = Bouton.createBoutonAutre("+/-", this);	
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
        
        Button btn_somme = Bouton.createBoutonOperation("+", this);
        
        Button btn_difference = Bouton.createBoutonOperation("-", this);
        
        Button btn_produit = Bouton.createBoutonOperation("*", this);
        
        Button btn_quotient = Bouton.createBoutonOperation("/", this);
		
        Button btn_enter = Bouton.createBoutonAutre("<>",this);
		
        Button btn_effacer = Bouton.createBoutonAutre("Effacer", this);
        
        
        VBox layout_operations = new VBox();
        layout_operations.getChildren().addAll(btn_effacer, btn_somme, btn_difference, btn_produit, btn_quotient, btn_enter);
        
        
        // Conception affichage calculs
        
        
        VBox layout_affichage = new VBox();
        
        HBox hdisplay0 = createDisplayHBox(display0);
        HBox hdisplay1 = createDisplayHBox(display1);
        HBox hdisplay2 = createDisplayHBox(display2);
        HBox hdisplay3 = createDisplayHBox(display3);
        
        layout_affichage.getChildren().addAll(hdisplay3, hdisplay2, hdisplay1, hdisplay0);
        
        
        // Grille finale
        
        BorderPane layout = new BorderPane();
        layout.setTop(layout_affichage);
        layout.setLeft(layout_chiffres);
        layout.setRight(layout_operations);
        
        layout.setMargin(layout_chiffres, new Insets(5, 0, 20, 20)); // insets : haut, droite, bas, gauche
        layout.setMargin(layout_operations, new Insets(0, 20, 20, 0));
        layout.setMargin(layout_affichage, new Insets(20, 20, 20, 20));
        
        scene = new Scene(layout);
        
        primaryStage.setOnCloseRequest(e -> {
            e.consume(); // Empêche la fermeture automatique de la fenêtre
            primaryStage.close(); // Ferme la fenêtre manuellement
        });
        
        primaryStage.setScene(scene);
        primaryStage.setHeight(450);
        primaryStage.setWidth(300);
        primaryStage.setResizable(false);
        primaryStage.show();
        
	}
	
	
	@Override
	public void affiche() {
	    display0.setText(nombre);
	    
	    for (int i = 1; i <= 3; i++) {
	        if (inputs.size() >= i) {
	            setDisplay(i, inputs.get(inputs.size() - i));
	        } else {
	            setDisplay(i, "");
	        }
	    }
	}

	// Méthode utilitaire pour mettre à jour les labels display1, display2, display3
	private void setDisplay(int displayNumber, String value) {
	    switch (displayNumber) {
	        case 1:
	            display1.setText(value);
	            break;
	        case 2:
	            display2.setText(value);
	            break;
	        case 3:
	            display3.setText(value);
	            break;
	        default:
	            break;
	    }
	}

	public void boutonChiffreEvent(String chiffre) {
		nombre += chiffre;
		affiche();
	}
		

	public void boutonOperationEvent(String operande) {
		try {
			controller.faireOperation(operande);
			affiche();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void boutonAutreEvent(String instruction) {
		switch(instruction){
		case "Effacer":
			if (!nombre.isEmpty()) {
				nombre = nombre.substring(0, nombre.length()-1); 
			}
			else {
				if (!inputs.isEmpty()) {
					nombre = inputs.get(inputs.size()-1);
					inputs.remove(inputs.size()-1);
				}
			}
			affiche();
		break;
		case "+/-":
			if (nombre.isEmpty() || nombre.charAt(0) != '-') {
				nombre = "-" + nombre;
			}
			else {
				nombre = nombre.substring(1);
			}
			affiche();
		break;	
			
		case "<>" : 
			if (!nombre.isEmpty()) {
				inputs.add(nombre);
				nombre = "";
				affiche();
			}
		break;	
		}
	}
	
	
	
    private HBox createDisplayHBox(Text display) {
        HBox displayBox = new HBox();
        displayBox.setPrefSize(260, 40);
        Pane espace = new Pane();
        espace.setPrefSize(250,  40);
        displayBox.getChildren().addAll(espace, display);        
        displayBox.setStyle("-fx-border-color: grey; -fx-border-width: 2px; -fx-background-color: lightgrey; -fx-font-family: \"System\";-fx-font-size: 14px;");
        return displayBox;
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
	
}
