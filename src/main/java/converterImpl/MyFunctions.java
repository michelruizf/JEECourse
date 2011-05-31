package converterImpl;

import java.util.ArrayList;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class MyFunctions {

	public static Function<String, Integer> toIntegerFunction() {
		return ToIntegerFunction.INSTANCE;
	}

	private enum ToIntegerFunction implements Function<String, Integer> {
		INSTANCE;

		@Override
		public String toString() {
			return "toString";
		}

		public Integer apply(String input) {
			return Integer.parseInt(input);
		}
	}

	public static Function<String[], Integer[]> stringToIntegerFunction() {
		return StringToIntegerFunction.INSTANCE;
	}
	
	private enum StringToIntegerFunction implements Function<String[], Integer[]>{
		INSTANCE;

		public Integer[] apply(String[] input) {
			ArrayList<String> arrayList = Lists.newArrayList(input);
			Integer[] result = Collections2.transform(arrayList, toIntegerFunction()).toArray(new Integer[0]);
			return result;
		}

		@Override
		public String toString() {
			return super.toString();
		}
		
		
		
	}
	
	public static Function<String, Integer> toStringFunction() {
		return ToStringFunction.INSTANCE;
	}
	
	private enum ToStringFunction implements Function<String, Integer>{
		INSTANCE;

		@Override
		public String toString() {
			return super.toString();
		}

		public Integer apply(String input) {
			return Integer.parseInt(input);
		}
		
		
		
	}

}
