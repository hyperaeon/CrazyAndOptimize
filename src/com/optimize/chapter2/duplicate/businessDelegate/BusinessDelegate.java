package com.optimize.chapter2.duplicate.businessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.optimize.chapter2.duplicate.valueObject.IOrderManager;
import com.optimize.chapter2.duplicate.valueObject.Order;

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
			return userManager.checkUser(1);
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
			o.setNumber(10);
			userManager.updateOrder(o);
		}
		return true;
	}
}
