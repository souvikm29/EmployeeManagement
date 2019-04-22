package com.proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proj.entity.EmployeeDetails;
import com.proj.repo.EmployeeDetailsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeDetailsService {
	private final EmployeeDetailsRepository employeeDetailsRepository;

	public EmployeeDetailsService(EmployeeDetailsRepository employeeDetailsRepository) {
		this.employeeDetailsRepository = employeeDetailsRepository;
	}

	public List<EmployeeDetails> fetchEmployeeDetils(Long empId, String correlationId) {
		log.info("<START> fetchEmployeeDetils in SERVICE :: CorrelationID :- " + correlationId);
		List<EmployeeDetails> employeeDetails = employeeDetailsRepository.findAll(empId, correlationId);
		log.info("<END> fetchEmployeeDetils in SERVICE :: CorrelationID :- " + correlationId);
		return employeeDetails;
	}
}
