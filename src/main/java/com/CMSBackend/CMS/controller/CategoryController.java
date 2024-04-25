package com.CMSBackend.CMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CMSBackend.CMS.dto.ResultDto;
import com.CMSBackend.CMS.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/createCategory")
	public ResultDto CreateCategory(String Name) {
		return categoryService.CreateCategory(Name);
	}
	
}
