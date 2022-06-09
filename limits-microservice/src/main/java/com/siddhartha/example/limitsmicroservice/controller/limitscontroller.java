package com.siddhartha.example.limitsmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siddhartha.example.limitsmicroservice.bean.limits;
import com.siddhartha.example.limitsmicroservice.configuration.Configuration;

@RestController
public class limitscontroller {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public limits retrievelimits()
	{
		return new limits(configuration.getMinimum(),configuration.getMaximum());
		//return new limits(1,1000);
	}
}
