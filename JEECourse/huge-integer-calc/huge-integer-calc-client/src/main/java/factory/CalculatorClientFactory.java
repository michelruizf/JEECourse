package factory;

import java.io.IOException;
import java.net.UnknownHostException;

import services.ServiceLocator;
import calculator.Calculator;

public class CalculatorClientFactory {

	public static Calculator newCalculator() throws UnknownHostException, IOException{
		return ServiceLocator.getService(Calculator.class);		
	}

}
