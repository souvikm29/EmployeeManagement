
package com.proj.mapper;

import static com.proj.constants.DatabaseConstants.COLUMN_1_LONG;
import static com.proj.constants.DatabaseConstants.COLUMN_2;
import static com.proj.constants.DatabaseConstants.COLUMN_3;
import static com.proj.constants.DatabaseConstants.COLUMN_4;
import static com.proj.constants.DatabaseConstants.COLUMN_5;
import static com.proj.constants.DatabaseConstants.COLUMN_6;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.proj.entity.EmployeeDetails;

@Mapper(componentModel = "spring")
public interface EmployeeManagementMapper {

	@Mapping(target = "empId", expression = COLUMN_1_LONG)
	@Mapping(target = "firstName", expression = COLUMN_2)
	@Mapping(target = "lastName", expression = COLUMN_3)
	@Mapping(target = "designation", expression = COLUMN_4)
	@Mapping(target = "unitName", expression = COLUMN_5)
	@Mapping(target = "projCode", expression = COLUMN_6)
	EmployeeDetails resultSetToEmployeeDetails(ResultSet rs) throws SQLException;
}
