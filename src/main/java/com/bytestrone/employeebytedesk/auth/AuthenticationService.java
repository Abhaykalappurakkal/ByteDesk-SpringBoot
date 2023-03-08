package com.bytestrone.employeebytedesk.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytestrone.employeebytedesk.config.JwtService;
import com.bytestrone.employeebytedesk.model.UserModel;
import com.bytestrone.employeebytedesk.repository.UserRepo;

@Service
public class AuthenticationService {

	@Autowired
	private UserRepo repo;

	@Autowired
	private JwtService jwtService;

	public String loginId;

	public AuthenticationResponse verifyUser(AuthenticationRequest request) {

		UserModel user = repo.findByUserName(request.getUserName()).orElseThrow();
		if (user.getPassword().equals(request.getPassword())) {
			String jwtToken = jwtService.generateToken(user);
			String userName = user.getUserName();
			String userId = user.getUserId();
			String salutation = user.getSalutation();
			String userCode = user.getUserCode();

			UserModel loginUser = new UserModel();
			loginUser = repo.findByUserId(userId);
			loginUser.setJwtToken(jwtToken);
			repo.save(loginUser);
			AuthenticationResponse response1 = new AuthenticationResponse();
			response1.setToken(jwtToken);
			response1.setUserName(userName);
			response1.setUserId(userId);
			response1.setSalutation(salutation);
			response1.setUserCode(userCode);
			return response1;

		} else
			return null;

	}
}
