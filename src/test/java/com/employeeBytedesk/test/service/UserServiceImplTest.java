package com.employeeBytedesk.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bytestrone.employeebytedesk.model.UserModel;
import com.bytestrone.employeebytedesk.repository.UserRepo;
import com.bytestrone.employeebytedesk.service.UserService;
import com.bytestrone.employeebytedesk.serviceimpl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = UserServiceImpl.class)
class UserServiceImplTest {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepo userRepo;

	@Test
	@DisplayName("Test login user success")
	void tastLoginUser() {
		UserModel user = new UserModel();
		user.setUserId("abc");
		user.setPassword("pass");
		when(userRepo.findByUserId("abc")).thenReturn(user);
		UserModel user1 = userService.findLoginUser(user);
		assertEquals(user1, user);
		verify(userRepo, times(1)).findByUserId("abc");
	}

}
