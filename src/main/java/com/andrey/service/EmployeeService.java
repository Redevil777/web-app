package com.andrey.service;

import com.andrey.model.Department;
import com.andrey.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by kobri on 15.05.2016.
 */
@Service("employeeService")
@Transactional
public class EmployeeService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;


    public List<Employee> getAll(){

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Employee");

        List<Employee> list = query.list();

        return query.list();
    }

    public void add(Employee employee){

        Session session = sessionFactory.getCurrentSession();

        session.save(employee);
    }

    public void delete(int id){
        Session session = sessionFactory.getCurrentSession();

        Employee employee = (Employee) session.get(Employee.class, id);

        session.delete(employee);
    }

    public void edit(Employee employee){
        Session session = sessionFactory.getCurrentSession();

        Employee newEmployee = (Employee) session.get(Employee.class, employee.getId());

        newEmployee.setFname(employee.getFname());
        newEmployee.setLname(employee.getLname());
        newEmployee.setMname(employee.getMname());
        newEmployee.setBirthday(employee.getBirthday());
        newEmployee.setSalary(employee.getSalary());
        newEmployee.setDep_id(employee.getDep_id());

        session.save(newEmployee);
    }

    public Employee get(int id){

        Session session = sessionFactory.getCurrentSession();

        Employee employee = (Employee) session.get(Employee.class, id);

        return employee;
    }

    public List<Employee> getEmployeesBetweenDates(Date from, Date to){

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Employee where birthday between '" + from +  "' and '" + to + "'");

        return query.list();
    }

    public List<Employee> getEmployeeByDate(Date date){
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Employee where birthday = '" + date + "'");

        return query.list();
    }
}
