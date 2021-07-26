package com.phoenix.daos;

import java.util.List;

import com.phoenix.data.User;


/*
 * @author: raj.dave
 *  version: 2.0

 * */
public interface LoginDao {

	List<User> getAll();

	User getUserById(String username);

	void insert(User user);

	void update(User uesr);

	void delete(User user);
}
