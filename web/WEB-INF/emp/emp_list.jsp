<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <jsp:include page="common.jsp"/>
    <title>员工列表AJAX</title>

    <!--[if IE]>
    <style type="text/css"> body {
        word-wrap: break-word;
    }</style><![endif]-->


    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $.post("/emp/listemp.do",{"pageNo":1,"pageSize":10},function (data) {
                  if(data.success){
                    var page =data.data;//
                    $.each(page.data,function (k,v) {
                        $tr = $("<tr>").appendTo("#tb");
                        $tr.append($("<td>").html(v["id"]));
                        $tr.append($("<td>").html(v["empno"]));
                        $tr.append($("<td>").html(v["ename"]));
                        $tr.append($("<td>").html(v["hiredateStr"]));
                        $tr.append( $("<td>").append($("<a>").html("详细").attr("href","#")).append("&nbsp;").append($("<a>").html("详细").attr("href","#")).append($("<a>").html("详细").attr("href","#"))   );
                    });
                  }
            },"json");
        });
    </script>
</head>


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

            <h1 class="pagetitle">员工列表</h1>


            <div class="column1-unit">
                <table id="tb">
                    <tr>

                        <th class="top" scope="col">员工ID<br/></th>
                        <th class="top" scope="col">员工编号<br/></th>
                        <th class="top" scope="col">姓名</th>
                        <th class="top" scope="col">入职时间</th>
                        <th class="top" scope="col">操作</th>
                    </tr>

                </table>
                <p class="caption">
                    <a href="${pageContext.request.contextPath}/emp/listemp.do?pageNo=${page.firstPage}&pageSize=10">首页</a> |
                    <a href="${pageContext.request.contextPath}/emp/listemp.do?pageNo=${page.prevPage}&pageSize=10">上一页 </a>
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ${page.pageCount}/${page.pageNo}&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <a href="${pageContext.request.contextPath}/emp/listemp.do?pageNo=${page.nextPage}&pageSize=10">下一页</a> |
                    <a href="${pageContext.request.contextPath}/emp/listemp.do?pageNo=${page.lastPage}&pageSize=10">尾页 </a>
                </p>
            </div>

        </div>
    </div>


    <jsp:include page="footer.jsp"/>

</div>

</body>
</html>
<script>
    (function () {
       var allDel =  document.getElementsByClassName("del_a");
       for(var i=0;i < allDel.length;i++){
           (function (i) {
               allDel[i].onclick = function () {
                   var str  = this.getAttribute("id");//emp_del_3
                   var id = str.substring(str.lastIndexOf("_")+1);
                   if(confirm("确定要删除码?")){
                        window.location.href="${pageContext.request.contextPath}/emp/delEmp.do?id="+id;
                   }
               };
           })(i);
           

       }
    })();
</script>



