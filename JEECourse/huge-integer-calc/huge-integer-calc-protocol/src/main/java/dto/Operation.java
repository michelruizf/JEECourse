package dto;

public enum Operation {

	ADD("Add"),	SUBTRACT("Subtract"), COMPARE("Compare");
	
	private String operation;
	
	Operation(String operation){
		this.operation = operation;
	}

	@Override
	public String toString() {
		return this.operation;
	}
	
	
}
