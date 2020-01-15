package com.sample.dashboard.dao;

import java.util.List;

import com.sample.dashboard.model.UserDetails;

public interface UserDao {
	
	List<UserDetails> getUserDetails();
	UserDetails findUserById(String userId);

}
