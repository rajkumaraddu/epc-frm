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
@Table(name = "TabMaster")
public class TabMasterEntity extends BaseEntity {

	private static final long serialVersionUID = -4789272931002145262L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 20)
	private String tabId;
	@Column(length = 100)
	private String tabName;
	@Column(length = 100)
	private String tabDesc;
	@Column(length = 1)
	private String activeStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTabId() {
		return tabId;
	}

	public void setTabId(String tabId) {
		this.tabId = tabId;
	}

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public String getTabDesc() {
		return tabDesc;
	}

	public void setTabDesc(String tabDesc) {
		this.tabDesc = tabDesc;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

}
