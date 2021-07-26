package com.phoenix.services;

import java.util.List;

import com.phoenix.daos.LoginDao;
import com.phoenix.daos.LoginDaoImpl;
import com.phoenix.data.User;
import com.phoenix.exceptions.ServiceException;
import com.phoenix.exceptions.UserAlreadyExistException;
import com.phoenix.exceptions.UserNotFoundException;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;

	public LoginServiceImpl() {
		loginDao = new LoginDaoImpl();
	}

	@Override
	public List<User> findAll() throws ServiceException {
		return loginDao.getAll();
	}

	@Override
	public User findById(String username) throws UserNotFoundException {
		User user = loginDao.getUserById(username);
		if (user != null)
			return user;
		else
			throw new UserNotFoundException("Sorry! user foes not exist..");
	}

	@Override
	public void add(User user) throws UserAlreadyExistException {
		loginDao.insert(user);

	}

	@Override
	public void edit(User user) throws ServiceException {
		loginDao.update(user);
	}

	@Override
	public void remove(User user) throws ServiceException {
		loginDao.delete(user);
	}

	@Override
	public String changePassWord(User user) throws ServiceException {
		loginDao.update(user);
		return "Password Changed Successfully";
	}

}
