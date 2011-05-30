package converter;

import java.util.List;

public interface Converter {

	int convertToInt(String stringToInt);

	String convertToString(int intToString);

	String[] convertStringToArray(String stringToArray);

	int[] convertStringArrayToIntArray(String[] stringArray);

	int[] invertArray(int[] arrayToInvert);

	int[] convertArrayWithSize(int[] smallerArray, int length);

	String[] convertCollectionToArrayString(List<Integer> collectionInteger);
	
	int[] convertCollectionToArrayInt(List<Integer> collectionInteger);

	String convertCollectionToString(List<Integer> collectionInteger);

}
