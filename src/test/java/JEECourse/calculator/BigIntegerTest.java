package JEECourse.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class BigIntegerTest {
	
	@Test
	public void convertStringToInt(){
		Calculator calculatorBigInteger = new CalculatorBigInteger();
		int stringConverted = calculatorBigInteger.convertStringToInt("1");
		
		assertEquals("The string converted to integer", 1, stringConverted);
	}
	
}
