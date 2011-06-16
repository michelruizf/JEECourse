package clientProxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import calculator.Calculator;
import dto.CalculatorDTO;
import dto.Operation;

public class CalculatorClientProxy implements Calculator{

	private Socket clientSocket;
	private CalculatorDTO calculatorDTO;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	
	public CalculatorClientProxy(Socket clientSocket) throws IOException {
		this.clientSocket = clientSocket;
		this.output = new ObjectOutputStream(clientSocket.getOutputStream());
	}

	public String add(String left, String right) {
		calculatorDTO = new CalculatorDTO(left, right, "", Operation.ADD);
		return execute();
	}

	public String subtract(String left, String right) {
		calculatorDTO = new CalculatorDTO(left, right, "", Operation.SUBTRACT);
		return execute();
	}

	public int compare(String left, String right) {
		calculatorDTO = new CalculatorDTO(left, right, "", Operation.COMPARE);
		return Integer.parseInt(execute());
	}

	private String execute() {
		
		String result = new String();
		try {

			output.writeObject(calculatorDTO);
			output.flush();
			input = new ObjectInputStream(clientSocket.getInputStream());
			result = ((CalculatorDTO)input.readObject()).getResult();
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
		
		return result;
	}
}
