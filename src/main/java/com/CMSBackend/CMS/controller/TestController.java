package com.CMSBackend.CMS.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CMSBackend.CMS.dto.ResultDto;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {
	 
	@GetMapping("/hello")
	public ResultDto helloWorld() {
		return new ResultDto(true,200,"Hello World");
		//
	}

}
