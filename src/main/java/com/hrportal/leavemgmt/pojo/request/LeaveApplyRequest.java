package com.hrportal.leavemgmt.pojo.request;

import java.time.LocalDate;

import com.hrportal.leavemgmt.pojo.LeaveType;

public class LeaveApplyRequest {
	private int employeeId;
	private LeaveType type;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public LeaveType getType() {
		return type;
	}
	public void setType(LeaveType type) {
		this.type = type;
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
	
}
