package com.mahindra.epcfrm.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 */

/**
 * @author Raju.Addu
 *
 */
@Entity
@Table(name = "EpcDealerMaster")
public class EpcDealerMasterEntity extends BaseEntity {

	private static final long serialVersionUID = -2247867865648303593L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 50)
	private String dealerCode;
	@Column(length = 50)
	private String asmCode;
	@Column(length = 50)
	private String asmName;
	@Column(length = 100)
	private String firstName;
	@Column(length = 100)
	private String lastName;
	@Column(length = 100)
	private String email;
	@Column(length = 20)
	private String mobile;
	@Column(length = 20)
	private String employeeType;
	@Column(length = 1)
	private String activeStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getAsmCode() {
		return asmCode;
	}

	public void setAsmCode(String asmCode) {
		this.asmCode = asmCode;
	}

	public String getAsmName() {
		return asmName;
	}

	public void setAsmName(String asmName) {
		this.asmName = asmName;
	}

}
