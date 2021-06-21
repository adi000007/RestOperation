package com.aditya.test.rest.controller;

import com.aditya.test.rest.dao.Repo;
import java.util.ArrayList;

import java.util.List;
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
public class MyController
{

    @Autowired
    Repo repo;
    //ManageEmployee manager;

    @RequestMapping(value = "/Employee/{Employee}", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestParam("Employee") Employee emp)
    {
        repo.save(emp);
        return new ResponseEntity<Object>("Employee Added Sucessfully", HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/Employee/{Id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEmployee(@PathVariable("Id") Integer id)
    {
        //manager.deleteEmployee(id);
        return new ResponseEntity<Object>("Employee Deleted Sucessfully", HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/Employee", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Employee>> getEmployee()
    {
        List<Employee> list = repo.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @RequestMapping(value = "/Employee/{Employee}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> updateEmployee(@PathVariable("Employee") Employee employee)
    {
        //	manager.updateEmployee(employee);
        return new ResponseEntity<Object>("Employee Updated", HttpStatus.OK);
    }
}
