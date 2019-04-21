package com.ajuvendra.restservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class UserBean {
	private Integer id;
	@Size(min = 2, message = "Name must be 2 or more characters")
	private String name;
	
	@Past(message = "Birthdate can not be in past")
	private Date birthDate;

	public UserBean(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public UserBean() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
}
