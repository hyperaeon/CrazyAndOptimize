package com.optimize.chapter2.duplicate.valueObject;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOrderManager extends Remote {

	public Order getOrder(int id) throws RemoteException;

	public String getClientName(int id) throws RemoteException;

	public String getProdName(int id) throws RemoteException;

	public int getNumber(int id) throws RemoteException;

	public boolean checkUser(int i) throws RemoteException;

	public void updateOrder(Order o) throws RemoteException;
}
