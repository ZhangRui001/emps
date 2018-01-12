package com.tosit.emps.common.filter;

import com.tosit.emps.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckIsLoginFilter implements Filter {
    String[] excludepath = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String str= filterConfig.getInitParameter("exclude");
        if ( str!=null && str.trim().length()>0 ){
            excludepath = str.split(",");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        boolean  isFilter = true;
        if(excludepath!=null && excludepath.length>0){
            for (String  exclude:
                    excludepath) {
                if(uri.endsWith(exclude) || uri.indexOf(exclude)!=-1){
                    isFilter = false;
                    break;
                }
            }
        }


        if(isFilter){
            User u = (User) request.getSession().getAttribute("current_user");
            if(u==null){
                request.setAttribute("errMsg","请登录后再操作!!");
                request.getRequestDispatcher("/WEB-INF/emp/emp_login.jsp").forward(request,response);
            }else{
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
