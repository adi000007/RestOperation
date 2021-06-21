package com.aditya.test.rest.modal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee implements Serializable
{
    private static final long serialVersionUID = 1L;
    private int emp_id;
    private String emp_name;
    private Integer salary;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;


}
