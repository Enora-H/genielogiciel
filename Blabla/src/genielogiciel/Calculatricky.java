package genielogiciel;

import javafx.application.Application;
import javafx.stage.Stage;

// important : faire la gestion des erreurs !!!!!!!
// 1. erreur si on entre pas un string convertible en nombre dans la liste
// 2. erreur si on entre un opérateur qui n'en est pas un 
// 3. autre type d'erreur ? réfléchir

public class Calculatricky extends Application {
	
	/**
     * Méthode main
     *
     * @param args Tableau présent par convention pour respecter la signature de main.
     */
	public static void main(String[] args) {
        launch(args);
    }
	
	/**
     * Méthode qui configure et affiche l'interface utilisateur
     *
     * @param primaryStage Fenêtre principale qui permet la communication avec l'utilisateur.
     */
    @Override
    public void start(Stage primaryStage) {
        CalculatorModel model = new CalculatorModel();
        CalculatorGUI view = new CalculatorGUI();
        CalculatorControler controller = new CalculatorControler(model, view);

        primaryStage.setTitle("Calculatricky");
        primaryStage.setScene(new Scene(/* interface utilisateur ici */));
        primaryStage.show();
    }
}
