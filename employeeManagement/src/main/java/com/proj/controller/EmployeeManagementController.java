package com.proj.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.entity.EmployeeDetails;
import com.proj.service.EmployeeDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmployeeManagementController {

	private final EmployeeDetailsService employeeDetailsService;

	public EmployeeManagementController(EmployeeDetailsService employeeDetailsService) {
		this.employeeDetailsService = employeeDetailsService;
	}

	@RequestMapping("/employee/byId")
	private List<EmployeeDetails> fetchEmployeeDetils(@RequestHeader Long empId, @RequestHeader String correlationId) {
		log.info("<START> fetchEmployeeDetils in CONTROLLER :: CorrelationID :- " + correlationId);
		List<EmployeeDetails> employeeDetails = employeeDetailsService.fetchEmployeeDetils(empId, correlationId);
		log.info("<END> fetchEmployeeDetils in CONTROLLER :: CorrelationID :- " + correlationId);
		return employeeDetails;
	}
}
