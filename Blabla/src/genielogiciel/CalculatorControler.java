package genielogiciel;

import java.util.List;
import java.util.Stack;

public class CalculatorControler implements CalculatorControlerInterface {
	
	@Override
	public double change(String accu) {
		double convertedAccu = Double.parseDouble(accu);
		return convertedAccu;
	}

	@Override
	public Stack<Double> change(List<Double> stackData) {
		Stack<Double> pile = new Stack<Double>;
		pile.addAll(stackData);
		return pile;
	}

}
