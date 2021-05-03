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
@Table(name = "AddressMaster")
public class AddressMasterEntity extends BaseEntity {

	private static final long serialVersionUID = 2319071113576390757L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	/*
	 * @Column(length = 50) private String addressNo;
	 * 
	 * @Column(length = 20) private String addressType;
	 * 
	 * @Column(length = 50) private String customerNo;
	 */
	@Column(length = 500)
	private String addressLine1;
	@Column(length = 500)
	private String addressLine2;
	@Column(length = 100)
	private String village;
	@Column(length = 100)
	private String taluka;
	@Column(length = 100)
	private String dist;
	@Column(length = 100)
	private String city;
	@Column(length = 50)
	private String state;
	@Column(length = 6)
	private int pinCode;
	private double area_Ha; // in case type of address is Farm;
	/*
	 * @Column(length = 1) private String activeStatus;
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTaluka() {
		return taluka;
	}

	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getArea_Ha() {
		return area_Ha;
	}

	public void setArea_Ha(double area_Ha) {
		this.area_Ha = area_Ha;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}


}
