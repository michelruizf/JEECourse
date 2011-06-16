package server;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import registry.RegistryService;
import serverProxy.CalculatorServerProxy;
import calculator.Calculator;

public class CalculatorService {

	private static Calculator calculator;
	private static ServerSocket serverSocket;

	public static void init(Calculator calc, int port, String hostname) {
		try {
			System.out.println("Initializing the fucking Server\n");
			calculator = calc;

			System.out.println("Registering a new service for "
					+ calc.getClass().getSimpleName() + "\n");
			RegistryService.registerService(calc.getClass(), new InetSocketAddress(
							InetAddress.getByName(hostname), port));
			InetSocketAddress address = RegistryService.getServiceAddress(calc
					.getClass());

			serverSocket = new ServerSocket(address.getPort(), 1);
			while (true) {
				System.out.println("Waiting for a new connection...\n");
				Socket socket = serverSocket.accept();
				System.out.println("Connection accepted starting service...\n");
				new CalculatorExecution(new CalculatorServerProxy(socket,
						calculator)).run();
			}
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}
}
