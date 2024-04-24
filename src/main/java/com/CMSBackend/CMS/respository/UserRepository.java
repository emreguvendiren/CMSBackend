package com.CMSBackend.CMS.respository;

import org.springframework.data.repository.CrudRepository;

import com.CMSBackend.CMS.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
