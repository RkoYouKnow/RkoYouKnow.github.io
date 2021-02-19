<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021/2/9
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        out.write("ww");
        out.flush();
        out.write("ss");
        response.getWriter().write("re");
    %>

    <br/>

    <%
        out.print(12);
        out.write(12);
    %>



</body>
</html>
