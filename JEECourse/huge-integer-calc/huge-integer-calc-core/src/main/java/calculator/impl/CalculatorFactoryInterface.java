package calculator.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;

import calculator.Calculator;

public interface CalculatorFactoryInterface extends Remote{

	Calculator newCalculator() throws RemoteException;
}