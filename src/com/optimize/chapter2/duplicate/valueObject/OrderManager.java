package com.optimize.chapter2.duplicate.valueObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OrderManager extends UnicastRemoteObject implements IOrderManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected OrderManager() throws RemoteException {
		super();
	}

	@Override
	public Order getOrder(int id) throws RemoteException {
		Order o = new Order();
		o.setClientName("billy");
		o.setNumber(20);
		o.setProductName("desk");
		return o;
	}

	@Override
	public String getClientName(int id) throws RemoteException {
		return "billy";
	}

	@Override
	public String getProdName(int id) throws RemoteException {
		return "desk";
	}

	@Override
	public int getNumber(int id) throws RemoteException {
		return 20;
	}

	@Override
	public boolean checkUser(int i) throws RemoteException {
		return false;
	}

	@Override
	public void updateOrder(Order o) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
