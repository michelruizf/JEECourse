package converterTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import calculator.ArrayCalculator;
import converter.Converter;
import converter.ConverterReal;

public class ConverterTest{
	
	@Test
	public void convertStringToInt(){
		Converter converter = new ConverterReal();
		int result = converter.convertToInt("5");
		
		assertEquals("String converted to int", 5, result);
	}
	
	@Test
	public void convertIntToString(){
		Converter converter = new ConverterReal();
		String result = converter.convertToString(6);
		
		assertEquals("Int converted to string", "6", result);
	}

	@Test
	public void convertStringToArray(){
		Converter converter = new ConverterReal();
		String[] result = converter.convertStringToArray("123");
		
		String[] expected = {"1","2","3"};
		assertArrayEquals("String  converted to array of strings", expected, result);
	}
	
	@Test
	public void convertStringArrayToIntArray(){
		String[] stringArray = {"1","2","3"};
		Converter converter = new ConverterReal();
		int[] result = converter.convertStringArrayToIntArray(stringArray);
		
		int[] expected = {1,2,3};
		assertArrayEquals("String array converted to int array", expected, result);
	}
	
	@Test
	@Ignore
	public void invertArray(){
		int[] array = {1,2,3};
		Converter converter = new ConverterReal();
		int[] result =converter.invertArray(array);
		
		int[] expected = {3,2,1};
		
		assertArrayEquals("Invert array", expected, result);
	}
	
	@Test
	public void createArraysWithLargerSize(){
		
		int[] smallerArray = {9,8};
		
		Converter converter = new ConverterReal();
		int[] result = converter.convertArrayWithSize(smallerArray, 3);
		
		int[] expected = {0,9,8};
		
		assertArrayEquals("Array with the similar size", result, expected);
	}
	
	@Test
	public void createArraysWithSimilarSize(){
		
		int[] smallerArray = {9,8};
		
		Converter converter = new ConverterReal();
		int[] result = converter.convertArrayWithSize(smallerArray, 2);
		
		int[] expected = {9,8};
		
		assertArrayEquals("Array with the similar size", result, expected);
	}
	
	@Test
	public void addArrays(){
		int[] largerArray = {1,2,3};
		int[] smallerArray = {9,8};
		
		ArrayCalculator simpleCalculator = new ArrayCalculator();
		List<Integer> result = simpleCalculator.addArrays(largerArray, smallerArray);
		
		List<Integer> expecteds = Arrays.asList(2,2,1);
		
		
		assertEquals("Result of add arrays", expecteds, result);
	}
	
	@Test
	public void convertIntegerCollectionToStringArray(){
		List<Integer> collectionInteger = Arrays.asList(2,2,1);
		
		Converter converter = new ConverterReal();
		String[] result = converter.convertCollectionToArrayString(collectionInteger);
		
		String[] expected = {"2", "2", "1"};
		
		assertArrayEquals("", expected, result);
	}
	
	@Test
	public void subtractArrays(){
	
		int[] largerArray = {3,8};
		int[] smallerArray = {7,2};
		
		ArrayCalculator simpleCalculator = new ArrayCalculator();
		List<Integer> result = simpleCalculator.subtractArrays(largerArray, smallerArray);
		
		List<Integer> expected = Arrays.asList(0,3,4);
		
		assertEquals("Result of add arrays", expected, result);
	}
}