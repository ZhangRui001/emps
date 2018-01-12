package com.tosit.emps.dao;

import com.tosit.emps.common.util.Page;
import com.tosit.emps.entity.Employee;
import com.tosit.emps.entity.User;

import java.util.List;

public interface EmployeeDao {
    public Employee selectEmployeeById(Integer id);
    public Page<Employee> selectEmployees(int pageNo,int pageSize);
    public void  insertEmployee(Employee employee);
    public void  updateEmployee(Employee employee);
    public void  deleteEmployeeById(Integer... ids);
    public int  selectEmployeeCount();
}
