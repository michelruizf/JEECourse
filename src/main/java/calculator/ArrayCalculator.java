package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import converter.Converter;
import converterImpl.ConverterReal;

public class ArrayCalculator {
	
	private int[] firstArray;
	private int[] secondArray;
	private Converter arrayConverter = new ConverterReal();
	private boolean isNegative = false;

	public List<Integer> addArrays(int[] arrayLeft, int[] arrayRight) {
		
		int rest = 0;
		List<Integer> result = new ArrayList<Integer>();
		
		defineSizeOfArrays(arrayLeft, arrayRight);
		
		for (int i = this.firstArray.length - 1; i >= 0; i--) {
			
			int sum = firstArray[i] + secondArray[i] + rest;
			if(sum > 9){
				result.add(sum % 10);
				rest = 1;
			}else{
				result.add(sum);
				rest = 0;
			}
		}
		Collections.reverse(result);
		return result;
	}

	private void defineSizeOfArrays(int[] arrayLeft, int[] arrayRight) {
		
		int size = 0;
		
		if(arrayLeft.length > arrayRight.length){
			size = arrayLeft.length;
		}else{
			size = arrayRight.length;
		}
		
		this.firstArray = arrayConverter.convertArrayWithSize(arrayLeft, size);
		this.secondArray = arrayConverter.convertArrayWithSize(arrayRight, size);
	}

	public List<Integer> subtractArrays(int[] minuendArray, int[] subtrahendArray) {
		List<Integer> result = new ArrayList<Integer>();
		int rest = 0;
		int sum = 0;
		
		defineSizeOfArrays(minuendArray, subtrahendArray);
		
		for (int i = this.firstArray.length - 1; i >= 0; i--) {
			if (this.firstArray[i] < this.secondArray[i]) {
				sum = this.firstArray[i] - this.secondArray[i] + 10 - rest;
				rest = 1;
			} else {
				if (this.firstArray[i] == this.secondArray[i]){
					sum = this.firstArray[i] - this.secondArray[i] + 10 - rest;
					rest = 1;
				} else {
					sum = this.firstArray[i] - this.secondArray[i] - rest;
					rest = 0;
				}
			}
			result.add(sum);
		}
		
		if (rest != 0){
			int[] newArray = new int[firstArray.length + 1];
			newArray[0] = 1;
			Collections.reverse(result);
			int[] arrayInt = arrayConverter.convertCollectionToArrayInt(result);
			
			this.isNegative = true;
			
			result = subtractArrays(newArray, arrayInt);
			
			return result;
		}
				
		Collections.reverse(result);
		
		if(isNegative) result.set(0, -1);
		
		return result;
	}

	public int compareArrays(int[] leftIntArray, int[] rightIntArray) {
		
		defineSizeOfArrays(leftIntArray, rightIntArray);
		
		for (int i = 0; i < rightIntArray.length; i++) {
			if(leftIntArray[i] < rightIntArray[i]){
				return -1;
			}else if(leftIntArray[i] > rightIntArray[i]){
				return 1;				
			}
		}
		return 0;
	}

}
