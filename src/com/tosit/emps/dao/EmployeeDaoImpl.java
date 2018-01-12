package com.tosit.emps.dao;

import com.tosit.emps.common.jdbc.MyDbUtil;
import com.tosit.emps.common.util.Page;
import com.tosit.emps.entity.Employee;
import com.tosit.emps.entity.User;
import com.tosit.emps.entity.Value;

import java.sql.Connection;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public Employee selectEmployeeById(Integer id) {
        Connection conn = MyDbUtil.getConnection();
        String sql = " select  id, empno, ename, job, mgr, hiredate, sal, comm, deptno from emp where id = ? " ;
        List<Employee> list = MyDbUtil.executeQuery(conn,Employee.class,sql,id);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Page<Employee> selectEmployees(int pageNo, int pageSize){
        Connection conn = MyDbUtil.getConnection();
        String sql = " select id, empno, ename, job, mgr, hiredate, sal, comm, deptno  from emp limit ?,?";
        List<Employee> list = MyDbUtil.executeQuery(conn,Employee.class,sql,(pageNo-1)*pageSize,pageSize);
        int count = selectEmployeeCount();
        return new Page<Employee>(pageNo,pageSize,count,list);
    }

    @Override
    public void insertEmployee(Employee employee) {
        Connection conn = MyDbUtil.getConnection();
        String sql = " insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(?,?,?,?,?,?,?,?) " ;
        MyDbUtil.executeUpdate(conn,sql,employee.getEmpno(),employee.getEname(),employee.getJob(),employee.getMgr(),employee.getHiredate(),employee.getSal(),employee.getComm(),employee.getDeptno());
    }

    @Override
    public void updateEmployee(Employee employee) {
        Connection conn = MyDbUtil.getConnection();
        //没有实现智能更新!!
        String sql = " update  emp set empno=?, ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? where id = ? " ;
        MyDbUtil.executeUpdate(conn,sql,employee.getEmpno(),employee.getEname(),employee.getJob(),employee.getMgr(),employee.getHiredate(),employee.getSal(),employee.getComm(),employee.getDeptno(),employee.getId());
    }

    @Override
    public void deleteEmployeeById(Integer... ids) {
        Connection conn = MyDbUtil.getConnection();
        String sql = " delete from emp " ;
        if(ids!=null && ids.length>0){
            sql = sql + " where id in ( ";
            for (int i =0;i<ids.length;i++){
                if(i==ids.length-1){
                    sql = sql+"?";
                }else{
                    sql = sql+"?,";
                }
            }
            sql = sql + " )";
        }
        MyDbUtil.executeUpdate(conn,sql,ids);
    }

    @Override
    public int selectEmployeeCount() {
        Connection conn = MyDbUtil.getConnection();
        String sql = "  select  count(*) 'value' from emp " ;
        List<Value> list = MyDbUtil.executeQuery(conn,Value.class,sql);
        return (int) (list.get(0).getValue());
    }
}
