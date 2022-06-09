package com.practice.restful.web.services.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class userdaoservice {
	private static List<user> users=new ArrayList<>();
	static {
		users.add(new user(1,"Sid",new Date()));
		users.add(new user(2,"puja",new Date()));
		users.add(new user(3,"Sohom",new Date()));
	}
	
	public List<user> findall()
	{
		return users;
	}
	
	private static int usercount=3;
	
	public user save(user us)
	{
		if(us.getId()==null)
		{
			us.setId(++usercount);
		}
		users.add(us);
		return us;
	}
	public user findone(int id)
	{
		for(user u:users)
		{
			if(u.getId()==id)
				return u;
		}
		return null;
	}
	public user delbyid(int id)
	{
		Iterator<user> iterator=users.iterator();
		while(iterator.hasNext())
		{
			user us=iterator.next();
			if(us.getId()==id)
			{
				iterator.remove();
				return us;
			}
		}
		return null;
	}
}
