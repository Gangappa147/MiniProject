<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
out.println("Dear"+" "+session.getAttribute("sname")+" "+"login successfully");
%>
<a href="carDetails.html">enter car details</a><br>
<a href="editcarDetails.html">Edit car details</a><br>
<a href="serviceRequest.html">Service Request</a><br>
<a href="serviceStatus.html">Status</a>
</body>
</html>