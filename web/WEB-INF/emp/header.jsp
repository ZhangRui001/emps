<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">

    <div class="header-middle">

        <a class="sitelogo" href="#" title="Go to Start page"></a>
        <div class="sitename">
            <h1><a href="index.html" title="Go to Start page">员工管理系统<span style="font-weight:normal;font-size:50%;">—教学案例</span></a></h1>
            <h2>教育</h2>
        </div>

    </div>

    <div class="header-bottom">

        <div class="nav2 loginUserWarp">

            <ul>
                <li><a href="index.html">系统首页</a></li>
            </ul>

            <ul>
                <li><a href="#">员工管理<!--[if IE 7]><!--></a><!--<![endif]-->
                    <!--[if lte IE 6]><table><tr><td><![endif]-->
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/page/toList.do">查询员工</a></li>
                        <li><a href="#">添加员工</a></li>
                    </ul>
                    <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                </li>
            </ul>
           <div class="loginUser">
               ${loginUserMsg} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <c:if test="${!empty loginUserMsg}">
                    <a href="${pageContext.request.contextPath}/user/exit.do">退出</a>
                </c:if>
           </div>
        </div>
    </div>


    <div class="header-breadcrumbs">
        <ul>
            <li><a href="#">首页</a></li>
            <li><a href="#">用户登录</a></li>

        </ul>


    </div>
</div>