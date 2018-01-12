package com.tosit.emps.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@WebFilter("/*")
public class ConfigFilter implements Filter {
    Map<String,String> map = null;

    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        map = (Map<String, String>) filterConfig.getServletContext().getAttribute("configMap");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        boolean isRun= Boolean.parseBoolean(map.get("isRun"));
        if( isRun==false){
            servletRequest.getRequestDispatcher("/maintain.jsp").forward(servletRequest,servletResponse);
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
