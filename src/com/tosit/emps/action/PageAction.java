package com.tosit.emps.action;

import com.tosit.framework.mvc.annotation.RequestPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestPath("/page")
public class PageAction {
    @RequestPath("/toList")
    public String toList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/WEB-INF/emp/emp_list.jsp";
    }
}
