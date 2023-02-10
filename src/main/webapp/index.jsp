<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div></div>

<table>
        <thead>
          <tr>
              <th>Select the page you want to Visit</th>    
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><a href="addNewUserPage.jsp">Add New User</a></td>
          </tr>
          <tr>
            <td><a href="loginPage.jsp">Login User </a></td>
            </tr>
          <tr>
            <td><a href="searchUserPage.jsp">Search User</a></td>
           </tr>
           <tr>
            <td><a href="deleteUserPage.jsp">Delete User</a></td>
           </tr>
           <tr>
            <td><a href="updatePage.jsp">Update User</a></td>
           </tr>
        </tbody>
      </table>


</body>
</html>