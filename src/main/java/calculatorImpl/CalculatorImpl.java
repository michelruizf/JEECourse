package calculatorImpl;

import java.util.List;

import converter.Converter;
import converterImpl.ConverterReal;
import calculator.ArrayCalculator;
import calculator.Calculator;

public class CalculatorImpl implements Calculator {
	
	private int[] leftIntArray;
	private int[] rightIntArray;
	
	private Converter converter = new ConverterReal();
	private ArrayCalculator arrayCalculator = new ArrayCalculator();

	public String add(String left, String right) {
		
		this.leftIntArray = converter.convertStringToIntArray(left);
		this.rightIntArray = converter.convertStringToIntArray(right);
		
		List<Integer> addArray = arrayCalculator.addArrays(this.leftIntArray, this.rightIntArray);
		
		return converter.convertCollectionToString(addArray);
	}

	public String subtract(String left, String right) {
		
		this.leftIntArray = converter.convertStringToIntArray(left);
		this.rightIntArray = converter.convertStringToIntArray(right);
		
		List<Integer> subtractArray = arrayCalculator.subtractArrays(this.leftIntArray, this.rightIntArray);
		
		return converter.convertCollectionToString(subtractArray);
	}

}
