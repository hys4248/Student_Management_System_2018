<%@page import="java.util.List"%>
<%@page import="ml.yompc.Entity.publicherEntity"%>
<%@page import="ml.yompc.Entity.booktypeEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书</title>
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

<form action="addstuservlet" method="POST">
<% 
List<booktypeEntity> booktypeEntities = (List<booktypeEntity>)request.getAttribute("booktypeEntities");
%>
<%
List<publicherEntity> publicherEntities = (List<publicherEntity>)request.getAttribute("publicherEntities");
%>
图书名称:<input type="text" name="bookName" value=""><br>
ISBN:<input type="text" name="iSBN" value=""><br>
作者:<input type="text" name="author" value=""><br>
出版社：<select name="publisherId">

<%
   for(publicherEntity publicherEntity:publicherEntities)%><% {
	   
	   %>
<option value="<%=publicherEntity.getPublisherId()%>"><%=publicherEntity.getPublisher()%></option>
<%} %>
</select><br>
价格:<input type="text" name="pricer" value=""><br>
图书总数:<input type="text" name="total" value=""><br>
图书简介:<input type="text" name="introduction" value=""><br>




借出数量:<input type="text" name="totalLending" value=""><br>
图书类型：<select name="bookTypeId">

<%
   for(booktypeEntity booktypeEntity:booktypeEntities)%><% {
	   
	   %>
<option value="<%=booktypeEntity.getBookTypeId()%>"><%=booktypeEntity.getBookType()%></option>
<%} %>
</select>

<br>
<br><br>
<input type="submit" value="提交">
</form> 
</body>
</html>