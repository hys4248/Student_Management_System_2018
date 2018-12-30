<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>状态栏</title>
<style type="text/css">
table.gridtable {
    margin-left: auto; margin-right: auto;
	font-size:11px;
	color:#333333;
	border-width: 0px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 0px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #B5F9C2;
	
}

}
a:link {color:#000000;}    /* unvisited link */
a:visited {color:#000000;} /* visited link */
a:hover {color:#F78E8E;}   /* mouse over link */
a:active {color:#FFFFFF;}  /* selected link */
*{
margin:0;
padding:0
}
#wrapper{
width:800px;
margin:auto;
}
body{text-align:center;}
</style>
</head>
<body>


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

%>

<table class="gridtable">

<tr>
    <%if("student".equals(user)==true) {%>
    
	<th><a href="Logout.jsp" class="btn blue">退出登录</a></th>
	<th> <a href="ListALLstudent" class="btn blue">图书管理</a></th>
	<th> <a href="lendtable" class="btn blue">还书</a></th><%} %>
	<%if("admin".equals(user)==true) {%>
	<th><p>管理员</p></th>
	<th><a href="Logout.jsp" class="btn blue">退出登录</a></th>
	<th> <a href="ListALLstudent" class="btn blue">图书管理</a></th>
	
	<th> <a href="bookstusview" class="btn blue">学生管理</a></th>
	<th> <a href="Borrow.jsp" class="btn blue">强制借书</a></th>
	<th> <a href="adminReturnBooks.jsp" class="btn blue">强制还书</a></th>
	<th> <a href="count" class="btn blue">每日借书统计</a></th><%} %>
	
</tr>
</table>




 

  

  

</body>
</html>