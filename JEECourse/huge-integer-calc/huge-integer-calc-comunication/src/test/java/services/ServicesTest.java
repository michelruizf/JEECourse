package services;

import static org.junit.Assert.*;
import org.junit.Test;
import calculator.Calculator;

public class ServicesTest {

	@Test
	public void getAService(){
		Calculator calculator = ServiceLocator.getService(Calculator.class);
		
		assertNotNull("The return calculator",calculator);
	}
}
