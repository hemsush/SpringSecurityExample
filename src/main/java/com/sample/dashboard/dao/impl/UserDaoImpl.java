package com.sample.dashboard.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.dashboard.dao.UserDao;
import com.sample.dashboard.model.UserDetails;

@Component
public class UserDaoImpl implements UserDao {

		@Autowired
	private SessionFactory sessionFactory;

	public List<UserDetails> getUserDetails() {
		Criteria criteria = sessionFactory.openSession().createCriteria(UserDetails.class);
		return criteria.list();
	}

	public UserDetails findUserById(String userId) {
		UserDetails userDetails = null;
		Criteria criteria = sessionFactory.openSession().createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("username", userId));
		List<UserDetails> entityList = criteria.list();
		if(!entityList.isEmpty()) {
			userDetails = entityList.get(0);
		}
		return userDetails;
	}

}
