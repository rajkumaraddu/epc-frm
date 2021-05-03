package com.mahindra.epcfrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Birla.Manoj
 *
 */
@Entity
@Table(name = "FarmerMaster")
public class FarmerMasterEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3363616312800418064L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 50)
	private String sal;
	
	@Column(length = 50)
	private String firstName;
	
	@Column(length = 50)
	private String lastName;
	
	@Column(length = 20)
	private Long faMobile;
	
	@Column(length = 150)
	private String emailId;
	
	@Column(length = 150)
	private String fatherName;
	
	@Column(length = 150)
	private String motherName;
	
	
	@Column(length = 150)
	private String asmName;
	
	@Column(length = 150)
	private String dealerName;
	
	@Column(length = 150)
	private String dealerCode;
	
	@Column(length = 50)
	private String sapFarmerCode;//sapFarmerCode
	
	@Column(length = 50)
	private String statusOnlinePortal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getFaMobile() {
		return faMobile;
	}

	public void setFaMobile(Long faMobile) {
		this.faMobile = faMobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAsmName() {
		return asmName;
	}

	public void setAsmName(String asmName) {
		this.asmName = asmName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getSapFarmerCode() {
		return sapFarmerCode;
	}

	public void setSapFarmerCode(String sapFarmerCode) {
		this.sapFarmerCode = sapFarmerCode;
	}

	public String getStatusOnlinePortal() {
		return statusOnlinePortal;
	}

	public void setStatusOnlinePortal(String statusOnlinePortal) {
		this.statusOnlinePortal = statusOnlinePortal;
	}
	
}
