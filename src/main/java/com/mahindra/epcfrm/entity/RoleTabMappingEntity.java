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
@Table(name = "RoleTabMapping")
public class RoleTabMappingEntity extends BaseEntity {

	private static final long serialVersionUID = 3976145387662765684L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 20)
	private String rtMapId;
	@Column(length = 20)
	private String tabId;
	@Column(length = 1)
	private String activeStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRtMapId() {
		return rtMapId;
	}

	public void setRtMapId(String rtMapId) {
		this.rtMapId = rtMapId;
	}

	public String getTabId() {
		return tabId;
	}

	public void setTabId(String tabId) {
		this.tabId = tabId;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

}
