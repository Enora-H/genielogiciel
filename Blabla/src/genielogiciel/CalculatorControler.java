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
     *Méthode qui permet d'effectuer une opération selon l'opérateur entré sur un bouton
     *d'ailleurs faut voir le lien avec ça!!!!!!!
     *
     * @param operation String qui détermine quel type d'opération est à appliquer
     */
	private double faireOperation(String operation) { // pas encore sûre (on retourne le resultat ou pas?)
	    List<Double> liste = view.getStackData(); // implémenter le getter dans la vue!!!!!
	    model.setPile(change(liste));
	    double a = model.pop(); // on prend le dernier élément de la pile
	    double b = 0.0; // on initialise b à zéro pour ne pas perdre une information de la pile au cas où on ne l'utilise pas

	    if (!"opposer".equals(operation)) { // cas où on n'oppose pas : on initialise b à la bonne valeur
	        b = model.pop();
	    }

	    double resultat = 0.0; // on initialise le résultat 

	 // chacun des cinq cas d'opérations : addition, soustraction, multiplication, division et opposition
	    switch (operation) {
	    case "additionner":
	    resultat = model.add(a, b);
	    break;
	    case "soustraire":
	    resultat = model.substract(a, b);
	    break;
	    case "multiplier":
	    resultat = model.multiply(a, b);
	    break;
	    case "diviser":
	    if (b == 0.0) {
	    // Ajouter de la gestion des erreurs : division par zéro. Faire afficher sur l'interface : gérer dans view.
	    } else {
	    resultat = model.divide(a, b);
	    }
	    break;
	    case "opposer":
	    resultat = model.opposite(a);
	    break;
	    default:
	    // Handle unknown operation error
	    // Ajouter de la gestion d'erreurs : cas où l'opérateur est inconnu
	    break;
	    }
	    
	    model.push(resultat); // on pousse l'accumulateur en haut de la pileS
	    return resultat;
	}

	
}
