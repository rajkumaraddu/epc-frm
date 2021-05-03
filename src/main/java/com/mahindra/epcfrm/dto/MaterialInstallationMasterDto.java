package com.mahindra.epcfrm.dto;

import java.util.List;
import com.mahindra.epcfrm.entity.DeliveryChalanEntity;
import com.mahindra.epcfrm.entity.InstReportPhotosEntity;

public class MaterialInstallationMasterDto {

    private int leadId;
	private List<InstReportPhotosEntity> instaPhotos;
	private String uploadVideo;
    private List<DeliveryChalanEntity> deliveryChalan;
	private Long otp;
	private double gpsLat;
	private double gpsLong;
	private String timeStamp;
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
