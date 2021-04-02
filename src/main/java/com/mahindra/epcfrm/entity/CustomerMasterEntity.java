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
	private String customerNo;
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String middleName;
	@Column(length = 50)
	private String lastName;
	@Column(length = 150)
	private String fullName;
	@Column(length = 100)
	private String email;
	@Column(length = 20)
	private String mobile;
	@Column(length = 50)
	private String fathersName;
	@Column(length = 50)
	private String mothersName;
	@Column(length = 50)
	private String asm;
	@Column(length = 50)
	private String dealer;
	@Column(length = 50)
	private String corrAddressNo; // correspondenceAddressNo
	@Column(length = 50)
	private String farmAddressNo;
	@Column(length = 50)
	private String sapFarmerCode;
	@Column(length = 1)
	private String activeStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
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

}
