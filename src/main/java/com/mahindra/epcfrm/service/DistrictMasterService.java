package com.mahindra.epcfrm.service;

import java.util.List;

import com.mahindra.epcfrm.entity.DistrictMasterEntity;

public interface DistrictMasterService {

	List<DistrictMasterEntity> getDistrictsByStateWise(int stateCode);
}
