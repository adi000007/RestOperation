package com.aditya.test.rest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.test.rest.dao.ManageEmployee;
import com.aditya.test.rest.modal.Employee;


@RestController
public class MyController {

	@Autowired
	ManageEmployee manager;
	
	@RequestMapping(value="/Employee/{Employee}",method = RequestMethod.POST,produces="application/json",consumes="application/json")
	public ResponseEntity<Object> addEmployee(@RequestParam("Employee") Employee emp) {
		manager.addEmployee(emp);
		return new ResponseEntity<Object>("Employee Added Sucessfully", HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/Employee/{Id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployee(@PathVariable("Id") Integer id) {
		manager.deleteEmployee(id);
		return new ResponseEntity<Object>("Employee Deleted Sucessfully", HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/Employee",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<ArrayList<Employee>> getEmployee(){
		return new ResponseEntity<ArrayList<Employee>>(manager.getEmployee(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/Employee/{Employee}",method=RequestMethod.PUT,produces="application/json",consumes="application/json")
	public ResponseEntity<Object> updateEmployee(@PathVariable("Employee") Employee employee){
		manager.updateEmployee(employee);
		return new ResponseEntity<Object>("Employee Updated", HttpStatus.OK);
	}
}
