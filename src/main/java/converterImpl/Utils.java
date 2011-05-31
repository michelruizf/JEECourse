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
		
		Collection<Integer> collection = Collections2.transform(Arrays.asList(stringArray), MyFunctions.toStringFunction());
		
		return Ints.toArray(collection);
	}
	
	public static String convertCollectionToString(Collection collection){
		return null;
		
	}

}
