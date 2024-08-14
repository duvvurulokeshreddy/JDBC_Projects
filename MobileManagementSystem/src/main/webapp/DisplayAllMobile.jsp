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
mobile
	<%
ResultSet rs = (ResultSet) request.getAttribute("mobile");
%>
	<table border="">
		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt("mobileId")%></td>
			<td><%=rs.getString("mobileModel")%></td>
			<td><%=rs.getString("mobileBrand")%></td>
			<td><%=rs.getInt("mobilePrice")%></td>
			<td><a href="UpdateMobile?MobileId=<%=rs.getInt("mobileid")%>">Update</a></td>
			<td><a href="DeleteMobile?MobileId=<%=rs.getInt("mobileid")%>">Delete</a></td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>