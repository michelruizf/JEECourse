package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import serverProxy.CalculatorServerProxy;
import dto.CalculatorDTO;

public class CalculatorExecution implements Runnable {

	private CalculatorServerProxy calculatorServerProxy;
	private CalculatorDTO calculatorDto = new CalculatorDTO();
	private String result;
	private String left;
	private String right;

	public CalculatorExecution(CalculatorServerProxy calculatorServerProxy) {
		this.calculatorServerProxy = calculatorServerProxy;
	}

	public void run() {
		try {
			ObjectInputStream input = new ObjectInputStream(
					calculatorServerProxy.getSocket().getInputStream());
			ObjectOutputStream output = new ObjectOutputStream(
					calculatorServerProxy.getSocket().getOutputStream());

			CalculatorDTO calculatorDto = (CalculatorDTO) input.readObject();
			System.out.println("CalculatorDTO received\n");

			initializeValues();
			
			switch (calculatorDto.getOperation()) {
			case ADD:
				result = calculatorServerProxy.add(left, right);
				break;
			case SUBTRACT:
				result = calculatorServerProxy.subtract(left, right);
				break;
			case COMPARE:
				result = String.valueOf(calculatorServerProxy.compare(left,
						right));
				break;
			default:
				result = "I could not perform the operation!";
				break;
			}

			calculatorDto.setResult(result);
			output.writeObject(calculatorDto);
			output.flush();
			System.out.println("CalculatorDTO sent\n");
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}

	}

	private void initializeValues() {
		left = calculatorDto.getLeft();
		right = calculatorDto.getRight();
		result = calculatorDto.getResult();
	}

}
