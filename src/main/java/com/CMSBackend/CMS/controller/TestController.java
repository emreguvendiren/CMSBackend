package com.CMSBackend.CMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CMSBackend.CMS.dto.ResultDto;
import com.CMSBackend.CMS.service.TestService;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {
	 
	@Autowired
	private TestService testService;
	
	
	@GetMapping("/createUser")
	public ResultDto CreateUser(String Username,String Password) {
		return testService.createUser(Username, Password);
		//
	}

}
