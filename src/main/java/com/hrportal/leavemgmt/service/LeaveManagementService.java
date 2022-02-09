package com.hrportal.leavemgmt.service;

import java.util.List;

import com.hrportal.leavemgmt.pojo.request.LeaveApplyRequest;
import com.hrportal.leavemgmt.pojo.request.LeaveDataRequest;
import com.hrportal.leavemgmt.pojo.request.UpdateLeaveStatusRequest;
import com.hrportal.leavemgmt.pojo.response.LeaveApplyResponse;
import com.hrportal.leavemgmt.pojo.response.LeaveDataReponse;
import com.hrportal.leavemgmt.pojo.response.UpdateLeaveStatusResponse;

public interface LeaveManagementService {
	public LeaveApplyResponse applyLeave(LeaveApplyRequest leaveApplyRequest);
	public UpdateLeaveStatusResponse withdrawLeaveRequest(UpdateLeaveStatusRequest updateLeaveStatusRequest);
	public UpdateLeaveStatusResponse updateLeaveStatusByManager(UpdateLeaveStatusRequest updateLeaveStatusRequest);
	public List<LeaveDataReponse> getLeaveData(LeaveDataRequest leaveDataRequest);
	public List<LeaveDataReponse> getLeaveDataByManager(LeaveDataRequest leaveDataRequest);
}
