package genielogiciel;

import java.util.List;
import java.util.Stack;

// Interface implémentée par le controler.

public interface CalculatorControlerInterface {
	
	public double change(String accu);
	public Stack<Double> change(List<Double> stackData);
}
