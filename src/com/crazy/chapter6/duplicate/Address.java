package com.crazy.chapter6.duplicate;

public class Address {

	private final String detail;
	private final String postCode;

	public Address() {
		this.detail = "";
		this.postCode = "";
	}

	public Address(String detail, String postCode) {
		this.detail = detail;
		this.postCode = postCode;
	}

	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		return detail.hashCode() + postCode.hashCode() * prime;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj != null && obj.getClass() == Address.class) {
			Address other = (Address) obj;
			if (other.getDetail().equals(this.detail)
					&& other.getPostCode().equals(this.postCode)) {
				return true;
			}
		}
		return false;
	}

}
