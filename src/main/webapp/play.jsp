<html>
  <head><title>UFO</title></head>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
String message = (String) request.getAttribute("message");
String option1 = (String) request.getAttribute("option1");
String option2 = (String) request.getAttribute("option2");
%>

                <body>
                    <p><%= message %></p>
                    <form action="start" method="post">
                        <input type="radio" name="option" value="option1"> <%= option1 %> <br>
                        <input type="radio" name="option" value="option2"> <%= option2 %> <br>
                        <input type="submit" value="Надіслати відповідь">
                    </form>
                </body>
</html>