package com.crazy.chapter6;

public class Address {

	private final String detail;
	private final String postCode;
	
	public Address(){
		this.detail = "";
		this.postCode = "";
	}
	
	public Address(String detail,String postCode){
		this.detail = detail;
		this.postCode = postCode;
	}

	public String getDetail() {
		return detail;
	}

	public String getPostCode() {
		return postCode;
	}
	
	public boolean equals(Object obj){
		if(obj == this){
			return true;
		}
		if(obj != null && obj.getClass() == Address.class){
			Address address = (Address)obj;
			if(address.getDetail().equals(this.getDetail()) &&
					address.getPostCode().equals(this.getPostCode())){
				return true;
			}
		}
		return false;
	}
	
	public int hashCode(){
		return detail.hashCode() + postCode.hashCode() * 31;
	}
}
