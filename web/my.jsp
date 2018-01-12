<%@ page import="com.tosit.emps.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: hkx
  Date: 2018/1/9
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL</title>
</head>
<body>


<%
    pageContext.setAttribute("page","page");
    request.setAttribute("request","request");
    session.setAttribute("session","session");
    application.setAttribute("servletContext","servletContext");
    request.setAttribute("ABC","abc");
    application.setAttribute("ABC","ABC");


    User u = new User();
    u.setId(885);
    u.setPassword("假");
    u.setName("李");
    session.setAttribute("u",u);

    java.util.List<String> list = new java.util.ArrayList<>();
    list.add("AAAB");
    request.setAttribute("list",list);

    String[] strs= new String[]{"AA"};

    request.setAttribute("strs",strs);
%>
<%
    request.setAttribute("nn","name");
%>

${applicationScope.ABC}
<hr/>
${param["myName"]}
</body>
</html>
