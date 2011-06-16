package dto;

import java.io.Serializable;

public class CalculatorDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String left;
	private String right;
	private String result;
	private Operation operation;	
	
	public CalculatorDTO() {}

	public CalculatorDTO(String left, String right, String result,
			Operation operation) {
		this.left = left;
		this.right = right;
		this.result = result;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
