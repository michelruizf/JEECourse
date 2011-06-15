package factory;

import proxy.CalculatorServerProxy;
import calculator.Calculator;

public class CalculatorServerFactory {

	public static Calculator newCalculator(){
		return new CalculatorServerProxy();		
	}
}
