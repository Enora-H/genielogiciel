package genielogiciel;
import java.util.Stack;

// Cette classe est le model de la calculatrice. Elle permet le calcul effectif en utilisant la notation
// polonaise inversée.

public class CalculatorModel implements CalculatorModelInterface {
	
	public double accu; // représente l'accumulateur où les résultats intermédiaires et final sont stockés.
	public Stack<Double> pile; // représente la pile où sont stockés les nombres avant qu'on leur applique
								// un opérateur.

	/**
     * Getter de l'accumulateur
     */
	public double getAccu() {
		return accu;
	}
	
	/**
     * Setter de l'accumulateur
     */
	public void setAccu(double accu) {
		this.accu = accu;
	}

	/**
     * Getter de la pile
     */
	public Stack<Double> getPile() {
		return pile;
	}
	
	/**
     * Setter de la pile
     */
	public void setPile(Stack<Double> pile) {
		this.pile = pile;
	}
	
	/**
     * Méthode qui additionne deux nombres de type double et retourne le résultat.
     *
     * @param a  premier double à additionner
     * @param b deuxième double à additionner
     */
	@Override
	public double add(double a, double b) { 
		double somme = a+b;
		return somme;
	}

	/**
     * Méthode qui fait la différence deux nombres de type double et retourne le résultat.
     *
     * @param a double auquel un soustrait un autre
     * @param b double à soustraire
     */
	@Override
	public double substract(double a, double b) {
		double difference = a-b;
		return difference;
	}

	/**
     * Méthode qui multiplie deux nombres de type double et retourne le résultat.
     *
     * @param a premier double à multiplier
     * @param b deuxième double à multiplier avec le premier
     */
	@Override
	public double multiply(double a, double b) { 
		double produit = a*b;
		return produit;
	}

	/**
     * Méthode qui calcule le quotient deux nombres de type double et retourne le résultat.
     *
     * @param a double qui est le numérateur
     * @param b double qui est le dénominateur
     */
	@Override
	public double divide(double a, double b) { 
		double quotient = a/b;
		return quotient;
	}

	/**
     * Méthode qui oppose un nombre de type double et retourne le résultat.
     *
     * @param a double à opposer
     */
	@Override
	public double opposite(double a) { 
		double oppose = -1*a;
		return oppose;
	}

	/**
     * Méthode qui empile le contenu de l'accumulateur sur la pile
     */
	@Override
	public void push() { 
		pile.push(accu);	
	}

	/**
     * Méthode qui récupère le dernier opérande placé sur la pile
     */
	@Override
	public Double pop() { 
		return pile.pop();	
	}

	/**
     * Méthode qui élimine le dernier opérande placé sur la pile
     */
	@Override
	public void drop() { 
		pile.pop();
		
	}

	/**
     * Méthode qui échange les deux derniers opérandes de la pile
     */
	@Override
	public void swap() {
		double a = pile.pop();
		double b = pile.pop();
		pile.push(a);
		pile.push(b);		
	}

	/**
     * Méthode qui vide entièrement le contenu de la pile
     */
	@Override
	public void clear() { 
		while (!pile.empty()){
			pile.pop();
		}	
	}
}
