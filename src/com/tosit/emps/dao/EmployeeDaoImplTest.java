package com.tosit.emps.dao;

import com.tosit.emps.entity.Employee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeDaoImplTest {
    private EmployeeDao dao = null;

    @Before
    public  void before(){
        dao= new EmployeeDaoImpl();
    }




    @Test
    public void insertEmployee() throws Exception {
        Employee emp = new Employee();
        emp.setEname("哈哈啊哈岁的安德森");
        dao.insertEmployee(emp);
    }

    @Test
    public void updateEmployee() throws Exception {
        Employee emp = dao.selectEmployeeById(9);
        emp.setEname("傻B");
        dao.updateEmployee(emp);
    }

    @Test
    public void deleteEmployeeById() throws Exception {
        dao.deleteEmployeeById(10,15);
    }

    @Test
    public void selectEmployeeCount() throws Exception {
       // System.out.println(dao.selectEmployees().size());
      // dao.selectEmployees();
    }

}