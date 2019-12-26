package com.aditya.test.rest;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.aditya.test.rest.dao.ManageEmployee;
import com.aditya.test.rest.modal.Employee;

public class JdbcConnectionTest {

	ManageEmployee manageEmployee = new ManageEmployee();
	//@Test
	public void test() {

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp_table");
			printRs(rs);
				assertNotNull(stmt.execute("SELECT 1"));
		} catch (SQLException  e) {
			e.printStackTrace();
		}
		
	}
	
	void printRs(ResultSet rs) throws SQLException {
	  while(rs.next()) {
		System.out.println("[ ID : "+rs.getInt("emp_id")+" , Name : "+rs.getString("emp_name")+" ]");  
	  }
	}

	//@Test
	public void testInsert() {
			Employee emp = new Employee();
			emp.setEmp_id(5);
			emp.setEmp_name("Anjali");
			emp.setSalary(10000);
			int i = manageEmployee.addEmployee(emp);
			System.out.println(i);
				assertNotNull(i);
	}
}
