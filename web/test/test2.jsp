<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ye.pojo.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021/2/9
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    List<Student> students = (List<Student>) request.getAttribute("students");


%>
<table>

    <%
        for (Student s:students
             ) {
    %>

    <tr>
        <td><%=s.getId()%></td>
        <td><%=s.getName()%></td>
        <td><%=s.getAge()%></td>
        <td><%=s.getPhone()%></td>
    </tr>
       <% }%>



</table>

</body>
</html>
