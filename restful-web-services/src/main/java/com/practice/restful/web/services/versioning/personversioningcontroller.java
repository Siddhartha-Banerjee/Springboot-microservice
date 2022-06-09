package com.practice.restful.web.services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class personversioningcontroller 
{
	@GetMapping("/personv1")
	public personv1 personv1()
	{
		return new personv1("Siddhartha Banerjee");
	}
	
	@GetMapping("/personv2")
	public personv2 personv2()
	{
		return new personv2(new name("Siddhartha"," Banerjee"));
	}
	
	
	@GetMapping(value="/person/param",params="version=1")
	public personv1 paramv1()
	{
		return new personv1("Siddhartha Banerjee");
	}
	
	@GetMapping(value="/person/param",params="version=2")
	public personv2 paramv2()
	{
		return new personv2(new name("Siddhartha"," Banerjee"));
	}
}
