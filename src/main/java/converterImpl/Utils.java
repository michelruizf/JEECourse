package converterImpl;

import java.util.Arrays;
import java.util.Collection;

import com.google.common.base.Splitter;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;

public class Utils {
	
	public static int[] convertStringToIntArray(String stringToArray){
		Iterable<String> stringIterator = Splitter.fixedLength(1).split(stringToArray);
		String[] stringArray = Iterables.toArray(stringIterator, String.class);
		
		Collection<Integer> collection = Collections2.transform(Arrays.asList(stringArray), MyFunctions.toIntegerFunction());
		
		return Ints.toArray(collection);
	}
	
	public static String convertCollectionToString(Collection<Integer> collection){
		StringBuffer stringBuffer = new StringBuffer();
		boolean isNegativeCollection = false;
		
		isNegativeCollection = collection.contains(-1);
		
		for (Integer element : collection) {
			stringBuffer.append(element.toString());
		}
				
		if(isNegativeCollection) {
			stringBuffer.setCharAt(0, '-');
		}
		
		String result = stringBuffer.toString().replaceFirst("-1", "-");
		
		return result;
	}
}
