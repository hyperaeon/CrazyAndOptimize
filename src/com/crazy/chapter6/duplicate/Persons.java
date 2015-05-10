package com.crazy.chapter6.duplicate;

class Name {
	private String firstName;
	private String lastName;

	public Name() {

	}

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

public class Persons {

	private final Name name;

	public Persons(Name name) {
		// this.name = name;
		this.name = new Name(name.getFirstName(), name.getLastName());
	}

	public Name getName() {
		// return name;
		return new Name(name.getFirstName(), name.getLastName());
	}

	public static void main(String[] args) {
		Name n = new Name("Îò¿Õ", "Ëï");
		Persons p = new Persons(n);
		System.out.println(p.getName().getFirstName());
		n.setFirstName("°Ë½ä");
		System.out.println(p.getName().getFirstName());
	}
}
