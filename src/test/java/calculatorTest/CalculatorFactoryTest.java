package calculatorTest;

import static org.junit.Assert.*;
import org.junit.Test;

import calculator.Calculator;
import calculator.impl.CalculatorFactory;

public class CalculatorFactoryTest {

	@Test
	public void createInstanceOfCalculatorUsingFactory(){
		assertTrue(CalculatorFactory.newCalculator() instanceof Calculator);
	}
}
