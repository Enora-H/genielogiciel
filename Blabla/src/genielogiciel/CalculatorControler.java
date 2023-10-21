package genielogiciel;

import java.util.List;
import java.util.Stack;

// Cette classe est celle qui fait le lien entre la partie view et la partie model.
// Elle permet la communication des entrées utilisateurs au model, et la communication des calculs du model à
// l'utilisateur via view. 

public class CalculatorControler implements CalculatorControlerInterface {
	
	/**
     * Méthode qui convertit l'accumulateur entré comme chaîne de caractères en un double lisible
     * par le model.
     *
     * @param accu  String à convertir
     */
	@Override
	public double change(String accu) {
		double convertedAccu = Double.parseDouble(accu);
		return convertedAccu;
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

}
