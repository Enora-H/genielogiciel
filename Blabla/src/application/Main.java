package application;
	
import genielogiciel.CalculatorControler;
import genielogiciel.CalculatorGUI;
import genielogiciel.CalculatorModel;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {


	/**
     * Méthode qui configure et affiche l'interface utilisateur
     *
     * @param primaryStage Fenêtre principale qui permet la communication avec l'utilisateur.
     */
    @Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,450,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				
	        CalculatorModel model = new CalculatorModel();
	        CalculatorGUI view = new CalculatorGUI(primaryStage);
	        //CalculatorControler controller = new CalculatorControler(model, view);
	        //view.addController(controller);
	        
	        primaryStage.setTitle("Calculatricky");

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * Méthode main
     *
     * @param args Tableau présent par convention pour respecter la signature de main.
     */
	public static void main(String[] args) {
		launch(args);
	}
}
