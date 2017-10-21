package com.accc.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.accc.forms.CustomerForm;

@Entity
public class Customer {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column
	private String contactNumber;
	
	@OneToMany
	private List<Car> cars = new ArrayList<>();
	
	public Customer(String firstName, String lastName, String address, String contactNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.name = firstName + " " + lastName;
	}
	
	public void updateFromForm(CustomerForm form) {
		this.firstName = form.getFirstName();
		this.lastName = form.getLastName();
		this.address = form.getAddress();
		this.contactNumber = form.getContactNumber();
	}
	
	public void addCar(Car car) {
		this.cars.add(car);
	}
	
	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public List<Car> getCars() {
		return cars;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", name=" + name + ", address=" + address
				+ ", contactNumber=" + contactNumber + ", cars=" + cars + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	protected Customer() {}
}
