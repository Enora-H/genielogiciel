package genielogiciel;

import java.util.List;
import java.util.Stack;

// Remarque importante : les méthodes addition(), soustraction(), multiplication() et division() se ressemblent
// énormément : il serait judicieux d'implémenter une méthode qui reprend ce qui est similaire dans celles ci
// c'est mieux

// Cette classe est celle qui fait le lien entre la partie view et la partie model.
// Elle permet la communication des entrées utilisateurs au model, et la communication des calculs du model à
// l'utilisateur via view. 

public class CalculatorControler implements CalculatorControlerInterface {
	
	private CalculatorModel model; //
	private CalculatorGUI vue; //
	
	/**
     * Méthode qui convertit l'accumulateur entré comme chaîne de caractères en un double lisible
     * par le model.
     *
     * @param accu  String à convertir
     */
	@Override
	public double change(String accu) {
		return Double.parseDouble(accu);
	}
	
	/**
     * Méthode qui convertit une liste de double en une pile de double lisible par le model.
     *
     * @param stackData  List<Double> à convertir
     */
	@Override
	public Stack<Double> change(List<Double> stackData) {
		Stack<Double> pile = new Stack<Double>();
		pile.addAll(stackData);
		return pile;
	}
	
	/**
     * Méthode qui permet l'addition : elle convertit les données entrées dans la vue, les additionne
     * à l'aide du modèle puis affiche le résultat
     */
	public void additionner() { // pas encore sûre de ça
		 
		List<Double> liste = view.getStackData(); // écrire la méthode getStackData dans CalculatorGUI !!!!! 
		model.setPile(change(liste));
	    double a = model.pop();  
	    double b = model.pop();
	    double addition = model.add(a,b);
	    model.push(); // on pousse l'accumulateur sur la pile après le calcul
	    view.setResultText(Double.toString(addition));  // écrire la méthode setResultText dans la vue !!!!
	}
	
	/**
     * Méthode qui permet la soustraction : elle convertit les données entrées dans la vue, en fait la
     * différence à l'aide du modèle puis affiche le résultat
     */
	public void soustraire() { // pas encore sûre de ça non plus : vérifier l'ordre de la soustraction
		 
		List<Double> liste = view.getStackData();  
		model.setPile(change(liste));
	    double a = model.pop();  
	    double b = model.pop();
	    double difference = model.substract(a,b);
	    model.push(); 
	    view.setResultText(Double.toString(difference));  
	}
	
	/**
     * Méthode qui permet la multiplication : elle convertit les données entrées dans la vue, en fait le
     * produit à l'aide du modèle puis affiche le résultat
     */
	public void multiplier() { // pas encore sûre de ça non plus 
		 
		List<Double> liste = view.getStackData();  
		model.setPile(change(liste));
	    double a = model.pop();  
	    double b = model.pop();
	    double produit = model.multiply(a,b);
	    model.push(); 
	    view.setResultText(Double.toString(produit));  
	}
	
	/**
     * Méthode qui permet la division : elle convertit les données entrées dans la vue, en fait le
     * quotient à l'aide du modèle puis affiche le résultat
     */
	public void diviser() { // pas encore sûre de ça non plus 
		 
		List<Double> liste = view.getStackData();  
		model.setPile(change(liste));
	    double a = model.pop();  
	    double b = model.pop();
	    double quotient = model.divide(a,b);
	    model.push(); 
	    view.setResultText(Double.toString(quotient));  
	}
	
	/**
     * Méthode qui permet d'opposer un nombre : elle convertit la donnée entrée dans la vue, l'oppose
     * à l'aide du modèle puis affiche le résultat
     */
	public void opposer() { // pas encore sûre de ça non plus 
		 
		List<Double> liste = view.getStackData();  
		model.setPile(change(liste));
	    double a = model.pop();  
	    double opp = model.opposite(a);
	    model.push(); 
	    view.setResultText(Double.toString(opp));  
	}

}
