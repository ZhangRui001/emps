<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <jsp:include page="common.jsp"/>
    <title></title>
    <style type="text/css">
        .err {
            color: orangered;
        }

    </style>
</head>

<!--[if IE]>
<style type="text/css"> body {
    word-wrap: break-word;
}</style><![endif]-->

<body>
<div class="page-container">


    <jsp:include page="header.jsp"/>


    <div class="main">

        <div class="main-navigation">

            <div class="round-border-topright"></div>
            <h1 class="first">用户注册<br/></h1>
            <p></p>


        </div>

        <div class="main-content">

            <h1 class="pagetitle">用户添加成功</h1>


            <div class="column1-unit">
                用户名:${user.name}<br>
                密码:${user.password}<br/>
                <img src="${pageContext.request.contextPath}${user.image}" alt="头像"/>
            </div>

        </div>
    </div>


    <jsp:include page="footer.jsp"/>

</div>

</body>
</html>

<script>

    (function () {
        document.getElementById("codeImage").onclick = function () {
            this.src = "${pageContext.request.contextPath}/getCode?ab=" + Math.random();
        }
    })();
</script>


