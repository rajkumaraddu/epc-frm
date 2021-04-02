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
@Table(name = "EnquirySourceMaster")
public class EnquirySourceEntity extends BaseEntity {

	private static final long serialVersionUID = 5831218023914872984L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 50)
	private String enquirySource;
	@Column(length = 1)
	private String activeStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnquirySource() {
		return enquirySource;
	}

	public void setEnquirySource(String enquirySource) {
		this.enquirySource = enquirySource;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

}
