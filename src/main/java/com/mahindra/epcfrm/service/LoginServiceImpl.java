/**
 * 
 */
package com.mahindra.epcfrm.service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindra.epcfrm.dto.ApiResponseDto;
import com.mahindra.epcfrm.entity.UserMasterEntity;
import com.mahindra.epcfrm.repository.UserMasterRepo;

/**
 * @author Raju.Addu
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private SMSService smsService;
	@Autowired
	private UserMasterRepo userRepo;

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	private static Random random = new Random();
	public static final int otpValiditySecs = 120;

	@Override
	public ApiResponseDto getOtp(String mobile) {
		long curMillis = System.currentTimeMillis();
		logger.info("inside getOtp() for mobile: " + mobile);
		if (mobile == null || mobile.isEmpty()) {
			logger.info("Empty mobile provided, returning..");
			return new ApiResponseDto("fail", 1, mobile, null, "Provide mandatory fields");
		}
		String status = "";
		int statusCode;
		String message = "";
		String otpValidity = "";
		String otp = "";
		int mobLen = 0;

		if (mobile != null && !mobile.isEmpty()) {
			logger.info("Generating OTP and sending to Mobile No. " + mobile);
			mobLen = mobile.length();

			if (mobLen != 10) {
				ApiResponseDto responseDto = new ApiResponseDto("fail", 1, "", mobile, "", "",
						"Please enter 10-digits mobile number.");
				logger.info("Returing resonse: " + responseDto);
				return responseDto;
			}

			UserMasterEntity user = userRepo.findByMobile(mobile);
			if (user == null) {
				ApiResponseDto responseDto = new ApiResponseDto("no-user", 1, "",
						"XXXX" + mobile.substring(mobLen - 3, mobLen), "", "", "User not available.");
				logger.info("Returing resonse: " + responseDto);
				return responseDto;
			}

			try {
				otp = "" + (10000 + random.nextInt(90000));
				logger.info("Generated OTP: " + otp);
				otpValidity = LocalDateTime.now().plusSeconds(otpValiditySecs).toString();

				String sms = otp + " is the OTP to reset your Mahindra login id password, valid till " + otpValidity;
				try {
					if (!updateUserOTP(mobile, otp, otpValidity)) {
						ApiResponseDto responseDto = new ApiResponseDto("db-issue", 1, "",
								"XXXX" + mobile.substring(mobLen - 3, mobLen), "", "", "Please try after sometime.");
						logger.info("Returing resonse: " + responseDto);
						return responseDto;
					}
					if (smsService.sendSMS(mobile, sms)) {
						logger.info("OTP sent successfully to Mobile No. " + mobile + ", with SMS text: " + sms);
						status = "success";
						statusCode = 0;
						message = "OTP is sent to Mobile No. ending with XXXX" + mobile.substring(mobLen - 3, mobLen);
						// updateUserOTP(mobile, otp, otpValidity);
					} else {
						logger.info("Failed to send OTP on Mobile No. " + mobile + ", with SMS text: " + sms);
						status = "fail";
						statusCode = 1;
						message = "Failed to sent OTP to Mobile No. ending with XXXX"
								+ mobile.substring(mobLen - 3, mobLen);
					}
				} catch (Exception e) {
					logger.error("Exception in SMSService.sendSms(), details: " + e.getMessage() + ", trace: ", e);
					status = "fail";
					statusCode = 1;
					message = "Failed to sent OTP to Mobile No. ending with XXXX"
							+ mobile.substring(mobLen - 3, mobLen);
				}
			} catch (Exception e) {
				logger.error("Exception while sending opt to mobile \"" + mobile + "\", details: " + e.getMessage()
						+ ", trace: ", e);
				status = "fail";
				statusCode = 1;
				message = "Failed to sent OTP to Mobile No. ending with XXXX" + mobile.substring(mobLen - 3, mobLen);
			}
		} else {
			logger.info("Mobile No. is not registered with EPC. " + mobile);
			status = "fail";
			statusCode = 1;
			message = "Mobile No. is not registered with EPC.";
		}
		if (mobile.isEmpty()) {
			mobile = "XXXX";
			mobLen = 3;
		}
		ApiResponseDto responseDto = new ApiResponseDto(status, statusCode, mobile,
				"XXXX" + mobile.substring(mobLen - 3, mobLen), otp, otpValidity, message);
		logger.info("Returing resonse: " + responseDto);
		logger.info("Time taken by sendOtp() including getEmpDetailsByTokenId() and SMSService calls in millis: "
				+ (System.currentTimeMillis() - curMillis));
		return responseDto;
	}

	/**
	 * @param mobile
	 * @param otp
	 * @param otpValidity
	 */
	private boolean updateUserOTP(String mobile, String otp, String otpValidity) {
		try {
			UserMasterEntity user = userRepo.findByMobile(mobile);
			if (user != null) {
				user.setPassword(otp);
				user.setPwdValidity(LocalDateTime.parse(otpValidity));
				userRepo.save(user);
				return true;
			}
		} catch (Exception e) {
			logger.info("exception in updateUserOTP");
			return false;
		}
		return true;
	}

	public static Date getValidity(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, otpValiditySecs);
		return calendar.getTime();
	}

}
