package com.CMSBackend.CMS.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CMSBackend.CMS.model.User;
import com.CMSBackend.CMS.respository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Bean
	PasswordEncoder getEncoder() {
	    return new BCryptPasswordEncoder();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User currentUser = userRepository.findByUsername(username);
	        UserDetails user
	                = new org.springframework.security.core.userdetails.User(
	                    username,
	                    currentUser.getPassword(),
	                    currentUser.isEnabled(),
	                    true,
	                    true,
	                    true,

	                    AuthorityUtils.createAuthorityList(currentUser.getRole()));
	        return user;
	}
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}
	
	public User saveUser(User user,String Role) {

		user.setPassword(getEncoder().encode(user.getPassword()));

		user.setRole(Role);
		    user.setEnabled(true);
		     User u=userRepository.save(user);


		return u;
		/*
		if (user.getId()==-1) {
			user.setPassword(getEncoder().encode(user.getPassword()));
			user.setRole("USER");
		}
		else if (user.getUpdatePassword()!=null&&user.getUpdatePassword()) {
			user.setPassword(getEncoder().encode(user.getPassword()));
		}
		return userRepository.save(user);"
		*/
	}
	public void deleteById(long id) {
		userRepository.deleteById(id);

	}

	public User getUser(String username) {

		return userRepository.findByUsername(username);
	}

	
	public Iterable<User> getAllUsers() {

		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Long userId) {

		return userRepository.findById(userId);
	}

	public User getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username = principal.toString();
	     return userRepository.findByUsername(username);
	}

}
