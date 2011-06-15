package dto;

import java.io.Serializable;

public class CalculatorDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String operation;
	private String left;
	private String right;
	private String result;

	public CalculatorDTO() {
	}

	public CalculatorDTO(String operation, String left, String right) {
		this.operation = operation;
		this.left = left;
		this.right = right;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}
}
