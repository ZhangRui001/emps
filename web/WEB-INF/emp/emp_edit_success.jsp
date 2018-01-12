<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html
        xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <jsp:include page="common.jsp"/>
    <title></title>
    <style type="text/css">
        .readonly{
            background: #ccc;
        }
    </style>
</head>

<!--[if IE]>
<style type="text/css">
    body {
        word-wrap: break-word;
    }</style><![endif]-->
<body>
<div class="page-container">


    <jsp:include page="header.jsp"/>


    <div class="main">

        <div class="main-navigation">

            <div class="round-border-topright"></div>
            <h1 class="first">修改员工<br/></h1>
            <p>修改员工信息并保存<br/></p>


        </div>

        <div class="main-content">

            <h1 class="pagetitle">修改员工信息</h1>


            <div class="column1-unit">
                <div>${employee.ename} ---->已经被更新</div>
            </div>

        </div>
    </div>


    <jsp:include page="footer.jsp"/>
</div>

</body>
</html>



