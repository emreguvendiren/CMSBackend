package com.CMSBackend.CMS.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.CMSBackend.CMS.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	@Query("SELECT p FROM User p WHERE  p.userName= ?1")
	public List<User> findUserByName(String UserName);
	
	

	
}
