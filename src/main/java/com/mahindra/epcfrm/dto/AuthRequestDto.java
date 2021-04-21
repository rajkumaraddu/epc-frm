/**
 * 
 */
package com.mahindra.epcfrm.dto;

import org.springframework.stereotype.Component;

/**
 * @author Raju.Addu
 *
 */

@Component
public class AuthRequestDto {

	private String userName; //mobile number.
	private String password; //OTP

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
