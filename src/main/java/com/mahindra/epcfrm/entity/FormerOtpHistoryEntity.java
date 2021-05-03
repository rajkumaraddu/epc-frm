/**
 * 
 */
package com.mahindra.epcfrm.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Raju.Addu
 *
 */
@Entity
@Table(name = "FormerOtpHistory")
public class FormerOtpHistoryEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5639452033172767036L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int leadId;
	@Column(length = 20)
	private String formarMobileNo;
	@Column(length = 5)
	private String otp;
	@Column(length = 20)
	private String otpType; // delivery or installation
	private LocalDateTime validity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

	public String getFormarMobileNo() {
		return formarMobileNo;
	}

	public void setFormarMobileNo(String formarMobileNo) {
		this.formarMobileNo = formarMobileNo;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getOtyType() {
		return otpType;
	}

	public void setOtyType(String otpType) {
		this.otpType = otpType;
	}

	public LocalDateTime getValidity() {
		return validity;
	}

	public void setValidity(LocalDateTime validity) {
		this.validity = validity;
	}

}
