<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="ml.yompc.Entity.lendtableEntity"%>
<%@page import="ml.yompc.count.countEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>统计信息</title>
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
Date date = new Date();  

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
//时间
String dateNowStr = sdf.format(date); 
%>
<table >
  <tbody>
    <tr>
<td>
<form action="count">

每日时间查询:<input type="text" name="time" value=<%=dateNowStr %>><br>
借书记录:<input type="radio" checked="checked" name="button" value="borrow" /><br>
还书记录:<input type="radio" checked="checked" name="button" value="return" /><br>
借还记录：<input type="radio" checked="checked" name="button" value="borrowreturn" /><br>
<input type="submit" value="查询">



</form>
</td>
<td>
<form action="count">

时间段查询:<input type="text" name="time1" value=<%=dateNowStr %>>至
<input type="text" name="time2" value=<%=dateNowStr %>><br>
借书记录:<input type="radio" checked="checked" name="button" value="borrow2" /><br>
还书记录:<input type="radio" checked="checked" name="button" value="return2" /><br>
借还记录：<input type="radio" checked="checked" name="button" value="borrowreturn2" /><br>
<input type="submit" value="查询">



</form>
</td>
</tr>
  </tbody>
</table>

<%
List<countEntity> countEntities=(List<countEntity>)request.getAttribute("countEntities");
%>
<table >
   <tr>
     <th>借书号</th>
     <th>书本号</th>
     <th>学生ID</th>
     <th>借书日期</th>
     <th>还书日期</th>
     <th>是否归还</th>
     
    </tr> 
    <%
    for(countEntity countEntity:countEntities){
    	%>
    	<tr>
    	   <td><%=countEntity.getLendBookId() %></td>
    	   <td><%=countEntity.getBookId() %></td>
    	   <td><%=countEntity.getStuId() %></td>
    	   <td><%=countEntity.getLendTime() %></td>
    	   <td><%=countEntity.getReturnTime() %></td>
    	   <td><%=countEntity.getReturnFlag() %></td>
    	   </tr>
    <%
    	
    	
    }
    
    
    
    
    
    %>
</body>
</html>