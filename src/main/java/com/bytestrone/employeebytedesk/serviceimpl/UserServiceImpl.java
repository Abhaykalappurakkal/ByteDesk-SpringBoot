package com.bytestrone.employeebytedesk.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytestrone.employeebytedesk.model.UserModel;
import com.bytestrone.employeebytedesk.repository.UserRepo;
import com.bytestrone.employeebytedesk.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;

	@Override
	public UserModel findLoginUser(UserModel userData) {
		UserModel user = repo.findByUserId(userData.getUserId());
		if (user.getPassword().equals(userData.getPassword())) {

			return user;

		}
		return null;
	}
}
