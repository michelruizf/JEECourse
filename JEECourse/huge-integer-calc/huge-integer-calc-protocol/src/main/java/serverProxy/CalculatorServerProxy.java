package serverProxy;

import java.net.Socket;
import java.rmi.RemoteException;

import calculator.Calculator;

public class CalculatorServerProxy implements Calculator {
	
	private Calculator calculator;
	private Socket serverSocket;

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public Socket getSocket() {
		return serverSocket;
	}

	public CalculatorServerProxy(Socket socket, Calculator calculator) {
		this.calculator = calculator;
		this.serverSocket = socket;
	}

	public String add(String left, String right) throws RemoteException {
		return calculator.add(left, right);
	}

	public String subtract(String left, String right) throws RemoteException {
		return calculator.subtract(left, right);
	}

	public int compare(String left, String right) throws RemoteException {
		return calculator.compare(left, right);
	}

}
