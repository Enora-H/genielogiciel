package genielogiciel;

public interface CalculatorModelInterface {
	public double add(double a, double b);
	public double substract(double a, double b);
	public double multiply(double a, double b);
	public double divide(double a, double b);
	public double opposite(double a);
	public void push();
	public void pop();
	public void drop();
	public void swap();
	public void clear();

}
