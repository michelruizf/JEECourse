package calculatorImpl;

import java.util.List;

import calculator.ArrayCalculator;
import calculator.Calculator;
import converterImpl.Utils;

public class CalculatorImpl implements Calculator {
	
	private int[] leftIntArray;
	private int[] rightIntArray;
	
	private ArrayCalculator arrayCalculator = new ArrayCalculator();

	public String add(String left, String right) {
		
		this.leftIntArray = Utils.convertStringToIntArray(left);
		this.rightIntArray = Utils.convertStringToIntArray(right);
		
		List<Integer> addArray = arrayCalculator.addArrays(this.leftIntArray, this.rightIntArray);
		
		return Utils.convertCollectionToString(addArray);
	}

	public String subtract(String left, String right) {
		
		this.leftIntArray = Utils.convertStringToIntArray(left);
		this.rightIntArray = Utils.convertStringToIntArray(right);
		
		List<Integer> subtractArray = arrayCalculator.subtractArrays(this.leftIntArray, this.rightIntArray);
		
		String result = Utils.convertCollectionToString(subtractArray);		
		
		return result;
	}

}
