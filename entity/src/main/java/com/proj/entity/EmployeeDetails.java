package com.proj.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDetails implements Serializable {
	private static final long serialVersionUID = -8583480775333182962L;

	private Long empId;
	private String firstName;
	private String lastName;
	private String designation;
	private String unitName;
	private String projCode;
}
