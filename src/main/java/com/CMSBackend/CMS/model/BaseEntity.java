package com.CMSBackend.CMS.model;


import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public Date createDate;
	public String createrUser;
	
	public BaseEntity() {
		setCreateDate(new Date());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreaterUser() {
		return createrUser;
	}
	public void setCreaterUser(String createrUser) {
		this.createrUser = createrUser;
	}
	
	
}
