package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import calculator.Calculator;
import calculator.impl.CalculatorFactory;

public class Console {
	
//	static Calculator calculator = CalculatorFactory.newCalculator();
//	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
//	
//	public static void main(String[] args) {
//		
//		try {	
//		    String left = userInputFor("Type the first huge integer: "); 		     
//		    String right = userInputFor("Type the second huge integer: ");		    
//		    char option = userInputFor("Choose the operation you want to run (0 - add | 1 - subtract | 2 - compare): ").charAt(0);
//		    String result = makeTheOperation(left, right, option);
//		    System.out.println(String.format("The result is %s .", result));
//		} catch (IOException e) {
//			System.out.println("Erro: " + e.getMessage());
//		}
//	}
//
//	private static String makeTheOperation(String left, String right,
//			char option) {
//		String result = new String();
//		switch (option) {
//		case '0':
//			result = calculator.add(left, right);
//			break;
//		case '1':
//			result = calculator.subtract(left, right);
//			break;
//		case '2':
//			result = String.valueOf(calculator.compare(left, right));
//			break;
//		default:
//			result = "Sorry ... but an error occurred. Try Again";
//			break;
//		}
//		return result;
//	}
//
//	private static String userInputFor(String message) throws IOException {
//		System.out.print(message);  
//		String left = in.readLine();
//		return left;
//	}
}
