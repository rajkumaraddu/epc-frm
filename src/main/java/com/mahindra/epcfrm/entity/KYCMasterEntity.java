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
@Table(name = "KycMaster")
public class KYCMasterEntity extends BaseEntity{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5795551699030996866L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 50)
	private String kycNo;

	@Column(length = 100)
	private String farmerPhoto;
	@Column(length = 100)
	private String waterTestDoc;
	@Column(length = 100)
	private String soilTestDoc;
	@Column(length = 100)
	private String bankDoc;
	@Column(length = 100)
	private String aadharCard;
	@Column(length = 100)
	private String rationCard;
	@Column(length = 100)
	private String patta;
	@Column(length = 100)
	private String chitta;
	@Column(length = 100)
	private String surveyCaptureImage;
	@Column(length = 100)
	private String gpsCaptureImage;
	@Column(length = 100)
	private String otherDoc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKycNo() {
		return kycNo;
	}
	public void setKycNo(String kycNo) {
		this.kycNo = kycNo;
	}
	public String getFarmerPhoto() {
		return farmerPhoto;
	}
	public void setFarmerPhoto(String farmerPhoto) {
		this.farmerPhoto = farmerPhoto;
	}
	public String getWaterTestDoc() {
		return waterTestDoc;
	}
	public void setWaterTestDoc(String waterTestDoc) {
		this.waterTestDoc = waterTestDoc;
	}
	public String getSoilTestDoc() {
		return soilTestDoc;
	}
	public void setSoilTestDoc(String soilTestDoc) {
		this.soilTestDoc = soilTestDoc;
	}
	public String getBankDoc() {
		return bankDoc;
	}
	public void setBankDoc(String bankDoc) {
		this.bankDoc = bankDoc;
	}
	public String getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}
	public String getRationCard() {
		return rationCard;
	}
	public void setRationCard(String rationCard) {
		this.rationCard = rationCard;
	}
	public String getPatta() {
		return patta;
	}
	public void setPatta(String patta) {
		this.patta = patta;
	}
	public String getChitta() {
		return chitta;
	}
	public void setChitta(String chitta) {
		this.chitta = chitta;
	}
	public String getSurveyCaptureImage() {
		return surveyCaptureImage;
	}
	public void setSurveyCaptureImage(String surveyCaptureImage) {
		this.surveyCaptureImage = surveyCaptureImage;
	}
	public String getGpsCaptureImage() {
		return gpsCaptureImage;
	}
	public void setGpsCaptureImage(String gpsCaptureImage) {
		this.gpsCaptureImage = gpsCaptureImage;
	}
	public String getOtherDoc() {
		return otherDoc;
	}
	public void setOtherDoc(String otherDoc) {
		this.otherDoc = otherDoc;
	}
	
	

}
