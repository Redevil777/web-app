package com.andrey.service;

import com.andrey.model.Department;
import com.andrey.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kobri on 14.05.2016.
 */


@Service("departmentService")
@Transactional
public class DepartmentService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<Department> getAll(){

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM  Department");

        return query.list();
    }

    public void add(Department department) {


        Session session = sessionFactory.getCurrentSession();

        session.save(department);
    }

    public void deleteById(int id){

        Session session = sessionFactory.getCurrentSession();

        Department department = (Department) session.get(Department.class, id);

        session.delete(department);
    }

    public Department get(int id){

        Session session = sessionFactory.getCurrentSession();

        Department department = (Department) session.get(Department.class, id);

        return department;
    }

    public void edit(Department department) {

        Session session = sessionFactory.getCurrentSession();

        Department newDepartment = (Department) session.get(Department.class, department.getId());

        newDepartment.setName(department.getName());

        session.save(newDepartment);
    }

    public List<Employee> avg(int id){

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Employee where dep_id =" + id);

        return query.list();
    }

    public List<Employee> emp(int id){
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Employee where dep_id=" + id);

        return query.list();
    }
}