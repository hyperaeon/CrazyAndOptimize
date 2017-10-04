package com.runoob.designpattern.businessdelegate;

public class BusinessDelegate {

	private BusinessLookUp lookupService = new BusinessLookUp();
	
	private BusinessService businessService;
	
	private String serviceType;
	
	public void setServiceTpe(String serviceType) {
		this.serviceType = serviceType;
	}
	
	public void doTask() {
		businessService = lookupService.getBusinessService(serviceType);
		businessService.doProcessing();
	}
	
}
