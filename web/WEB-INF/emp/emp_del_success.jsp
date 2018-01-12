<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <jsp:include page="common.jsp"/>
    <title></title>
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
            <h1 class="first">列表说明<br/></h1>
            <p>表格内显示所有员工信息</p>


        </div>

        <div class="main-content">

            <h1 class="pagetitle">删除员工</h1>


            <div class="column1-unit">
              删除成功!!!<br>

                <span id="showTime"> 5 </span> 秒后跳转到查询页面!!!

            </div>

        </div>
    </div>


    <jsp:include page="footer.jsp"/>

</div>

</body>
</html>
<script>
    (function () {
        var time = 5;
        var span  = document.getElementById("showTime")
        var  t =  setInterval(function () {
            time--;
            span.innerHTML = time;
            if(time <=0 ){
                clearInterval(t);
                window.location.href ="${pageContext.request.contextPath}/emp/listemp.do";
            }
        },1000)
    })();
    
</script>



