package calculatorImpl;

import java.util.List;

import converter.Converter;
import converter.ConverterReal;
import calculator.ArrayCalculator;
import calculator.Calculator;

public class CalculatorImpl implements Calculator {
	
	private Converter converter = new ConverterReal();
	private ArrayCalculator arrayCalculator = new ArrayCalculator();

	public String add(String left, String right) {
		
		String[] leftStringArray = converter.convertStringToArray(left);
		String[] rightStringArray = converter.convertStringToArray(right);
		
		int[] leftIntArray = converter.convertStringArrayToIntArray(leftStringArray);
		int[] rightIntArray = converter.convertStringArrayToIntArray(rightStringArray);
		
		List<Integer> addArray = arrayCalculator.addArrays(leftIntArray, rightIntArray);
		
		return converter.convertCollectionToString(addArray);
	}

	public String subtract(String left, String right) {
		
		String[] leftStringArray = converter.convertStringToArray(left);
		String[] rightStringArray = converter.convertStringToArray(right);
		
		int[] leftIntArray = converter.convertStringArrayToIntArray(leftStringArray);
		int[] rightIntArray = converter.convertStringArrayToIntArray(rightStringArray);
		
		List<Integer> subtractArray = arrayCalculator.subtractArrays(leftIntArray, rightIntArray);
		
		return converter.convertCollectionToString(subtractArray);
	}

}
