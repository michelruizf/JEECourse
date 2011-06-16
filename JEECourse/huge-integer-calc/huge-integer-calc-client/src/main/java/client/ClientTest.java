package client;

import services.ServiceLocator;
import calculator.Calculator;

public class ClientTest {

	public static void main(String[] args) {
		try {
			System.out.println("Initializing the fucking Client\n");
			System.out.println("Looking for a service to the calculator...\n");
			Calculator calculator = ServiceLocator.getService(Calculator.class);
			System.out.println("Service calculator found ...\n");
			System.out.println("Performing an operation..\n");
			String result = calculator.add("2", "1");
			System.out.println("Result of operation " + result);
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}

	}

}
