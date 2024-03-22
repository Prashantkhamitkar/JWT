package com.security.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.app.config.JwtUtils;
import com.security.app.daos.Userdao;
import com.security.app.dtos.Signinres;
import com.security.app.dtos.Signinresponse;
import com.security.app.model.Appuser;
import com.security.app.userservice.UserserviceImp;

@RestController
@RequestMapping("/users")
public class UserAuthentication {
@Autowired
private AuthenticationManager authmanager;
@Autowired
private JwtUtils utils;


@PostMapping("/")
public ResponseEntity<?> signIn(@RequestBody Signinres appuser){
	System.out.println("in signin "+appuser.getEmail()+" "+appuser.getPassword());
	Authentication principal=authmanager.authenticate(new UsernamePasswordAuthenticationToken(appuser.getEmail(), appuser.getPassword()));
	String jwttoken=utils.generatToken(principal);
	return ResponseEntity.ok(new Signinresponse(jwttoken,"user authenticated sucessfully"));
}
	
}
