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
@Table(name = "UserMaster")
public class UserMasterEntity extends BaseEntity {

	private static final long serialVersionUID = -1308829696476384399L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 50)
	private String userId;
	@Column(length = 50)
	private String password;
	private LocalDateTime pwdValidity;
	@Column(length = 50)
	private String tokenNo;
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
	@Column(length = 20)
	private String roleId;
	@Column(length = 20)
	private String stateClusterId;
	@Column(length = 20)
	private String regionId;
	@Column(length = 1)
	private String activeStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
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

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getStateClusterId() {
		return stateClusterId;
	}

	public void setStateClusterId(String stateClusterId) {
		this.stateClusterId = stateClusterId;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getPwdValidity() {
		return pwdValidity;
	}

	public void setPwdValidity(LocalDateTime pwdValidity) {
		this.pwdValidity = pwdValidity;
	}

}
