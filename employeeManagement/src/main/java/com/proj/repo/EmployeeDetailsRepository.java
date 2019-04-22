package com.proj.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.proj.entity.EmployeeDetails;

@Repository
public interface EmployeeDetailsRepository {
	public List<EmployeeDetails> findAll(Long empId, String correlationId);
}
