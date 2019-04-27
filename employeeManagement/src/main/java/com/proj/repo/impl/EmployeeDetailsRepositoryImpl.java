package com.proj.repo.impl;

import static com.proj.constants.DatabaseConstants.SP_RESULT_SET;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.proj.entity.EmployeeDetails;
import com.proj.repo.EmployeeDetailsRepository;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@Repository
public class EmployeeDetailsRepositoryImpl implements EmployeeDetailsRepository {

	private final SimpleJdbcCall CreateSPInstance;

	public EmployeeDetailsRepositoryImpl(@Qualifier("CreateSPInstance") SimpleJdbcCall createSPInstance) {
		this.CreateSPInstance = createSPInstance;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeDetails> findAll(Long empId, String correlationId) {
	//	log.info("<START> findAll in REPOSITORY :: CorrelationID :- " + correlationId);
		Map<String, Object> results = CreateSPInstance.execute(empId);
		List<EmployeeDetails> employeeDetails = (List<EmployeeDetails>) results.get(SP_RESULT_SET);
	//	log.info("<END> findAll in REPOSITORY :: CorrelationID :- " + correlationId);
		return employeeDetails;
	}

}
