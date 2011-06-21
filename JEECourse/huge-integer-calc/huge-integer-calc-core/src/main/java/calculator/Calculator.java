package calculator;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote{

	String add(String left, String right) throws RemoteException;

	String subtract(String left, String right) throws RemoteException;

	int compare(String left, String right) throws RemoteException;

}
