package JEECourse.calculator;

import java.util.ArrayList;
import java.util.List;


public class CalculatorBigInteger implements Calculator {

	private int intLeft;
	private int intRight;
	private int[] arrayIntLefts;
	private int[] arrayIntRights;
	
	public CalculatorBigInteger() {	}

	public int convertStringToInt(String numberAsString) {
		return Integer.valueOf(numberAsString);
	}

	public String add(String left, String right) {
		if ((left.length() > 9) || (right.length() > 9)){
			arrayIntLefts = convertHugeStringToArrayOfIntegers(left);
			arrayIntRights = convertHugeStringToArrayOfIntegers(right);
			
			int[] addedArray = addArrayOfIntegers(arrayIntLefts, arrayIntRights);
			
			return String.valueOf(intLeft + intRight);
		} else{
			intLeft = convertStringToInt(left);
			intRight = convertStringToInt(right);
			return String.valueOf(intLeft + intRight);
		}
	}

	private int[] addArrayOfIntegers(int[] arrayIntLefts, int[] arrayIntRights) {
		List<Integer> result = new ArrayList<Integer>();
				
		return null;
	}

	public String subtract(String left, String right) {
		intLeft = convertStringToInt(left);
		intRight = convertStringToInt(right);
		return String.valueOf(intLeft - intRight);
	}

	public int compare(String left, String right) {
		intLeft = convertStringToInt(left);
		intRight = convertStringToInt(right);

		if (intLeft < intRight) return -1;
		if (intLeft == intRight) return 0;
		return 1;
	}

	public int[] convertHugeStringToArrayOfIntegers(String numberAsString) {
		
		int[] arrayOfInt = new int[numberAsString.length()];
		StringBuilder stringBuilder = new StringBuilder(numberAsString);
		
		for (int i = 0; i < numberAsString.length(); i++) {
			arrayOfInt[i] = Integer.parseInt(String.valueOf(stringBuilder.charAt(i)));
		}
		
		return arrayOfInt;
	}

}
