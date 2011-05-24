package JEECourse.calculator;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class BigIntegerTest {
	
	@Test
	public void convertStringToInt(){
		CalculatorBigInteger calculatorBigInteger = new CalculatorBigInteger();
		int stringConverted = calculatorBigInteger.convertStringToInt("1");
		
		assertEquals("The string converted to integer", 1, stringConverted);
	}
	
	@Test
	public void addTest() {
		Calculator calculatorBigInteger = new CalculatorBigInteger();
		String result = calculatorBigInteger.add("1","1");
		
		assertEquals("The result of add", "2", result);
		
	}
	
	@Test
	public void subtractTest(){
		Calculator calculatorBigInteger = new CalculatorBigInteger();
		String result = calculatorBigInteger.subtract("2","1");
		
		assertEquals("The result of subtract", "1", result);
	}
	
	@Test
	public void compareTest() {
		Calculator calculatorBigInteger = new CalculatorBigInteger();
		int compareResult = calculatorBigInteger.compare("1","2");
		
		assertEquals("The result of compare", -1, compareResult);
		
		compareResult = calculatorBigInteger.compare("2","2");

		assertEquals("The result of compare", 0, compareResult);
		
		compareResult = calculatorBigInteger.compare("2","1");

		assertEquals("The result of compare", 1, compareResult);
	}
	
	@Test
	public void convertHugeStringToArrayOfIntegersTest(){
		CalculatorBigInteger calculatorBigInteger = new CalculatorBigInteger();
		int[] resultArrayOfIntegers = calculatorBigInteger.convertHugeStringToArrayOfIntegers("123456789012345");
		
		int[] arrayExpected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5};
		
		assertArrayEquals("Result of huge string converted to array of integers", arrayExpected, resultArrayOfIntegers);
	}
	
	@Test
	public void addHugeIntegers() {
		Calculator calculatorBigInteger = new CalculatorBigInteger();
		String resultAdd = calculatorBigInteger.add("123456789012345", "12345678");
		
		assertEquals("The result of add huge integers", "123456801358023", resultAdd);
		
	}

}
