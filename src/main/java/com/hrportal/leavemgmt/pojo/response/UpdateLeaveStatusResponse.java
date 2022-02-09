package com.hrportal.leavemgmt.pojo.response;

import com.hrportal.leavemgmt.pojo.BaseResponse;
import com.hrportal.leavemgmt.pojo.LeaveStatus;

public class UpdateLeaveStatusResponse extends BaseResponse{
	private String leaveId;
	private String leaveStatus;
	public String getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	
}
