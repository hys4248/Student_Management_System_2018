<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加学生</title>
<style type="text/css">
body{text-align:center;}/*针对老式浏览器*/
#wrapper{margin:0 auto;width:1000px;}/*要指定宽度*/
</style>
</head>
<body>
<jsp:include page="test.jsp" flush="true" /><br>

<%
String username = null;
String user=null;
Cookie[] cookies = request.getCookies();
if(cookies != null && cookies.length > 0)
{
    for(Cookie c : cookies)
    {
        if(c.getName().equalsIgnoreCase("name"))
        {
            username = c.getValue();
            
       }
        if(c.getName().equalsIgnoreCase("user"))
        {
            user = c.getValue();
            
       }
       
       
    }
}
if(username==null){
	
	response.sendRedirect("error.html");
	out.print(username);
}
if("admin".equals(user)==false){
	
	response.sendRedirect("error.html");
	out.print(username);
}


%>

<form action="addstubooks" method="POST">

学生编号:<input type="text" name="StuId" value=""><br>
学号:<input type="text" name="StudentId" value=""><br>
姓名:<input type="text" name="StuName" value=""><br>
性别:<input type="text" name="SexId" value=""><br>
性别：<select name="SexId">
<option value="1">男</option>
<option value="0">女</option>
</select><br>
班级:<input type="text" name="ClassId" value=""><br>
入学时间:<input type="text" name="EnterTime" value=""><br>
<input type="submit" value="提交">

</form>
</body>
</html>