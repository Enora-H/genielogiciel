package genielogiciel;
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
	public double accu;
	public Stack<Double> pile;

	
	public double getAccu() {
		return accu;
	}

	public void setAccu(double accu) {
		this.accu = accu;
	}

	public Stack<Double> getPile() {
		return pile;
	}

	public void setPile(Stack<Double> pile) {
		this.pile = pile;
	}

	@Override
	public double add(double a, double b) { // méthode qui additionne deux nombres
		double somme = a+b;
		return somme;
	}

	@Override
	public double substract(double a, double b) { // méthode qui fait la différence de deux nombres : le deuxième nombre est soustrait au premier
		double difference = a-b;
		return difference;
	}

	@Override
	public double multiply(double a, double b) { // méthode qui multiplie deux nombres
		double produit = a*b;
		return produit;
	}

	@Override
	public double divide(double a, double b) { // méthode qui divise deux nombres : le deuxième nombre divise le premier
		double quotient = a/b;
		return quotient;
	}

	@Override
	public double opposite(double a) { // méthode qui oppose un nombre (le multiplie par -1)
		double oppose = -1*a;
		return oppose;
	}

	@Override
	public void push() { // méthode qui empile le contenu de l’accumulateur sur la pile
		pile.push(accu);	
	}

	@Override
	public Double pop() { // méthode qui récupère le dernier opérande placé sur la pile
		return pile.pop();	
	}

	@Override
	public void drop() { // méthode qui élimine le dernier opérande placé sur la pile
		pile.pop();
		
	}

	@Override
	public void swap() { // méthode qui échange l’ordre des deux derniers opérandes
		double a = pile.pop();
		double b = pile.pop();
		pile.push(a);
		pile.push(b);		
	}

	@Override
	public void clear() { // méthode qui vide le contenu de l’accumulateur accu
		while (!pile.empty()){
			pile.pop();
		}	
	}
}
