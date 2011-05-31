package converterImpl;

import java.util.List;

import com.google.common.base.Function;


public class MyTransform {

	public static Function<List<Integer>, String> collectionToStringFunction() {
		return CollectionToStringFunction.INSTANCE;
	}

	private enum CollectionToStringFunction implements Function<List<Integer>, String> {
		INSTANCE;

		@Override
		public String toString() {
			return "toString";
		}

		public String apply(List<Integer> input) {
			StringBuilder result = new StringBuilder();
			for (Integer element : input) {
				result.append(String.valueOf(element));
			}
			if (result.charAt(0) == '0') result.setCharAt(0, '-');
			return result.toString();
		}
	}
	
	public static Function<List<Integer>, String[]> collectionToArrayStringFunction() {
		return CollectionToArrayStringFunction.INSTANCE;
	}

	private enum CollectionToArrayStringFunction implements Function<List<Integer>, String[]> {
		INSTANCE;

		@Override
		public String toString() {
			return "toString";
		}

		public String[] apply(List<Integer> input) {
			String[] result = new String[input.size()];
			
			for (int i = 0; i < result.length; i++) {
				result[i] = input.get(i).toString();
			}
			
			return result;
		}

		
	}
}
