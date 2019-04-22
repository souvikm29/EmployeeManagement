package com.proj.mapper;

import com.proj.entity.EmployeeDetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-04-23T00:53:16+0530",
    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class EmployeeManagementMapperImpl implements EmployeeManagementMapper {

    @Override
    public EmployeeDetails resultSetToEmployeeDetails(ResultSet rs) throws SQLException {
        if ( rs == null ) {
            return null;
        }

        EmployeeDetails employeeDetails = new EmployeeDetails();

        employeeDetails.setEmpId( rs.getLong(1) );
        employeeDetails.setFirstName( rs.getString(2) );
        employeeDetails.setLastName( rs.getString(3) );
        employeeDetails.setProjCode( rs.getString(6) );
        employeeDetails.setUnitName( rs.getString(5) );
        employeeDetails.setDesignation( rs.getString(4) );

        return employeeDetails;
    }
}
