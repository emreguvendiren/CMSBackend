package com.CMSBackend.CMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class Table extends BaseEntity {
	
	private String TableName;

	@Transient
	private double price;
	public String getTableName() {
		return TableName;
	}

	public void setTableName(String tableName) {
		TableName = tableName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
