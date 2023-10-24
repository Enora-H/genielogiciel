package genielogiciel;

import java.util.List;
import java.util.Stack;

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
	 * Méthode qui convertit une liste de chaînes de caractères en une pile de double lisible par le model.
	 *
	 * @param inputs Liste de chaînes de caractères à convertir
	 */
	public Stack<Double> changeStr(List<String> inputs) {
	    Stack<Double> pile = new Stack<Double>();
	    
	    for (String input : inputs) {
	        double convertedValue = change(input);
	        pile.push(convertedValue);
	    }
	    
	    return pile;
	}

	/**
     *Méthode qui permet d'effectuer une opération selon l'opérateur entré sur un bouton
     *
     * @param operation String qui détermine quel type d'opération est à appliquer
     */
	private List<String> faireOperation(String operation) throws CustomException {
	    List<String> liste = vue.getStackData(); // implémenter le getter dans la vue!!!!!
	    model.setPile(changeStr(liste)); // implémenter le setter dans la vue !!!!!
	    double a = model.pop(); // on prend le dernier élément de la pile
	    double b = 0.0; // on initialise b à zéro pour ne pas perdre une information de la pile au cas où on ne l'utilise pas

	    liste.remove(liste.size() - 1); // on retire le dernier élément de la liste de String pour plus tard le remplacer par le résultat de l'opération
	    
	    if (!"+/-".equals(operation)) { // cas où on n'oppose pas : on vérifie s'il y a assez d'opérandes et on initialise b à la bonne valeur
	    	if (model.getPile().isEmpty()) {
                throw new CustomException("Pas assez d'opérandes sur la pile"); // il faut ajouter des "try-catch" dans la vue
            }
	    	b = model.pop();
	    	liste.remove(liste.size() - 1); // dans le cas où l'opération n'est pas une opposition, on retire les deux dernières opérandes de la liste de String
	    }

	    double resultat = 0.0; // on initialise le résultat 

	 // chacun des cinq cas d'opérations : addition, soustraction, multiplication, division et opposition
	    switch (operation) {
	    case "+":
	    resultat = model.add(a, b);
	    break;
	    case "-":
	    resultat = model.substract(a, b);
	    break;
	    case "*":
	    resultat = model.multiply(a, b);
	    break;
	    case "/":
	    if (b == 0.0) {
	    	throw new CustomException("Division par zéro impossible"); // il faut ajouter des "try-catch" dans la vue
	    } else {
	    resultat = model.divide(a, b);
	    }
	    break;
	    case "+/-":
	    resultat = model.opposite(a);
	    break;
	    default:
	    	throw new CustomException("Opérateur inconnu"); // il faut ajouter des "try-catch" dans la vue
	    break;
	    }
	    
	    model.push(resultat); // on pousse l'accumulateur en haut de la pile
	    String resultatString = Double.toHexString(resultat);
	    liste.add(resultatString);
	    return liste; // on retourne la liste de chaînes de caractères après calcul
	}

	
}
