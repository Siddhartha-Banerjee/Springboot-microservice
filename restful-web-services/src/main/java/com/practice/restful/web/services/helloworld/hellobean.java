package com.practice.restful.web.services.helloworld;

public class hellobean {
	private String message;
	public hellobean(String message)
	{
		this.message=message;
	}
	public void setMessage(String message)
	{
		this.message=message;
	}
	
	public String getMessage() {
		return message;
	}
	@Override
	public String toString() {
		return "hellobean [message=" + message + "]";
	}
	
}
