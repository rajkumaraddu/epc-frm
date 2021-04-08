/**
 * 
 */
package com.mahindra.epcfrm.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author Raju.Addu
 *
 */
@Component
public class AuthResponseDto implements Serializable {

	private static final long serialVersionUID = -49941543166431002L;
	
	private String message;
	private int statusCode;
	private String authToken;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

}
