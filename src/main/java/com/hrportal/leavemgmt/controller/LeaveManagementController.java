package com.hrportal.leavemgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrportal.leavemgmt.pojo.request.LeaveApplyRequest;
import com.hrportal.leavemgmt.pojo.request.LeaveDataRequest;
import com.hrportal.leavemgmt.pojo.request.UpdateLeaveStatusRequest;
import com.hrportal.leavemgmt.pojo.response.LeaveApplyResponse;
import com.hrportal.leavemgmt.pojo.response.LeaveDataReponse;
import com.hrportal.leavemgmt.pojo.response.UpdateLeaveStatusResponse;
import com.hrportal.leavemgmt.service.LeaveManagementService;

@RestController
@RequestMapping("/leaveManagement")
public class LeaveManagementController {
	
	@Autowired
	LeaveManagementService leaveManagmentService;
	
	@PostMapping("/applyLeave")
	public LeaveApplyResponse applyLeave(@RequestBody LeaveApplyRequest leaveApplyRequest) {
		return leaveManagmentService.applyLeave(leaveApplyRequest);
	}
	@PostMapping("/withdrawLeaveRequest")
	public UpdateLeaveStatusResponse withdrawLeaveRequest(@RequestBody UpdateLeaveStatusRequest updateLeaveStatusRequest) {
		return leaveManagmentService.withdrawLeaveRequest(updateLeaveStatusRequest);
	}
	@PostMapping("/updateLeaveStatusByManager")
	public UpdateLeaveStatusResponse updateLeaveStatusByManager(@RequestBody UpdateLeaveStatusRequest updateLeaveStatusRequest) {
		return leaveManagmentService.updateLeaveStatusByManager(updateLeaveStatusRequest);
	}
	@PostMapping("/getLeaveData")
	public List<LeaveDataReponse> getLeaveData(@RequestBody LeaveDataRequest leaveDataRequest) {
		return leaveManagmentService.getLeaveData(leaveDataRequest);
	}
	@PostMapping("/getLeaveDataByManager")
	public List<LeaveDataReponse> getLeaveDataByManager(@RequestBody LeaveDataRequest leaveDataRequest) {
		return leaveManagmentService.getLeaveDataByManager(leaveDataRequest);
	}
}
