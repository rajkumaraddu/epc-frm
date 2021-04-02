package com.mahindra.epcfrm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "created_on", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdOn;

	@Column(name = "modified_on")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modifiedOn;
	@Column(length = 10, name = "created_by", updatable = false)
	private String createdBy;
	@Column(length = 100)
	private String modifiedBy;

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@PrePersist
	public void beforeCreate() {
		Date now = new Date();
		this.createdOn = now;
		this.createdBy = "EPC Admin";
//		this.modifiedOn = now;
//		setIsActive("Y");
	}

	@PreUpdate
	public void beforeUpdate() {
		this.modifiedOn = new Date();
		// this.modified_by = "SRA";

	}

}

/*
 * For using the above code in the entity you need to follow the below snipet
 * 
 * 
 * 
 * @Entity
 * 
 * @Table(name="mt_demo")
 * 
 * @AttributeOverride(name="id",column=@Column(name="demoid"))//if you want to
 * override the base entity column then use this public class MTDemo extends
 * BaseEntity{ ' ' ----your remaining column---getter setters }
 * 
 * 
 */
