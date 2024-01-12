<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
String message = (String) request.getAttribute("message");
%>
<body>
<h2><p><%= message %></p></h2>
<a href="start">Грати ще рааз</a>
</body>
</html>