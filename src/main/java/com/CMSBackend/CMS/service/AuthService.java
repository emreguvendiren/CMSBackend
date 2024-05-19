package com.CMSBackend.CMS.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CMSBackend.CMS.dto.ReqRes;
import com.CMSBackend.CMS.dto.ResultDto;
import com.CMSBackend.CMS.model.User;
import com.CMSBackend.CMS.respository.UserRepository;

@Service
public class AuthService {
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private JWTUtils jwtUtils;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	public ResultDto update(ReqRes reqRes) {
		ResultDto resp;
		try {
			User user = repository.findByUserName(reqRes.getUsername());

			if(!reqRes.getPassword().equalsIgnoreCase("")){
				user.setPassword(encoder.encode(reqRes.getPassword()));
			}
			user.setRole(reqRes.getRole());
			repository.save(user);
			return new ResultDto(user, 200, "Guncelleme Basarili");
		} catch (Exception e) {
			return new ResultDto(false, 500, "Guncelleme Basarisiz");

		}
	}

	public ResultDto delete(ReqRes reqRes) {
		ResultDto resp;
		try {
			User user = repository.findByUserName(reqRes.getUsername());
			if(user!= null){
				repository.delete(user);
			}
			else{
				return new ResultDto(false, 500, "Kullanici bulunamadi");

			}
			repository.save(user);
			return new ResultDto(user, 200, "Silme Islemi Basarili");
		} catch (Exception e) {
			return new ResultDto(false, 500, "Silme Islemi Basarisiz");

		}
	}

	public ResultDto signUp(ReqRes reqRes) {
		ResultDto resp;
		try {
			User user = new User();
			user.setUserName(reqRes.getUsername());
			user.setPassword(encoder.encode(reqRes.getPassword()));
			user.setRole(reqRes.getRole());
			repository.save(user);
			return new ResultDto(user, 200, "Kayit Basarili");
		} catch (Exception e) {
			return new ResultDto(false, 500, "Kayit Basarisiz");

		}
	}
	
	public ResultDto signIn(ReqRes reqRes) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reqRes.getUsername(), reqRes.getPassword()));
			var user = repository.findByUserName(reqRes.getUsername());
			if(user == null) {
				return new ResultDto(false, 400, "Kullanici Adi Bulunamadi");
			}
			else {
				var jwt = jwtUtils.generateToken(user);
				var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
				ResultDto dto = new ResultDto(jwt, 200, "Giris Basarili");
					dto.setAlternativeResult(user.getRole());
				return dto;
						
			}
		} catch (Exception e) {
			return new ResultDto(false, 500, "Kullanıcı adı veya şifre yanlış.");
		}
	}
	
	public ResultDto refreshToken(ReqRes reqRes) {
		ReqRes response = new ReqRes();
		String username = jwtUtils.extractUsername(reqRes.getToken());
		User user = repository.findByUserName(username);
		if(jwtUtils.isTokenValid(reqRes.getToken(),user)) {
			var jwt = jwtUtils.generateToken(user);
			return new ResultDto(jwt, 200, "Basarili");

		}
		else {
			return new ResultDto(false, 500, "Basarisiz");

		}
	
	}
}
