package com.mahindra.epcfrm.entity;

import java.time.LocalDate;

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
@Table(name = "SiteSurveyMaster")
public class SiteSurveyMasterEntity extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8899791286917795718L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int leadId;
	
	@Column(length = 500)
	private String address1;
	
	@Column(length = 500)
	private String address2;
	
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
	
	@Column(length = 50)
	private String crop;
	
	private double areaHa; // in case type of address is Farm;
	private double subsidyPer;
	private double amount;
	
	@Column(length = 50)
	private String iniQuotAttachment;
	@Column(length = 50)
	private String misProduct;
	@Column(length = 50)
	private String enquiryType;
	private LocalDate visitDate;
	
	//extra from excel 
	private LocalDate estiMonthPur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getCrop() {
		return crop;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public double getAreaHa() {
		return areaHa;
	}

	public void setAreaHa(double areaHa) {
		this.areaHa = areaHa;
	}

	public double getSubsidyPer() {
		return subsidyPer;
	}

	public void setSubsidyPer(double subsidyPer) {
		this.subsidyPer = subsidyPer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getIniQuotAttachment() {
		return iniQuotAttachment;
	}

	public void setIniQuotAttachment(String iniQuotAttachment) {
		this.iniQuotAttachment = iniQuotAttachment;
	}

	public String getMisProduct() {
		return misProduct;
	}

	public void setMisProduct(String misProduct) {
		this.misProduct = misProduct;
	}

	public String getEnquiryType() {
		return enquiryType;
	}

	public void setEnquiryType(String enquiryType) {
		this.enquiryType = enquiryType;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public LocalDate getEstiMonthPur() {
		return estiMonthPur;
	}

	public void setEstiMonthPur(LocalDate estiMonthPur) {
		this.estiMonthPur = estiMonthPur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

}
