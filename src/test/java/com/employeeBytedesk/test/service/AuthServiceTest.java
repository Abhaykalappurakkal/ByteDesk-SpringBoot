package com.employeeBytedesk.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.bytestrone.employeebytedesk.auth.AuthenticationRequest;
import com.bytestrone.employeebytedesk.auth.AuthenticationResponse;
import com.bytestrone.employeebytedesk.auth.AuthenticationService;
import com.bytestrone.employeebytedesk.config.JwtService;
import com.bytestrone.employeebytedesk.model.UserModel;
import com.bytestrone.employeebytedesk.repository.UserRepo;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ContextConfiguration(classes = AuthenticationService.class)
public class AuthServiceTest {
	
	@Autowired
	private AuthenticationService authService;
	
	@MockBean
	private JwtService jwtService;
	
	@MockBean
	private UserRepo repo;
	
	@Test
	@DisplayName("test success case")
	void testAuthRequest() {
		String userName = "testUser";
		String password = "testPassword";
		UserModel user = new UserModel();
		user.setUserName(userName);
		user.setPassword(password);
		user.setSalutation("Mr.");
		user.setDepartment("testDept");
		user.setUserCode("testCode");
		user.setUserId("testId100");
		user.setJwtToken("testToken");
		
		when(repo.findByUserName(userName)).thenReturn(Optional.of(user));
		when(jwtService.generateToken(user)).thenReturn("testToken");
		
		AuthenticationRequest request = new AuthenticationRequest();
		request.setUserName(userName);
		request.setPassword(password);
		when(repo.findByUserId(user.getUserId())).thenReturn(user);
		AuthenticationResponse response = authService.verifyUser(request);
		
		assertEquals("testToken", response.getToken());
		assertEquals("testUser", response.getUserName());
		assertEquals("testCode", response.getUserCode());
		assertEquals("Mr.", response.getSalutation());
		verify(repo,times(1)).findByUserName(userName);
		verify(jwtService,times(1)).generateToken(user);
	}
	
	@Test
	@DisplayName("test authentication failure")
	void testAuthFailure() {
		String userName = "testUser";
		String password = "testPassword";
		UserModel user = new UserModel();
		user.setUserName(userName);
		user.setPassword(password);
		user.setSalutation("Mr.");
		user.setDepartment("testDept");
		user.setUserCode("testCode");
		user.setUserId("testId100");
		user.setJwtToken("testToken");
		
		when(repo.findByUserName(userName)).thenReturn(Optional.of(user));
		when(jwtService.generateToken(user)).thenReturn("testToken");
		
		AuthenticationRequest request = new AuthenticationRequest();
		request.setUserName(userName);
		request.setPassword(password);
		when(repo.findByUserId(user.getUserId())).thenReturn(user);
//		AuthenticationResponse response = authService.verifyUser(null);
		verify(repo,times(0)).findByUserName(userName);
		verify(jwtService,times(0)).generateToken(user);
		
	}

}
