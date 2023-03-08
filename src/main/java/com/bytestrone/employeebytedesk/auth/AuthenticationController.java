package com.bytestrone.employeebytedesk.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/sec/user")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authService;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest request) {
		AuthenticationResponse user = authService.verifyUser(request);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return (ResponseEntity<AuthenticationResponse>) ResponseEntity.internalServerError();
	}

}
