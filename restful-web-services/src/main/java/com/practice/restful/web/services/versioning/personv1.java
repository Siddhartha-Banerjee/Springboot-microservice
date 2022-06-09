package com.practice.restful.web.services.versioning;

public class personv1 
{
	String name;

	public personv1() {
		super();
	}

	
	public personv1(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
