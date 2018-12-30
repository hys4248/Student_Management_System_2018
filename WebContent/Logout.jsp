<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退出成功</title>
</head>
<body>
<%
Cookie cookie = new Cookie("name", "users");
Cookie cookies = new Cookie("user", "users");
cookie.setMaxAge(0);
cookies.setMaxAge(0);

response.addCookie(cookie);
response.addCookie(cookies);
response.sendRedirect("Login.jsp");
%>

</body>
</html>