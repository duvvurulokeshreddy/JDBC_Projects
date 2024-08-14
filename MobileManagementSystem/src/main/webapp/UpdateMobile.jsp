<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% ResultSet res = (ResultSet)request.getAttribute("mobileList");%>
<form action="UpdateMobile" method="post">
<% while(res.next()){%>
<input type="text" placeholder="Enter The mobileId" name="mobileId" value="<%= res.getString("mobileId")%>" readonly="true"><br><br>
<input type="text">
</form>
</body>
</html>