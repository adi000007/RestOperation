package com.aditya.test.rest.dao;

import com.aditya.test.rest.modal.Employee;
import java.util.List;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface Repo extends CrudRepository<Employee, String>
{
    List<Employee> findAll();
}
