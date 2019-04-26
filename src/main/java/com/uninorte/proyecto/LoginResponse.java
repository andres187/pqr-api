/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uninorte.proyecto;

/**
 *
 * @author Marbel
 */
public class LoginResponse {
    public static final String OK="ok";
	
	public static final String INVALID_USERNAME="invaliduser";

	public static final String INVALID_CREDENTIALS = "invalidCredentials";
	
	public static final String USER_INACTIVE = "userInactive";
	
	private int userId;
	
	private String status;
	
	private String errorMessage;
	
	private String token;
	
	private String username;
	
	private boolean admin;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUsername(String nombre) {
		this.username=nombre;
	}

	public String getUsername() {
		return username;
	}

	
	
	
}
