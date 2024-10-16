package com.CMSBackend.CMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CMSBackend.CMS.dto.ResultDto;
import com.CMSBackend.CMS.service.TableService;

@RestController
@RequestMapping("/table")
@CrossOrigin
public class TableController {

	
	@Autowired
	private TableService tableService;
	
	@GetMapping("/createTable")
	public ResultDto CreateTable(String Name) {
		return tableService.CreateTable(Name);
	}
	
	@GetMapping("/getAllTable")
	public ResultDto GetAllTable() {
		return tableService.GetAllTable();
	}
	
	@GetMapping("/getAllTableWithPrice")
	public ResultDto GetAllTableWithPrice() {
		return tableService.GetAllTableWithPrice();
	}
	
}
