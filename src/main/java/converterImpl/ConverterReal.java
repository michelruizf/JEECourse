package converterImpl;

import java.util.List;

import converter.Converter;

public class ConverterReal implements Converter {

	public int convertToInt(String stringToInt) {
		return Integer.parseInt(stringToInt);
	}

	public String convertToString(int intToString) {
		return String.valueOf(intToString);
	}

	public String[] convertStringToArray(String stringToArray) {
		String[] result = new String[stringToArray.length()];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = String.valueOf(stringToArray.charAt(i));
		}
		return result;
	}

	public int[] convertStringArrayToIntArray(String[] stringArray) {
		int[] result = new int[stringArray.length];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = convertToInt(stringArray[i]);
		}
		return result;
	}

	public int[] invertArray(int[] arrayToInvert) {
		int[] result = new int[arrayToInvert.length];
		
		int j = arrayToInvert.length - 1;
		for (int i = 0; i < result.length; i++) {
			result[i] = arrayToInvert[j];
			j--;
		}
		return result;
	}

	public int[] convertArrayWithSize(int[] smallerArray, int length) {
		int[] result = new int[length];
		
		int j = length - 1;
		for (int i = smallerArray.length - 1; i >= 0 ; i--) {
			result[j] = smallerArray[i];
			j--;
		}
		return result;
	}

	public String[] convertCollectionToArrayString(
			List<Integer> collectionInteger) {
		String[] result = new String[collectionInteger.size()];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = String.valueOf(collectionInteger.get(i));
		}
		
		return result;
	}
	
	public int[] convertCollectionToArrayInt(
			List<Integer> collectionInteger) {
		int[] result = new int[collectionInteger.size()];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = (int)collectionInteger.get(i);
		}
		
		return result;
	}

	public String convertCollectionToString(List<Integer> collectionInteger) {
				
		StringBuilder stringBuilder = new StringBuilder();
		
		for (Integer integer : collectionInteger) {
			stringBuilder.append(String.valueOf(integer));
		}
		if(stringBuilder.charAt(0) == '0') stringBuilder.setCharAt(0, '-');
		return stringBuilder.toString();
	}

	public int[] convertStringToIntArray(String stringToIntArray) {		
		String[] stringToArray = convertStringToArray(stringToIntArray);
		return convertStringArrayToIntArray(stringToArray);
	}
}
