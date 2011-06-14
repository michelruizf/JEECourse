package factory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import proxy.CalculatorClientProxy;
import calculator.Calculator;

public class CalculatorClientFactory {

	public static Calculator newCalculator() throws UnknownHostException, IOException{
		return new CalculatorClientProxy(new Socket(InetAddress.getLocalHost(), 1000));		
	}

}
