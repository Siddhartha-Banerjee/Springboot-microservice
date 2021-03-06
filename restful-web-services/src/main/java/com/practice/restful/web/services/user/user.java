package com.practice.restful.web.services.user;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class user {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="name must have 2 characters")
	private String name;
	
	@Past
	private Date birthdate;
	
	protected user()
	{
		
	}
	
	public user(Integer id, String name, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
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
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}

}
