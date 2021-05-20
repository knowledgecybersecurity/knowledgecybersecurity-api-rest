package com.bitcollege.knowledgecybersecuritywebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcollege.knowledgecybersecuritywebservice.dto.CreateUserDTO;
import com.bitcollege.knowledgecybersecuritywebservice.dto.GetUserDTO;
import com.bitcollege.knowledgecybersecuritywebservice.service.IUserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping(value = "/register")
	public ResponseEntity<?> register(@RequestBody CreateUserDTO createUserDTO) {
		try {
			GetUserDTO userToRespond = this.userService.create(createUserDTO);
			return ResponseEntity.status(HttpStatus.OK).body(userToRespond);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(e);
		}
		
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<?> update(@RequestBody GetUserDTO userToUpdate) {
		try {
			GetUserDTO userToRespond = this.userService.update(userToUpdate);
			return ResponseEntity.status(HttpStatus.OK).body(userToRespond);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(e);
		}
		
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<?> list() {
		try {
			List<GetUserDTO> usersToRespond = this.userService.list();
			return ResponseEntity.status(HttpStatus.OK).body(usersToRespond);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(e);
		}
		
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> list(@PathVariable Long id) {
		try {
			GetUserDTO userToRespond = this.userService.getUserById(id);
			return ResponseEntity.status(HttpStatus.OK).body(userToRespond);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(e);
		}
		
	}
	
}