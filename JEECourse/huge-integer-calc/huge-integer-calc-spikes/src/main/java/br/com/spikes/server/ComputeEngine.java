package br.com.spikes.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.com.spikes.RMITutorial.Compute;
import br.com.spikes.RMITutorial.Task;

public class ComputeEngine implements Compute {
	
	public ComputeEngine() {
		super();
	}

	public <T> T executeTask(Task<T> t) {
		return t.execute();
	}

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			String name = "Compute";
			Compute engine = new ComputeEngine();
			Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(name, stub);
			System.out.println("ComputeEngine bound");
		} catch (Exception e) {
			System.err.println("ComputeEngine exception:");
			e.printStackTrace();
		}
	}
}
