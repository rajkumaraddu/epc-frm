package com.mahindra.epcfrm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Birla.Manoj
 *
 */
@Entity
@Table(name = "MaterialInstallationMaster")
public class MaterialInstallationMasterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int leadId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "InstReportPhotosId")
	private List<InstReportPhotosEntity> instaPhotos;

	private String uploadVideo;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "MaterialInstaDeliveryChalanId")
	private List<DeliveryChalanEntity> deliveryChalan;

	private Long otp;
	private double gpsLat;
	private double gpsLong;
	private String timeStamp;
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
	public List<InstReportPhotosEntity> getInstaPhotos() {
		return instaPhotos;
	}
	public void setInstaPhotos(List<InstReportPhotosEntity> instaPhotos) {
		this.instaPhotos = instaPhotos;
	}
	public String getUploadVideo() {
		return uploadVideo;
	}
	public void setUploadVideo(String uploadVideo) {
		this.uploadVideo = uploadVideo;
	}
	public List<DeliveryChalanEntity> getDeliveryChalan() {
		return deliveryChalan;
	}
	public void setDeliveryChalan(List<DeliveryChalanEntity> deliveryChalan) {
		this.deliveryChalan = deliveryChalan;
	}
	public Long getOtp() {
		return otp;
	}
	public void setOtp(Long otp) {
		this.otp = otp;
	}
	public double getGpsLat() {
		return gpsLat;
	}
	public void setGpsLat(double gpsLat) {
		this.gpsLat = gpsLat;
	}
	public double getGpsLong() {
		return gpsLong;
	}
	public void setGpsLong(double gpsLong) {
		this.gpsLong = gpsLong;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
}
