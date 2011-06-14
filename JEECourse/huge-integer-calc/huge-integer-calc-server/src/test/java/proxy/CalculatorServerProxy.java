package proxy;

import calculator.Calculator;
import calculator.impl.CalculatorFactory;

public class CalculatorServerProxy implements Calculator {

	public String add(String left, String right) {
		return CalculatorFactory.newCalculator().add(left, right);
	}

	public String subtract(String left, String right) {
		return CalculatorFactory.newCalculator().subtract(left, right);
	}

	public int compare(String left, String right) {
		return CalculatorFactory.newCalculator().compare(left, right);
	}

}
