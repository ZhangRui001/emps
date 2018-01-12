package com.tosit.emps.common.listener;

import com.tosit.emps.common.jdbc.MyDbUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ConfigListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("初始化!!");
        ServletContext context =  servletContextEvent.getServletContext();
        Map<String,String> map = new HashMap<>();
        //查询数据库的代码
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs=null;
        try {
            conn  = MyDbUtil.getConnection();
            String sql =" select id,name,value from config ";
            preparedStatement = conn.prepareStatement(sql);
            rs= preparedStatement.executeQuery();
            while (rs.next()){
                map.put( rs.getString("name").trim(),rs.getString("value").trim());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }


        context.setAttribute("configMap",map);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
