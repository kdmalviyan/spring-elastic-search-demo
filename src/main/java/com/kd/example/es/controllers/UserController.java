package com.kd.example.es.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kd.example.es.models.Address;
import com.kd.example.es.models.User;
import com.kd.example.es.services.ElasticSearchUserService;

@RestController
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private ElasticSearchUserService elasticSearchUserService;

	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User user) {
		user = elasticSearchUserService.create(user);
		return ResponseEntity.ok(user);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> find(@PathVariable("id") String id) {
		User user = elasticSearchUserService.find(id);
		return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<Iterable<User>> demoCreate() {
		User user = new User();
		user.setName("Kuldeep Singh");
		user.setDesignation("Technicsl Specialist");
		user.setCompany("HCL");
		// user.setId(1L);

		Address address = new Address();
		address.setState("UP");
		address.setCity("Noida");
		address.setCurrent(true);
		address.setOffice(false);
		address.setCountry("India");
		// address.setId(1L);
		address.setStreet("Noida Extention");
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		user.setAddresses(addresses);
		user = elasticSearchUserService.create(user);
		return ResponseEntity.ok(elasticSearchUserService.find());
	}
}
