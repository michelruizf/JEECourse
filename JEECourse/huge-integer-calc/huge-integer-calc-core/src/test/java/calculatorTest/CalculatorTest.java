package calculatorTest;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import calculator.Calculator;
import calculator.impl.CalculatorFactory;

public class CalculatorTest {
	
	@Test
	public void addHugeIntegers() throws RemoteException{
		Calculator calculator = CalculatorFactory.newCalculator();
		String result = calculator.add("123456789012345", "9876543210");
		
		assertEquals("Result of added huge integers", "123466665555555", result);
	}
	
	@Test
	public void subtractHugeIntegers() throws RemoteException{
		Calculator calculator = CalculatorFactory.newCalculator();
		String result = calculator.subtract("123456789012345", "9876543210");
		
		assertEquals("Result of subtract huge integers", "123446912469135", result);
	}
	
	@Test
	public void subtractHugeIntegers2() throws RemoteException{
		Calculator calculator = CalculatorFactory.newCalculator();
		String result = calculator.subtract("9876543210", "123456789012345");
		
		//Aqui deveria estar com o sinal negativo
		assertEquals("Result of subtract huge integers with negative value", "-123446912469135", result);
	}
	
	@Test
	public void compareStringLeftLower() throws RemoteException{
		Calculator calculator = CalculatorFactory.newCalculator();
		int result = calculator.compare("123","321");
		
		assertEquals("Result of the comparison between the strings", -1, result);
	}
	
	@Test
	public void compareStringLeftGreater() throws RemoteException{
		Calculator calculator = CalculatorFactory.newCalculator();
		int result = calculator.compare("4123","321");
		
		assertEquals("Result of the comparison between the strings", 1, result);
	}
	
	@Test
	public void compareStringEquals() throws RemoteException{
		Calculator calculator = CalculatorFactory.newCalculator();
		int result = calculator.compare("321","321");
		
		assertEquals("Result of the comparison between the strings", 0, result);
	}
}
