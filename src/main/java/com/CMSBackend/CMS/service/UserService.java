package com.CMSBackend.CMS.service;

import java.util.ArrayList;
import java.util.List;

import com.CMSBackend.CMS.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CMSBackend.CMS.model.User;
import com.CMSBackend.CMS.respository.UserRepository;

@Service
public class UserService {


	@Autowired
	private UserRepository userRepository;
	
	public Iterable<User> getAllUser(){
		Iterable<User> users = userRepository.findAll();

		return users;
	}
}
