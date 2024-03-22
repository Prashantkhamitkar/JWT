package com.security.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.app.model.Appuser;
import com.security.app.userservice.UserserviceImp;

@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private UserserviceImp userservice;
	@GetMapping
	public String Get() {
		return "welcome";
	}
	@PostMapping("/signup")
	public ResponseEntity<String> Signup(@RequestBody @Valid Appuser request){
		if(request!=null) {
			userservice.signupuser(request);
		return new ResponseEntity<String>("success", HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<String>("fail", HttpStatus.CHECKPOINT);
	}
}
