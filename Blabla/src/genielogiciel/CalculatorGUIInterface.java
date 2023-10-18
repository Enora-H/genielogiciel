package genielogiciel;

import java.util.List;
import java.util.Stack;

public interface CalculatorGUIInterface {
	public void affiche();
	public double change(String accu);
	public Stack<Double> change(List<Double> stackData);

}
