package com.epam.easyshopway.model;

import java.sql.Date;

import com.epam.easyshopway.dao.transformer.annotation.Column;

public class User {
	@Column("id")
	private Integer id;

	@Column("first_name")
	private String firstName;

	@Column("last_name")
	private String lastName;

	@Column("email")
	private String email;

	@Column("password")
	private String password;

	@Column("date_of_birth")
	private Date dateOfBirth;

	@Column("active")
	private boolean active;

	@Column("role")
	private String role;

	public User() {
		super();
	}

	public User(Integer id, String firstName, String lastName, String email, String password, Date dateOfBirth,
			boolean active, String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.active = active;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = Date.valueOf(dateOfBirth);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}