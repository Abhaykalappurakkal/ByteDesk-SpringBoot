package com.bytestrone.employeebytedesk.auth;

public class AuthenticationResponse {

	private String token;
	private String userName;
	private String userId;
	private String salutation;
	private String userCode;

	public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(String token, String userName, String userId, String salutation, String userCode,
			Boolean isUserLogin) {
		super();
		this.token = token;
		this.userName = userName;
		this.userId = userId;
		this.salutation = salutation;
		this.userCode = userCode;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
