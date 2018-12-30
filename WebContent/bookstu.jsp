<%@page import="ml.yompc.Entity.bookstu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生管理</title>
<style>
table{
	
	margin-left: auto;
	margin-right: auto;
	text-align:center;
}
form{
margin-left: auto;
	margin-right: auto;
	text-align:center;
}
table thead, table tr {
border-top-width: 1px;
border-top-style: solid;
border-top-color: rgb(230, 189, 189);
}
table {
border-bottom-width: 1px;
border-bottom-style: solid;
border-bottom-color: rgb(230, 189, 189);
}

/* Padding and font style */
table td, table th {
padding: 5px 10px;
font-size: 12px;
font-family: Verdana;
color: rgb(177, 106, 104);
}

/* Alternating background colors */
table tr:nth-child(even) {
background: rgb(238, 211, 210)
}
table tr:nth-child(odd) {
background: #FFF
}



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




<%
List<bookstu> bookstus =(List<bookstu>)request.getAttribute("bookstuss");
%>
<table >
   <tr>
     <th>学生编号</th>
     <th>学号</th>
     <th>姓名</th>
     <th>性别</th>
     <th>班级</th>
     <th>入学时间</th>
     <th><a href="addstubooks.jsp">添加</a></th>
    </tr> 
    <%
    for(bookstu bookstu:bookstus){
    	%>
    	<tr>
    	    <td><%=bookstu.getStuId() %></td>
    	    <td><%=bookstu.getStudentId() %></td>
    	    <td><%=bookstu.getStuName() %></td>
    	    <td><%=bookstu.getSexId() %></td>
    	    <td><%=bookstu.getClassId() %></td>
    	    <td><%=bookstu.getEnterTime() %></td>
    	    <td><a href="deltelbook?stuId=<%=bookstu.getStuId() %>">删除</a></td>
    	    <td><a href="updatedatebookstuservlet?StuId=<%=bookstu.getStuId() %>&StudentId=<%=bookstu.getStudentId()%>&StuName=<%=bookstu.getStuName()%>&EnterTime=<%=bookstu.getEnterTime()%>">更新</a></td>
    	    <%
    	
    	
    }
    
    
    
    
    
    %>
</body>
</html>