package com.CMSBackend.CMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CMSBackend.CMS.dto.ResultDto;
import com.CMSBackend.CMS.model.User;
import com.CMSBackend.CMS.respository.UserRepository;

@Service
public class TestService {

	@Autowired
	private UserRepository userRepository;
	
	public ResultDto createUser(String Username,String Password) {
		try {
			User user = new User();
			user.setUserName(Username);
			user.setPassword(Password);
			userRepository.save(user);
			return new ResultDto(true, 200, "Kayit Basarili");
		} catch (Exception e) {
			return new ResultDto(false, 500, "Kayit yapilirken hata olustu");
		}
		
		
	}
}
