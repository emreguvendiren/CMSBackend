package com.CMSBackend.CMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CMSBackend.CMS.dto.ResultDto;
import com.CMSBackend.CMS.model.Category;
import com.CMSBackend.CMS.respository.CategoryRepository;

@Service
public class CategoryService {

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public ResultDto CreateCategory(String name) {
		try {
			Category category = new Category();
			category.setName(name);
			
			categoryRepository.save(category);
			return new ResultDto(true, 200, "Category Added Successfully");
		} catch (Exception e) {
			
			return new ResultDto(true, 500, "ERROR!!!");
			// TODO: handle exception
		}
	}
	
	
}
