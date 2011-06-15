package client;

import calculator.Calculator;
import factory.CalculatorClientFactory;

public class ClientTest {

	public static void main(String[] args) {
		try {
			System.out.println("Initializing the fucking Client\n");
			Calculator newCalculator = CalculatorClientFactory.newCalculator();
			System.out.println("CalculatorClientFactory created\n");
			String addResult = newCalculator.add("1", "2");
			System.out.println("Added\n");
			System.out.println("Add Result: " + addResult);
			String subtractResult = newCalculator.add("1", "2");
			System.out.println("Subtracted\n");
			System.out.println("Subtracted Result: " + subtractResult);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
