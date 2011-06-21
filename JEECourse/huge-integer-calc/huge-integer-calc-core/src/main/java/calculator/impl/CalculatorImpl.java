package calculator.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import calculator.Calculator;

import commons.arrayCalculator.ArrayCalculator;
import commons.utils.Utils;

class CalculatorImpl extends UnicastRemoteObject implements Calculator {

	private static final long serialVersionUID = 2786934594007694466L;

	private int[] leftIntArray;
	private int[] rightIntArray;
	
	private ArrayCalculator arrayCalculator = new ArrayCalculator();

	CalculatorImpl() throws RemoteException {}
	
	public String add(String left, String right) {
		
		convertStringsToIntArray(left, right);
		
		List<Integer> addArray = arrayCalculator.addArrays(this.leftIntArray, this.rightIntArray);
		
		return Utils.convertCollectionToString(addArray);
	}

	public String subtract(String left, String right) {
		
		convertStringsToIntArray(left, right);
		
		List<Integer> subtractArray = arrayCalculator.subtractArrays(this.leftIntArray, this.rightIntArray);
		
		String result = Utils.convertCollectionToString(subtractArray);		
		
		return result;
	}

	public int compare(String left, String right) {
		
		convertStringsToIntArray(left, right);		
		int result = arrayCalculator.compareArrays(this.leftIntArray, this.rightIntArray);
		return result;
	}

	private void convertStringsToIntArray(String left, String right) {
		this.leftIntArray = Utils.convertStringToIntArray(left);
		this.rightIntArray = Utils.convertStringToIntArray(right);
	}

}
