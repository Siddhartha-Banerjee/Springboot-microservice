package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class alean
{
	private String name;
	private int id;
	private String tech;
	public String getname()
	{
		return name;
	}
	public int getid()
	{
		return id;
	}
	public String gettech()
	{
		return tech;
	}
	public void setid(int i)
	{
		id=i;
	}
	public void setname(String nm)
	{
		name=nm;
	}
	public void settech(String t)
	{
		tech=t;
	}
	public void show()
	{
		System.out.println("in alean class");
	}
}