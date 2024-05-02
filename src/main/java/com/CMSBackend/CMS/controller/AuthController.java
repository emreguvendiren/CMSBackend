package com.CMSBackend.CMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CMSBackend.CMS.dto.ReqRes;
import com.CMSBackend.CMS.dto.ResultDto;
import com.CMSBackend.CMS.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public ResultDto signUp(@RequestBody ReqRes signUpRequest) {
		
		return authService.signUp(signUpRequest);		
	}
	@PostMapping("/signin")
	public ResultDto signIn(@RequestBody ReqRes signInRequest) {
	
		return authService.signIn(signInRequest);		
	}
	@PostMapping("/refresh")
	public ResultDto refresh(@RequestBody ReqRes refreshRequest) {
	
		return authService.refreshToken(refreshRequest);		
	}
}
