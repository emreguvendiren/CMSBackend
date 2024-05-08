package com.CMSBackend.CMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CMSBackend.CMS.dto.ResultDto;
import com.CMSBackend.CMS.model.Category;
import com.CMSBackend.CMS.model.Table;
import com.CMSBackend.CMS.respository.TableRepository;

@Service
public class TableService {

	@Autowired
	private TableRepository tableRepository;
	
	public ResultDto CreateTable(String tableName) {
		try {
			Table table = new Table();
				table.setTableName(tableName);
			
			tableRepository.save(table);
			return new ResultDto(true, 200, "Table Added Successfully");
		} catch (Exception e) {
			
			return new ResultDto(true, 500, "ERROR!!!");
			// TODO: handle exception
		}
	}
	
	public ResultDto GetAllTable() {
		try {
			
			var tables = tableRepository.findAll();
			
			return new ResultDto(tables, 200, "Table Getted Successfully");

			
			
		} catch (Exception e) {
			return new ResultDto(true, 500, "ERROR!!!");
		}
	}
	
}
