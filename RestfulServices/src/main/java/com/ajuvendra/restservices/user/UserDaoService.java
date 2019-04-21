package com.ajuvendra.restservices.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<UserBean> users = new ArrayList<>(
			Arrays.asList
			(new UserBean(1, "Ajuvendra Kumar", new Date()),
			new UserBean(2, "Nisha Sangeeta", new Date()),
			new UserBean(3, "Mohan Babu", new Date())
			));
	
	private static int userCount = 3;
	
	public List<UserBean> findAll() {
		return users;
	}
	
	public UserBean save(UserBean user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public UserBean findOne(int id) {
		for (UserBean userBean : users) {
			if(userBean.getId() == id) {
				return userBean;
			}
		}
		return null;
	}
	
	public UserBean deleteById(int id) {
		Iterator<UserBean> iter = users.iterator();
		while(iter.hasNext()) {
			UserBean user = iter.next();
			if(user.getId() == id) {
				iter.remove();
				return user;
			}
		}
		return null;
	}

}
