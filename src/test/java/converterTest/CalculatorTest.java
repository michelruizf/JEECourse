package converterTest;

import static org.junit.Assert.*;
import org.junit.Test;

import calculator.Calculator;
import calculatorImpl.CalculatorImpl;

public class CalculatorTest {
	
	@Test
	public void addHugeIntegers(){
		Calculator calculator = new CalculatorImpl();
		String result = calculator.add("123456789012345", "9876543210");
		
		assertEquals("Result of added huge integers", "123466665555555", result);
	}
	
	@Test
	public void subtractHugeIntegers(){
		Calculator calculator = new CalculatorImpl();
		String result = calculator.subtract("123456789012345", "9876543210");
		
		assertEquals("Result of subtract huge integers", "123446912469135", result);
	}
	
	@Test
	public void subtractHugeIntegers2(){
		Calculator calculator = new CalculatorImpl();
		String result = calculator.subtract("9876543210", "123456789012345");
		
		//Aqui deveria estar com o sinal negativo
		assertEquals("Result of subtract huge integers with negative value", "0123446912469135", result);
	}

}
