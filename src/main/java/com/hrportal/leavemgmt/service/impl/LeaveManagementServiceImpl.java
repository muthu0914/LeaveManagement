package com.hrportal.leavemgmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrportal.leavemgmt.dao.LeaveManagementDao;
import com.hrportal.leavemgmt.pojo.request.LeaveApplyRequest;
import com.hrportal.leavemgmt.pojo.request.LeaveDataRequest;
import com.hrportal.leavemgmt.pojo.request.UpdateLeaveStatusRequest;
import com.hrportal.leavemgmt.pojo.response.LeaveApplyResponse;
import com.hrportal.leavemgmt.pojo.response.LeaveDataReponse;
import com.hrportal.leavemgmt.pojo.response.UpdateLeaveStatusResponse;
import com.hrportal.leavemgmt.service.LeaveManagementService;

@Service
public class LeaveManagementServiceImpl implements LeaveManagementService {

	@Autowired
	LeaveManagementDao leaveManagmentDao;

	public LeaveApplyResponse applyLeave(LeaveApplyRequest leaveApplyRequest) {
		return leaveManagmentDao.applyLeave(leaveApplyRequest);
	}

	public UpdateLeaveStatusResponse withdrawLeaveRequest(UpdateLeaveStatusRequest updateLeaveStatusRequest) {
		return leaveManagmentDao.withdrawLeaveRequest(updateLeaveStatusRequest);
	}

	public UpdateLeaveStatusResponse updateLeaveStatusByManager(UpdateLeaveStatusRequest updateLeaveStatusRequest) {
		return leaveManagmentDao.updateLeaveStatusByManager(updateLeaveStatusRequest);
	}

	public List<LeaveDataReponse> getLeaveData(LeaveDataRequest leaveDataRequest) {
		return leaveManagmentDao.getLeaveData(leaveDataRequest);
	}

	public List<LeaveDataReponse> getLeaveDataByManager(LeaveDataRequest leaveDataRequest) {
		return leaveManagmentDao.getLeaveDataByManager(leaveDataRequest);

	}

}
