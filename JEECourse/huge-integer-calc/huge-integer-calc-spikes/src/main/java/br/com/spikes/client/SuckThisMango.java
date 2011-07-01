package br.com.spikes.client;

import java.io.Serializable;

import br.com.spikes.RMITutorial.Task;

public class SuckThisMango implements Task<String>, Serializable {
	
	private static final long serialVersionUID = -9099125467176914047L;
	
	public SuckThisMango(){};

	public String execute() {
		return "Suck this mango manolo!";
	}

}
