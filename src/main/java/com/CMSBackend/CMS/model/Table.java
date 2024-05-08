package com.CMSBackend.CMS.model;

import jakarta.persistence.Entity;

@Entity
public class Table extends BaseEntity {
	
	private String TableName;

	public String getTableName() {
		return TableName;
	}

	public void setTableName(String tableName) {
		TableName = tableName;
	}
	
	
}
