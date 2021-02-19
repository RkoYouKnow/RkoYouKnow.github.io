<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021/2/9
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九九乘法表</title>
</head>
<body>

<table>


    <%for (int i = 1; i < 9; i++) {%>

<tr>
        <%for (int j = 1; j <= i; j++) {%>



         <td>   <%=j+"*"+i+"="+(i*j)%></td>




    <% }%>
</tr>

<%
    }
%>
</table>
</body>
</html>
