package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import calculator.Calculator;
import calculator.impl.CalculatorFactory;
import calculator.impl.CalculatorFactoryInterface;


public class ClientTestRMI {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		CalculatorFactory.initialize();
		CalculatorFactoryInterface calcFactory = (CalculatorFactoryInterface) Naming.lookup("rmi://wsmga-ruiz/calculator");
		System.out.println(calcFactory);
		Calculator calc = calcFactory.newCalculator();
		System.out.println(calc);
		System.out.println("1 + 2 = " + calc.add("1", "2"));
	}
}
