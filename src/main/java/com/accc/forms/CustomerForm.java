package com.accc.forms;

import java.io.Serializable;

public class CustomerForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6214052382932693450L;

	private String firstName;

	private String lastName;

	private String address;

	private String contactNumber;

	public CustomerForm(String firstName, String lastName, String address, String contactNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contactNumber = contactNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CustomerForm [firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", contactNumber=" + contactNumber + "]";
	}

}
