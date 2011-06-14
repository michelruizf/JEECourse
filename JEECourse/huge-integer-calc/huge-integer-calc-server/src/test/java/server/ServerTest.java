package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import calculator.Calculator;
import dto.CalculatorDTO;
import factory.CalculatorServerFactory;

public class ServerTest {
	
	public static void main(String[] args) {
		try {
			System.out.println("Initializing the fucking Server\n");			
			ServerSocket serverSocket = new ServerSocket(1000, 0, InetAddress.getLocalHost());			
			Socket socket = serverSocket.accept();
			System.out.println("Client connection accepted\n");
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			
			Calculator newCalculator = CalculatorServerFactory.newCalculator();
			
			CalculatorDTO calculatorDto = (CalculatorDTO)input.readObject();
			System.out.println("CalculatorDTO received\n");
			
			String result = new String();
			if(calculatorDto.getOperation().equals("add")){
				result = newCalculator.add(calculatorDto.getLeft(), calculatorDto.getRight());
			} else if(calculatorDto.getOperation().equals("subtract")){
				result = newCalculator.subtract(calculatorDto.getLeft(), calculatorDto.getRight());
			} else {
				int intResult = newCalculator.compare(calculatorDto.getLeft(), calculatorDto.getRight());
				result = String.valueOf(intResult);
			}
			
			calculatorDto.setResult(result);
			output.writeObject(calculatorDto);
			System.out.println("CalculatorDTO sent\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
