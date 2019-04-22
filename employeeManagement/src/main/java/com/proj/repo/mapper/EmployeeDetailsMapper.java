package com.proj.repo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.proj.entity.EmployeeDetails;
import com.proj.mapper.EmployeeManagementMapper;

public class EmployeeDetailsMapper implements RowMapper<EmployeeDetails> {

	private final EmployeeManagementMapper employeeManagementMapper;
	public EmployeeDetailsMapper(EmployeeManagementMapper employeeManagementMapper) {

		this.employeeManagementMapper = employeeManagementMapper;
	}

	@Override
	public EmployeeDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		return employeeManagementMapper.resultSetToEmployeeDetails(rs);
	}

}
