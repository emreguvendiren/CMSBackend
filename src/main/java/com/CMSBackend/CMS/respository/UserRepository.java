package com.CMSBackend.CMS.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.CMSBackend.CMS.model.User;

public interface UserRepository extends CrudRepository<User,Long>{

	@Query("SELECT p FROM User p WHERE p.Username = :userName")
	User findByUserName(String userName);
	
	
}
