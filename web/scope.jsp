<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021/2/9
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("key","pageContext");
    request.setAttribute("key","request");
    session.setAttribute("key","session");
    application.setAttribute("key","application");
%>

jsp四大域对象
pagecontext:<%=pageContext.getAttribute("key")%>
request:<%=request.getAttribute("key")%>
session:<%=session.getAttribute("key")%>
application:<%=application.getAttribute("key")%>

</body>
</html>
