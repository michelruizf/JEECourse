package services;

import static org.junit.Assert.assertEquals;

import java.net.InetSocketAddress;

import org.junit.Test;

import registry.RegistryService;
import calculator.Calculator;

public class RegisterServiceTest {
	
	@Test
	public void registerService(){
		InetSocketAddress calculatorAddress = new InetSocketAddress("localhost", 1001);
		RegistryService.registerService(Calculator.class, calculatorAddress);
		InetSocketAddress stringAddress = new InetSocketAddress("localhost", 1001);
		RegistryService.registerService(String.class, stringAddress);
		
		InetSocketAddress address =  RegistryService.getServiceAddress(Calculator.class);
		
		assertEquals("The hostname of calculator service address","localhost", address.getHostName());
		assertEquals("The port of calculator service address",1001, address.getPort());
	}
	
	@Test
	public void registerServiceRainyDay(){
		InetSocketAddress calculatorAddress = new InetSocketAddress("localhost", 1001);
		RegistryService.registerService(Calculator.class, calculatorAddress);
		InetSocketAddress stringAddress = new InetSocketAddress("localhost", 1001);
		RegistryService.registerService(String.class, stringAddress);
		
		InetSocketAddress address =  RegistryService.getServiceAddress(Integer.class);
		
		assertEquals("The hostname of calculator service address","localhost", address.getHostName());
		assertEquals("The port of calculator service address",8080, address.getPort());
	}

}
