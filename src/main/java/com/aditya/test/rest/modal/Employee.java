package com.aditya.test.rest.modal;

import java.io.Serializable;

import lombok.Data;

@Data
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	private int emp_id;
	private String emp_name;
	private Integer salary;
}
