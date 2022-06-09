package com.practice.restful.web.services.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworldcontroller {
	
	@Autowired
	private MessageSource msgsrc;
	
	@GetMapping(path="/hello")
	public String hello()
	{
		return "Hello World";
	}
	@GetMapping(path="/hellobean")
	public hellobean hellobean()
	{
		return new hellobean("Hello World bean");
	}
	@GetMapping(path="/hello/{name}")
	public hellobean hellobeanpv(@PathVariable String name)
	{
		return new hellobean("Hello bean "+name);
	}
	@GetMapping(path="/hello-international")
	public String hellointernational(@RequestHeader(name="Accept-Language",required=false) Locale locale)
	{
		//return "Hello World";
		return msgsrc.getMessage("good.morning.message", null,"Default", locale);
	}
}
