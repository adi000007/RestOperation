package com.aditya.test.rest.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.aditya.test.rest.modal.Employee;

@Component
public class ManageEmployee
{

    private static SessionFactory factory;

    public ManageEmployee()
    {
        try
        {
            factory = new Configuration().configure().buildSessionFactory();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
        }
    }

    public Integer addEmployee(Employee emp)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer emp_id = null;
        try
        {
            tx = session.beginTransaction();
            emp_id = (Integer) session.save(emp);
            tx.commit();
        }
        catch (HibernateException e)
        {

        }
        finally
        {
            session.close();
        }
        return emp_id;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Employee> getEmployee()
    {
        Transaction tx = null;
        ArrayList<Employee> list = null;
        try (Session session = factory.openSession())
        {
            tx = session.beginTransaction();
            list = (ArrayList<Employee>) session.createQuery("FROM Employee").list();
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteEmployee(Integer id)
    {
        Transaction tx = null;
        try (Session session = factory.openSession())
        {
            tx = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, id);
            session.delete(employee);
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee)
    {
        Transaction tx = null;
        try (Session session = factory.openSession())
        {
            tx = session.beginTransaction();
            //session.get(Employee.class, employee.getEmp_id()); 
            session.update(employee);
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
