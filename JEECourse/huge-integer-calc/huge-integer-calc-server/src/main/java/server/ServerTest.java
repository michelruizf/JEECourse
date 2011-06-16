package server;

import calculator.Calculator;
import calculator.impl.CalculatorFactory;


public class ServerTest {
	
	public static void main(String[] args) {
		Calculator calc = CalculatorFactory.newCalculator();
		int port = 1001;
		String hostname = "localhost";
		CalculatorService.init(calc, port, hostname);
	}

}
