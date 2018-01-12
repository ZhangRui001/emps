<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl　demo</title>
    <style>
        table {
            width: 300px;
        }

        table, td {
            border: 1px solid #666666;
            border-collapse: collapse;
        }

        .bg {
            background: #ccc;
        }

    </style>
</head>
<body>

<table>
    <c:forEach items="${data}" var="e" varStatus="status">
     <%--   <c:if test="${status.count%2==0}">
            <tr class="bg">
        </c:if>
        <c:if test="${status.count%2==1}">
            <tr >
        </c:if>--%>

        <c:choose>
            <c:when test="${status.count%2==0}">
                <tr>
            </c:when>
            <c:otherwise>
                <tr class="bg">
            </c:otherwise>
        </c:choose>

        <td>${status.count}</td>
        <td>${e}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
