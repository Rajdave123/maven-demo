package com.phoenix.services;

import java.util.List;

import com.phoenix.data.User;
import com.phoenix.exceptions.ServiceException;
import com.phoenix.exceptions.UserAlreadyExistException;
import com.phoenix.exceptions.UserNotFoundException;

public interface LoginService {

	List<User> findAll() throws ServiceException;

	User findById(String username) throws UserNotFoundException;

	void add(User user) throws UserAlreadyExistException;

	void edit(User user) throws ServiceException;

	void remove(User user) throws ServiceException;

	public String changePassWord(User user) throws ServiceException;
}