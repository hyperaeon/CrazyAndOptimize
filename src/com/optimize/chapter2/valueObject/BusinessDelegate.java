package com.optimize.chapter2.valueObject;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BusinessDelegate {

	IOrderManager userManager = null;

	public BusinessDelegate() {
		try {
			userManager = (IOrderManager) Naming.lookup("OrderManager");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public boolean checkUserFromCache(int uid) {
		return true;
	}

	public boolean checkUser(int uid) throws RemoteException {
		if (!checkUserFromCache(uid)) {
			return userManager.checkUser(uid);
		}
		return true;
	}

	public Order getOrderFromCache(int oid) {
		return null;
	}

	public Order getOrder(int oid) throws RemoteException {
		Order order = getOrderFromCache(oid);
		if (order == null) {
			return userManager.getOrder(oid);
		}
		return order;
	}

	public boolean updateOrder(Order order) throws Exception {
		if (checkUser(1)) {
			Order o = getOrder(1);
			o.setNumber(1);
			userManager.updateOrder(1);
		}
		return true;
	}
}
