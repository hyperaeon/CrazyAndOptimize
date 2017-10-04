package com.runoob.designpattern.businessdelegate;

public class EJBService implements BusinessService {

	@Override
	public void doProcessing() {
		System.out.println("Processing task by invoking EJB service");
	}

}
