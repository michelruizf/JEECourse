package calculator.impl;

import calculator.Calculator;

public class CalculatorFactory {

	public static Calculator newCalculator() {
		return new CalculatorImpl();
	}

}
