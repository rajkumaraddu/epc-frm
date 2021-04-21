package com.mahindra.epcfrm.dto;

import java.util.List;

import com.mahindra.epcfrm.entity.LeadMasterEntity;

public class DashBoardLeadsResponseDto {

	List<LeadMasterEntity> leadsOnWoPending;//woPendingLeads
	List<LeadMasterEntity> leadsOnKycPending;
	List<LeadMasterEntity> leadsOnQuoPending;

	public List<LeadMasterEntity> getLeadsOnWoPending() {
		return leadsOnWoPending;
	}

	public void setLeadsOnWoPending(List<LeadMasterEntity> leadsOnWoPending) {
		this.leadsOnWoPending = leadsOnWoPending;
	}

	public List<LeadMasterEntity> getLeadsOnKycPending() {
		return leadsOnKycPending;
	}

	public void setLeadsOnKycPending(List<LeadMasterEntity> leadsOnKycPending) {
		this.leadsOnKycPending = leadsOnKycPending;
	}

	public List<LeadMasterEntity> getLeadsOnQuoPending() {
		return leadsOnQuoPending;
	}

	public void setLeadsOnQuoPending(List<LeadMasterEntity> leadsOnQuoPending) {
		this.leadsOnQuoPending = leadsOnQuoPending;
	}

}
