package com.task22.RestService.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custID;

	private String title;

	@Column(name = "Fname")
	private String firstName;

	@Column(name = "Lname")
	private String lastName;

	@Email
	private String email;

	private String company;

	private String displayName;

	public Customer() {
	}

	public Customer(String title, String firstName, String lastName, @Email String email, String company,
			String displayName) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.company = company;
		this.displayName = displayName;
	}

	public Customer(int custID, String title, String firstName, String lastName, @Email String email, String company,
			String displayName) {
		super();
		this.custID = custID;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.company = company;
		this.displayName = displayName;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	@Override
	public String toString() {
		return "Customer [title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", company=" + company + ", displayName=" + displayName + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
