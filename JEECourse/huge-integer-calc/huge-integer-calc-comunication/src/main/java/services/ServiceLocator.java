package services;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import clientProxy.CalculatorClientProxy;

import registry.RegistryService;
import calculator.Calculator;

public class ServiceLocator {

	public static Calculator getService(Class<?> clazz) {
		Calculator calculator = null;
		
		try {
			InetSocketAddress address = RegistryService.getServiceAddress(clazz);
			Socket socket = new Socket("localhost", address.getPort());
			calculator = new CalculatorClientProxy(socket);
		} catch (UnknownHostException e) {
			System.out.println("An error occurred: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
		return calculator;
	}

}
