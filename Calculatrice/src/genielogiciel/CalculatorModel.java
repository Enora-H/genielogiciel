package genielogiciel;
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
	public double accu;

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
	public void push() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swap() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}
