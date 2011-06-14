package proxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import calculator.Calculator;
import dto.CalculatorDTO;

public class CalculatorClientProxy implements Calculator{
	
	private CalculatorDTO calculatorDto;
	private Socket clientSocket;
	private ObjectInputStream input;
	private ObjectOutputStream output;

	public CalculatorClientProxy(Socket clientSocket) throws IOException {
		this.clientSocket = clientSocket;
		this.input = new ObjectInputStream(clientSocket.getInputStream());
		this.output = new ObjectOutputStream(clientSocket.getOutputStream());
	}

	public String add(String left, String right) {
		calculatorDto = new CalculatorDTO("add", left, right);
		return calculates();
	}

	public String subtract(String left, String right) {
		calculatorDto = new CalculatorDTO("subtract", left, right);
		return calculates();
	}

	public int compare(String left, String right) {
		calculatorDto = new CalculatorDTO("compare", left, right);
		return Integer.parseInt(calculates());
	}

	private String calculates() {
		
		String result = new String();
		try {
			output.writeObject(calculatorDto);
			result = ((CalculatorDTO)input.readObject()).getResult();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return result;
	}
	
}
