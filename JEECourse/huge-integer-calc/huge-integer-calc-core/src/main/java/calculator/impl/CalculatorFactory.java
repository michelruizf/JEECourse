package calculator.impl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import calculator.Calculator;

public class CalculatorFactory extends UnicastRemoteObject implements CalculatorFactoryInterface {
	
	protected CalculatorFactory() throws RemoteException {}
	
	private static final long serialVersionUID = -4183876299578807846L;

	public Calculator newCalculator() throws RemoteException {
		return new CalculatorImpl();
	}
	
	public static void initialize(){
		
	}
	
	static{ 
		CalculatorFactory calculatorFactory;
		try {
			calculatorFactory = new CalculatorFactory();
			Naming.bind("calculator", calculatorFactory);
			System.out.println("Passei");
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}

}
