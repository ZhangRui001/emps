package com.tosit.emps.action;

import com.tosit.emps.common.util.DateUtil;
import com.tosit.emps.common.util.JsonUtil;
import com.tosit.emps.common.util.Page;
import com.tosit.emps.common.vo.JSONResponse;
import com.tosit.emps.entity.Employee;
import com.tosit.emps.entity.User;
import com.tosit.emps.service.EmployeeService;
import com.tosit.emps.service.EmployeeServiceImpl;
import com.tosit.framework.mvc.annotation.RequestPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RequestPath("/emp")
public class EmployeeAction {

    private EmployeeService employeeService  = new EmployeeServiceImpl();
    @RequestPath("/listemp")
    public String listEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNoTxt = request.getParameter("pageNo");
        String pageSizeTxt = request.getParameter("pageSize");
        int pageNo = (pageNoTxt==null ?1:(Integer.parseInt(pageNoTxt.trim()))) ;
        int pageSize = (pageSizeTxt==null ?10:(Integer.parseInt(pageSizeTxt.trim()))) ;
        Page<Employee> page = employeeService.findAllEmployee(pageNo,pageSize);
        JsonUtil.printByJSON(response,new JSONResponse(true,page));
        return null;
    }

    @RequestPath("/showOneEmplyee")
    public String showOneEmplyee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        Employee employee = employeeService.findEmployeeById(Integer.parseInt(id));
        request.setAttribute("employee",employee);
        return "/WEB-INF/emp/emp_show.jsp";
    }

    @RequestPath("/toUpdatePage")
    public String toUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        Employee employee = employeeService.findEmployeeById(Integer.parseInt(id));
        request.setAttribute("employee",employee);
        return "/WEB-INF/emp/emp_edit.jsp";
    }

    @RequestPath("/updateEmp")
    public String updateEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idTxt= request.getParameter("id");
        Integer id = Integer.parseInt(idTxt);
        Employee emp = employeeService.findEmployeeById(id);

        int empno = Integer.parseInt(request.getParameter("empno"));
        emp.setEmpno(empno);
        String ename = request.getParameter("ename");
        emp.setEname(ename);
        String job = request.getParameter("job");
        emp.setJob(job);
        Integer mgr =Integer.parseInt(request.getParameter("mgr"));
        emp.setMgr(mgr);
        Date date = DateUtil.parseDateFromStr(request.getParameter("hiredate"));
        emp.setHiredate(date);
        double sal =  Double.parseDouble(request.getParameter("sal"));
        emp.setSal(sal);

      /*  Employee e = new Employee(id,empno,ename,job,mgr,date,sal,0.0,0);*/

        employeeService.updateEmployee(emp);
        request.setAttribute("employee",emp);
        return "/WEB-INF/emp/emp_edit_success.jsp";
    }



    @RequestPath("/delEmp")
    public String delEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String idTxt =  request.getParameter("id");
       Integer id = Integer.valueOf(idTxt);

        employeeService.removeEmployeeById(id);
       // return  "/emp/listemp.do";

       return "/WEB-INF/emp/emp_del_success.jsp";
    }




}
