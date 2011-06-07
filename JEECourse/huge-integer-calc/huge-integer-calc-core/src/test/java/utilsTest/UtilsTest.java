package utilsTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import commons.utils.Utils;


public class UtilsTest {

	@Test
	public void convertStringToIntArray(){
		int[] intArray = Utils.convertStringToIntArray("12345");
		
		int[] expected = {1,2,3,4,5};
		
		assertArrayEquals("String converted to int array", expected, intArray);
	}
	
	@Test
	public void convertCollectionToString(){
		ArrayList<Integer> collection = new ArrayList<Integer>();
		collection.add(1);
		collection.add(2);
		collection.add(3);
		
		String result = Utils.convertCollectionToString(collection);
		
		assertEquals("Collection converted to string", "123", result);
	}
}
