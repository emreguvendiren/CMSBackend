package com.CMSBackend.CMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CMSBackend.CMS.dto.ReqRes;
import com.CMSBackend.CMS.dto.ResultDto;
import com.CMSBackend.CMS.model.User;
import com.CMSBackend.CMS.service.AuthService;
import com.CMSBackend.CMS.service.UserDetailsService;
import com.CMSBackend.CMS.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthService authService;
	
	
	@GetMapping("/getAllUsers")
	public Iterable<User> getAllUsers(){
		return userService.getAllUser();
	}
	@PostMapping("/AddUser")
	public ResultDto addUSer(@RequestBody ReqRes user) {
		return authService.signUp(user);
	}
}
