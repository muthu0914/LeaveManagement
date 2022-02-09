package com.hrportal.leavemgmt.pojo.response;

import java.time.LocalDate;
import java.util.Date;

import com.hrportal.leavemgmt.pojo.LeaveStatus;
import com.hrportal.leavemgmt.pojo.LeaveType;

public class LeaveDataReponse {
	private String leaveId;
	private int employeeId;
	private LeaveType leaveType;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	private LeaveStatus leaveStatus;
	public String getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	
}
