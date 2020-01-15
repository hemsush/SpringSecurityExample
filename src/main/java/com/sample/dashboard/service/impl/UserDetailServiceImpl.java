package com.sample.dashboard.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sample.dashboard.dao.UserDao;
import com.sample.dashboard.service.UserService;

@Component(value = "userDetailService")
public class UserDetailServiceImpl implements UserDetailsService, UserService{
	
	@Autowired
	private UserDao userDao;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.isl.soc.dashboard.model.UserDetails user = userDao.findUserById(username);
		System.out.println("Inside spring sec");
		System.out.println("User name"+user.getUsername());
		System.out.println("User name"+user.getPassword());
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	public List<com.sample.dashboard.model.UserDetails> getUsers() {
		return userDao.getUserDetails();
	}

}
