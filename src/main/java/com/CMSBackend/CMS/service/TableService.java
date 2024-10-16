package com.CMSBackend.CMS.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
		if(tableName.isEmpty() || tableName.isBlank()) {
			return new ResultDto(true, 500, "The table name is not to be empty.");
		}
		else {
			try {
				Table searchTable = tableRepository.findByName(tableName.toLowerCase());
				if(searchTable != null) {
					return new ResultDto(true, 500, "The table name is existing");
				}
				Table table = new Table();
					table.setTableName(tableName);
				
				tableRepository.save(table);
				return new ResultDto(true, 200, "Table Added Successfully");
			} catch (Exception e) {
				
				return new ResultDto(true, 500, "ERROR!!!");
				// TODO: handle exception
			}
		}
	}
	
	public ResultDto GetAllTableWithPrice() {
		try {
			List<Object[]> tableObjects = tableRepository.getTablesWithTotalPrice();
			if (tableObjects.isEmpty()) {
                return new ResultDto(true, 404, "No tables found.");
            }
			List<Table> tables = new ArrayList<>();
			for(Object[] obj : tableObjects) {
				Long tableId = ((Long) obj[0]).longValue();
				Double totalPrice = (Double) obj[2];
				
				Table table = tableRepository.findById(tableId).orElse(null);
				
				if(table!=null) {
					table.setPrice(totalPrice);
					tables.add(table);
				}
			}
			
            
            return new ResultDto(tables, 200, "Tables retrieved successfully.");
		} catch (Exception e) {
            return new ResultDto(true, 500, "An error occurred while retrieving tables.");
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
