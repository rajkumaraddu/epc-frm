package com.mahindra.epcfrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = " MaterialDeliveryPhotos")
public class MaterialDeliveryPhotosEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6692636971093187116L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 100)
	private String materialPhotosName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaterialPhotosName() {
		return materialPhotosName;
	}

	public void setMaterialPhotosName(String materialPhotosName) {
		this.materialPhotosName = materialPhotosName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	

}
