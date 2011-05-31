package converterImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Splitter;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import converter.Converter;

public class ConverterReal implements Converter {

	public int convertToInt(String stringToInt) {
		return Integer.parseInt(stringToInt);
	}

	public String convertToString(int intToString) {
		return String.valueOf(intToString);
	}

	public String[] convertStringToArray(String stringToArray) {
		Iterable<String> iterable = Splitter.fixedLength(1)
				.split(stringToArray);
		String[] result = Iterables.toArray(iterable, String.class);
		return result;
	}

	public int[] convertStringArrayToIntArray(String[] stringArray) {
		ArrayList<String> stringList = Lists.newArrayList(stringArray);
		Collection<Integer> integerList = Collections2.transform(stringList, MyFunctions.toIntegerFunction());
		return Ints.toArray(integerList);
	}

	public int[] invertArray(int[] arrayToInvert) {
		List<Integer> asList = Ints.asList(arrayToInvert);
		Collections.reverse(asList);
		return Ints.toArray(asList);
	}

	public int[] convertArrayWithSize(int[] smallerArray, int length) {

		int[] result = new int[length];

		int j = length - 1;
		for (int i = smallerArray.length - 1; i >= 0; i--) {
			result[j] = smallerArray[i];
			j--;
		}
		return result;

	}

	public String[] convertCollectionToArrayString(
			List<Integer> collectionInteger) {
		
		return MyTransform.collectionToArrayStringFunction().apply(collectionInteger);
	}

	public int[] convertCollectionToArrayInt(List<Integer> collectionInteger) {
		return Ints.toArray(collectionInteger);
	}

	public int[] convertStringToIntArray(String stringToIntArray) {
		String[] stringToArray = convertStringToArray(stringToIntArray);
		return convertStringArrayToIntArray(stringToArray);
	}

	public String convertCollectionToString(List<Integer> collectionInteger) {
		String result = MyTransform.collectionToStringFunction().apply(collectionInteger);
		return result;
	}
}
