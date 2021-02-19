<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021/2/11
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getScheme()+"://"+
            request.getServerName()+":"
            +request.getServerPort()+
            request.getContextPath()+"/";

    pageContext.setAttribute("path",path);
%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="<%=path%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>

