package com.proj.config;

import static com.proj.constants.DatabaseConstants.IN_PARAMETER_IN_EMP_ID;
import static com.proj.constants.DatabaseConstants.SP_NAME_EMP_LIST_BY_ID;
import static com.proj.constants.DatabaseConstants.SP_RESULT_SET;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.proj.mapper.EmployeeManagementMapper;
import com.proj.repo.mapper.EmployeeDetailsMapper;

@Configuration
public class MySQLSPConfig {

	private final DataSource dataSource;
	private final EmployeeManagementMapper employeeManagementMapper;

	MySQLSPConfig(DataSource dataSource, EmployeeManagementMapper employeeManagementMapper) {
		this.dataSource = dataSource;
		this.employeeManagementMapper = employeeManagementMapper;
	}

	@Bean("CreateSPInstance")
	public SimpleJdbcCall CreateSPInstance() {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withSchemaName("dev")
				.withProcedureName(SP_NAME_EMP_LIST_BY_ID)
				.declareParameters(new SqlParameter(IN_PARAMETER_IN_EMP_ID, Types.BIGINT))
				.returningResultSet(SP_RESULT_SET, new EmployeeDetailsMapper(employeeManagementMapper));
		simpleJdbcCall.compile();
		return simpleJdbcCall;
	}

}
