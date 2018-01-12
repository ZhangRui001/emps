package com.tosit.emps.service;

import com.tosit.emps.common.util.Page;
import com.tosit.emps.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAllEmployee(int pageNo, int pageSize) ;

    Employee findEmployeeById(Integer i);

    void updateEmployee(Employee e);

    void removeEmployeeById(Integer id);
}
