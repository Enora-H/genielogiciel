package genielogiciel;
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
	public double accu;

	@Override
	public double add(double a, double b) {
		double somme = a+b;
		return somme;
	}

	@Override
	public double substract(double a, double b) {
		double difference = a-b;
		return difference;
	}

	@Override
	public double multiply(double a, double b) {
		double produit = a*b;
		return produit;
	}

	@Override
	public double divide(double a, double b) {
		double quotient = a/b;
		return quotient;
	}

	@Override
	public double opposite(double a) {
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
