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
		InetSocketAddress address = RegistryService.getServiceAddress(clazz);
		try {
			Socket socket = new Socket(address.getHostName(), address.getPort());
			calculator = new CalculatorClientProxy(socket);
		} catch (UnknownHostException e) {
			System.out.println("\nErro: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("\nErro: " + e.getMessage());
		}
		return calculator;
	}

}
