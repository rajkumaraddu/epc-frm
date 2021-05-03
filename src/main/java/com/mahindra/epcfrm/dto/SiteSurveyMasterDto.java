package com.mahindra.epcfrm.dto;

import java.time.LocalDate;

/**
 * @author Birla.Manoj
 *
 */

public class SiteSurveyMasterDto {

	private int leadId;
	private String address1;
	private String address2;
	private String village;
	private String taluka;
	private String dist;
	private String city;
	private String state;
	private int pinCode;
	private String crop;
	private double areaHa; // in case type of address is Farm;
	private double subsidyPer;
	private double amount;
	private String iniQuotAttachment;
	private String misProduct;
	private String enquiryType;
	private LocalDate visitDate;
	// extra from excel
	private LocalDate estiMonthPur;

	
	
	
	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
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

}
