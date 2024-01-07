package org.intern.usertask.controller;

import org.intern.usertask.dto.ResponseStructure;
import org.intern.usertask.dto.User;
import org.intern.usertask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> SaveUser(@RequestBody User u) {
		return service.SaveUser(u);
	}

	@PutMapping("/users")
	public ResponseEntity<ResponseStructure<User>> UpdateUser(@RequestBody User u) {
		return service.UpdateUser(u);
	}

}
