package com.hrportal.leavemgmt.pojo.request;

import com.hrportal.leavemgmt.pojo.LeaveStatus;

public class UpdateLeaveStatusRequest {
	private String leaveId;
	private int employeeId;
	private String leaveStatus;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public String getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}
	
}
