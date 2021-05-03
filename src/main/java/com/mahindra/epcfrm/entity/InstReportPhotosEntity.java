package com.mahindra.epcfrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "InstReportPhotos")
public class InstReportPhotosEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 773860676692114603L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 100)
	private String instPhotoName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstPhotoName() {
		return instPhotoName;
	}

	public void setInstPhotoName(String instPhotoName) {
		this.instPhotoName = instPhotoName;
	}

}
