package com.tosit.emps.service;

import com.tosit.emps.common.util.Page;
import com.tosit.emps.dao.EmployeeDao;
import com.tosit.emps.dao.EmployeeDaoImpl;
import com.tosit.emps.entity.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    @Override
    public Page<Employee> findAllEmployee(int pageNo,int pageSize) {
        return employeeDao.selectEmployees(pageNo,pageSize);
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeDao.selectEmployeeById(id);
    }

    @Override
    public void updateEmployee(Employee e) {
        employeeDao.updateEmployee(e);
    }

    @Override
    public void removeEmployeeById(Integer id) {
        employeeDao.deleteEmployeeById(id);
    }


}
