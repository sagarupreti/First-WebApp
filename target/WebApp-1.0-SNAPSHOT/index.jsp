<%@page import="com.cibt.Web.entity.Student"%>
<%@page import="com.cibt.Web.dao.impl.StudentDAOimpl"%>
<%@page import="com.cibt.Web.dao.StudentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="shared/header.jsp" %>
    
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
         <th>contact NO</th>
          <th>Status</th>
    </tr>
    <% 
        StudentDAO studentDAO=new StudentDAOimpl();
        for(Student student:studentDAO.getAll()){
    %>
    <tr>
        <td><%=student.getId()%></td>
        <td><%=student.getFirstName()%> <%=student.getLastName()%> </td>
        <td><%=student.getEmail()%></td>
        <td><%=student.getContactNo()%></td>
        <td><%=student.isStatus()%></td>
    </tr>
    <%
        }
    %>
</table>

    </body>
</html>