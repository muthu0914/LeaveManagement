package com.hrportal.leavemgmt.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hrportal.leavemgmt.dao.LeaveManagementDao;
import com.hrportal.leavemgmt.pojo.LeaveStatus;
import com.hrportal.leavemgmt.pojo.request.LeaveApplyRequest;
import com.hrportal.leavemgmt.pojo.request.LeaveDataRequest;
import com.hrportal.leavemgmt.pojo.request.UpdateLeaveStatusRequest;
import com.hrportal.leavemgmt.pojo.response.LeaveApplyResponse;
import com.hrportal.leavemgmt.pojo.response.LeaveDataReponse;
import com.hrportal.leavemgmt.pojo.response.UpdateLeaveStatusResponse;

@Repository
public class LeaveManagementDaoImpl implements LeaveManagementDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public LeaveApplyResponse applyLeave(LeaveApplyRequest leaveApplyRequest) {
		LeaveApplyResponse leaveApplyResponse = new LeaveApplyResponse();
		try {
			String fetchMangaerIdQuery = "SELECT manager_employee_id FROM employee_mgmt.employee_relation WHERE employee_id = :employeeId";
			MapSqlParameterSource employeeParam = new MapSqlParameterSource();
			employeeParam.addValue("employeeId", leaveApplyRequest.getEmployeeId());
			int managerEmployee = namedParameterJdbcTemplate.queryForObject(fetchMangaerIdQuery, employeeParam,
					Integer.class);

			String query = "INSERT INTO leave_mgmt.leave_info(leave_id, employee_id, leave_type, start_date, end_date,reason, leave_status,manager_employee_id) VALUES(:leaveId,:employeeId,:leaveType,:startDate,:endDate,:reason,:leaveStatus,:managerEmployeeId)";
			MapSqlParameterSource params = new MapSqlParameterSource();
			String leaveId = UUID.randomUUID().toString();
			params.addValue("leaveId", leaveId);
			params.addValue("employeeId", leaveApplyRequest.getEmployeeId());
			params.addValue("leaveType", leaveApplyRequest.getType().name());
			params.addValue("startDate", leaveApplyRequest.getStartDate());
			params.addValue("endDate", leaveApplyRequest.getEndDate());
			params.addValue("reason", leaveApplyRequest.getReason());
			params.addValue("leaveStatus", LeaveStatus.APPLIED.name());
			params.addValue("managerEmployeeId", managerEmployee);
			int insertStatus = namedParameterJdbcTemplate.update(query, params);
			leaveApplyResponse.setStatus(false);
			if(insertStatus >0) {
				leaveApplyResponse.setStatus(true);
				leaveApplyResponse.setLeaveId(leaveId);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return leaveApplyResponse;
	}

	public UpdateLeaveStatusResponse withdrawLeaveRequest(UpdateLeaveStatusRequest updateLeaveStatusRequest) {		
		UpdateLeaveStatusResponse updateLeaveStatusResponse = new UpdateLeaveStatusResponse();
		String query = "UPDATE leave_mgmt.leave_info SET leave_status =:leaveStatus WHERE leave_id =:leaveId AND employee_id=:employeeId"; 
		String leaveStatus = LeaveStatus.WITHDRAWED.name(); 
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("leaveId", updateLeaveStatusRequest.getLeaveId());
		params.addValue("employeeId", updateLeaveStatusRequest.getEmployeeId());
		params.addValue("leaveStatus", leaveStatus);
		int updateStatus = namedParameterJdbcTemplate.update(query, params);
		if(updateStatus > 0) {
			updateLeaveStatusResponse.setLeaveId(updateLeaveStatusRequest.getLeaveId());
			updateLeaveStatusResponse.setLeaveStatus(leaveStatus);
		}
		return updateLeaveStatusResponse;
	}

	public UpdateLeaveStatusResponse updateLeaveStatusByManager(UpdateLeaveStatusRequest updateLeaveStatusRequest) {
		UpdateLeaveStatusResponse updateLeaveStatusResponse = new UpdateLeaveStatusResponse();
		String query = "UPDATE leave_mgmt.leave_info SET leave_status =:leaveStatus WHERE leave_id =:leaveId AND manager_employee_id=:managerEmployeeId"; 
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("leaveId", updateLeaveStatusRequest.getLeaveId());
		params.addValue("managerEmployeeId", updateLeaveStatusRequest.getEmployeeId());
		params.addValue("leaveStatus", updateLeaveStatusRequest.getLeaveStatus());
		int updateStatus = namedParameterJdbcTemplate.update(query, params);
		if(updateStatus > 0) {
			updateLeaveStatusResponse.setLeaveId(updateLeaveStatusRequest.getLeaveId());
			updateLeaveStatusResponse.setLeaveStatus(updateLeaveStatusRequest.getLeaveStatus());
		}
		return updateLeaveStatusResponse;
	}

	public List<LeaveDataReponse> getLeaveData(LeaveDataRequest leaveDataRequest) {
		String fetchMangaerIdQuery = "SELECT * FROM leave_mgmt.leave_info WHERE employee_id = :employeeId";
		MapSqlParameterSource employeeParam = new MapSqlParameterSource();
		employeeParam.addValue("employeeId", leaveDataRequest.getEmployeeId());
		List<LeaveDataReponse>  leaveDataResponseList = namedParameterJdbcTemplate.query(fetchMangaerIdQuery, employeeParam,
				new BeanPropertyRowMapper<>(LeaveDataReponse.class));
		return leaveDataResponseList;
	}

	public List<LeaveDataReponse> getLeaveDataByManager(LeaveDataRequest leaveDataRequest) {
		String fetchMangaerIdQuery = "SELECT * FROM leave_mgmt.leave_info WHERE manager_employee_id = :managerEmployeeId";
		MapSqlParameterSource employeeParam = new MapSqlParameterSource();
		employeeParam.addValue("managerEmployeeId", leaveDataRequest.getEmployeeId());
		List<LeaveDataReponse>  leaveDataResponseList = (List<LeaveDataReponse>) namedParameterJdbcTemplate.query(fetchMangaerIdQuery, employeeParam,
				new BeanPropertyRowMapper<>(LeaveDataReponse.class));
		return leaveDataResponseList;
	}

}
