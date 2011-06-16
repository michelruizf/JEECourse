package services;

import static org.junit.Assert.assertEquals;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.junit.Test;

import registry.RegistryService;
import calculator.Calculator;

public class RegisterServiceTest {
	
	@Test
	public void registerService() throws UnknownHostException{
		InetSocketAddress calculatorAddress = new InetSocketAddress("localhost", 1000);
		RegistryService.registerService(Calculator.class, calculatorAddress);
		InetSocketAddress stringAddress = new InetSocketAddress("localhost", 1001);
		RegistryService.registerService(String.class, stringAddress);
		
		InetSocketAddress address =  RegistryService.getServiceAddress(Calculator.class);
		
		assertEquals("The hostname of calculator service address","localhost", address.getHostName());
		assertEquals("The port of calculator service address",1000, address.getPort());
	}
	
	@Test
	public void registerServiceRainyDay() throws UnknownHostException{
		InetSocketAddress calculatorAddress = new InetSocketAddress("localhost", 1000);
		RegistryService.registerService(Calculator.class, calculatorAddress);
		InetSocketAddress stringAddress = new InetSocketAddress("localhost", 1009);
		RegistryService.registerService(String.class, stringAddress);
		
		InetSocketAddress address =  RegistryService.getServiceAddress(Integer.class);
		
		assertEquals("The hostname of calculator service address","localhost", address.getHostName());
		assertEquals("The port of calculator service address",1001, address.getPort());
	}

}
