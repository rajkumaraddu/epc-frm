/**
 * 
 */
package com.mahindra.epcfrm.entity;

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
@Table(name = "CustomerMaster")
public class CustomerMasterEntity extends BaseEntity {

	private static final long serialVersionUID = 5686625583496930432L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 50)
	private String customerId;
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String middleName;
	@Column(length = 50)
	private String lastName;
	@Column(length = 150)
	private String fullName;
	
	@Column(length = 150)
	private String emailId;
	
	@Column(length = 150)
	private String fatherName;
	
	@Column(length = 150)
	private String motherName;
	
	
	@Column(length = 150)
	private String asm;
	
	@Column(length = 150)
	private String dealerName;
	
	@Column(length = 150)
	private String dealerCode;
	
	
	@Column(length = 20)
	private Long contactNumber;
	
	@Column(length = 50)
	private String corrAddressNo; // correspondenceAddressNo
	@Column(length = 50)
	private String farmAddressNo;
	@Column(length = 50)
	private String sapFarmerCode;//sapFarmerCode
	@Column(length = 1)
	private String activeStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCorrAddressNo() {
		return corrAddressNo;
	}

	public void setCorrAddressNo(String corrAddressNo) {
		this.corrAddressNo = corrAddressNo;
	}

	public String getFarmAddressNo() {
		return farmAddressNo;
	}

	public void setFarmAddressNo(String farmAddressNo) {
		this.farmAddressNo = farmAddressNo;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public String getAsm() {
		return asm;
	}

	public void setAsm(String asm) {
		this.asm = asm;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
