
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String[] strs=new String[]{"AAA","BBB","CCCC","DDDD","EEEE","FFFFF"};
    request.setAttribute("data",strs);
%>
<jsp:forward page="jstlDemo.jsp"/>