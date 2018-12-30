<%@page import="ml.yompc.Dao.lendtable"%>
<%@page import="ml.yompc.Entity.lendtableEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>还书</title>
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
if(user==null){
	
	response.sendRedirect("error.html");
	out.print(username);
}


%>
 <%
 List<lendtableEntity> lendtableEntities=(List<lendtableEntity>)request.getAttribute("lendtables");
 %>
 <table>
   <tr>
     <th>借书号</th>
     <th>书本号</th>
     <th>书名</th>
     <th>姓名</th>
     <th>借书时间</th>
     <th>是否归还</th>
     
    </tr> 
    <%
    for(lendtableEntity lendtableEntity:lendtableEntities){
    	%>
    	<tr>
    	    <td><%=lendtableEntity.getLendBookId() %></td>
    	    <td><%=lendtableEntity.getBookId() %></td>
    	    <td><%=lendtableEntity.getBookName() %></td>
    	    <td><%=lendtableEntity.getStuName() %></td>
    	    <td><%=lendtableEntity.getLendTime() %></td>
    	    <td><%=lendtableEntity.getReturnFlag() %></td>
    	    <td><a href="Returnbooks?StuId=<%=username %>&lendBookId=<%=lendtableEntity.getLendBookId() %>&bookId=<%=lendtableEntity.getBookId()%>">还书</a></td>
    	    
    	    </tr>
    	    	    <%
    	
    	
    }
    
    
    
    
    
    %>

</body>
</html>