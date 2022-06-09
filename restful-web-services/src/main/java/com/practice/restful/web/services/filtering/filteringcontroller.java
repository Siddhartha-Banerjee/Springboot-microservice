package com.practice.restful.web.services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class filteringcontroller 
{
	@GetMapping("/filtering")
	public MappingJacksonValue retsomben()
	{
		somebean sb=new somebean("Val1","Val2","Val3");
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("sb",filter);
		MappingJacksonValue mapping=new MappingJacksonValue(sb);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/filteringlist")
	public MappingJacksonValue returnsomebeanlist()
	{
		List<somebean> list=Arrays.asList(new somebean("Val1","Val2","Val3"),new somebean("sid","puja","sohom"));
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider filters=new SimpleFilterProvider().addFilter("sb",filter);
		MappingJacksonValue mapping=new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
}
