package com.practice.restful.web.services.user;

import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class userjparesource {
	@Autowired
	private userdaoservice service;
	
	@Autowired
	private userrepository usrepo;
	
	@GetMapping("/jpa/users")
	public List<user> retriveallusers()
	{
		return usrepo.findAll();
	}
	@GetMapping("/jpa/user/{id}")
	public EntityModel<user> finduser(@PathVariable int id)
	{
		Optional<user> u=usrepo.findById(id);
		if(!u.isPresent())
			throw new usernotfoundexception("id-"+id);
		EntityModel<user>model=EntityModel.of(u.get());
		
		WebMvcLinkBuilder linktousers=linkTo(methodOn(this.getClass()).retriveallusers());
		model.add(linktousers.withRel("all-users"));
		return model;
	}
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createuser(@Valid @RequestBody user us)
	{
		user saveduser=(user) usrepo.save(us);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/userdel/{id}")
	public void deluser(@PathVariable int id)
	{
		usrepo.deleteById(id);
		
		
	}
	
}
