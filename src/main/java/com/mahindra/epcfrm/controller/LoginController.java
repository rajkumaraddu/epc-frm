/**
 * 
 */
package com.mahindra.epcfrm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mahindra.epcfrm.dto.ApiResponseDto;
import com.mahindra.epcfrm.dto.AuthRequestDto;
import com.mahindra.epcfrm.dto.AuthResponseDto;
import com.mahindra.epcfrm.service.LoginService;
import com.mahindra.epcfrm.util.JwtUtil;

/**
 * @author Raju.Addu
 *
 */
@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private LoginService loginService;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/get_otp")
	public ResponseEntity<ApiResponseDto> getOtp(@RequestParam String mobile) {
		logger.info("inside /get_otp controller, mobile: " + mobile);
		return ResponseEntity.ok(loginService.getOtp(mobile));
	}

	@PostMapping("/login")
	public AuthResponseDto generateToken(@RequestBody AuthRequestDto authRequest) throws Exception {
		AuthResponseDto authResponse = new AuthResponseDto();
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			// throw new Exception("Inavalid username/OTP");
			authResponse.setStatusCode(1);
			authResponse.setMessage("Inavalid user/OTP");
			authResponse.setAuthToken(null);
			return authResponse;
		}
		String jwtToken = jwtUtil.generateToken(authRequest.getUserName());
		authResponse.setStatusCode(0);
		authResponse.setMessage("success");
		authResponse.setAuthToken(jwtToken);
		return authResponse;

	}

}
