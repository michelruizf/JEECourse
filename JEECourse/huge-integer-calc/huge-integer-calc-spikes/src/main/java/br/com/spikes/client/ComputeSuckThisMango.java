package br.com.spikes.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.com.spikes.RMITutorial.Compute;

public class ComputeSuckThisMango {

	public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute comp = (Compute) registry.lookup(name);
            SuckThisMango task = new SuckThisMango();
            String result = comp.executeTask(task);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
}
