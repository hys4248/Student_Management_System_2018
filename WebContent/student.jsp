<%@page import="ml.yompc.Entity.publicherEntity"%>
<%@page import="ml.yompc.Entity.booktypeEntity"%>
<%@page import="java.util.List"%>
<%@page import="ml.yompc.student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>有民图书管理系统</title>
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
<form action="ListALLstudent" method="POST">
<% 
List<booktypeEntity> booktypeEntities = (List<booktypeEntity>)request.getAttribute("booktypeEntities");
%>
<%
List<publicherEntity> publicherEntities = (List<publicherEntity>)request.getAttribute("publicherEntities");
%>
图书类型：<select name="bookTypeId">
<option value="null">*</option>
<%
   for(booktypeEntity booktypeEntity:booktypeEntities)%><% {
	   
	   %>
<option value="<%=booktypeEntity.getBookTypeId()%>"><%=booktypeEntity.getBookType()%></option>
<%} %>
</select>



出版社：<select name="publisherId">
<option value="null">*</option>
<%
   for(publicherEntity publicherEntity:publicherEntities)%><% {
	   
	   %>
<option value="<%=publicherEntity.getPublisherId()%>"><%=publicherEntity.getPublisher()%></option>
<%} %>
</select>

图书名:<input type="text" name="bookName" value="">

<input type="submit" value="提交">
</form>








<%
/**
String username=null;

Cookie cookie = null;
Cookie[] cookies = null;
// 获取cookies的数据,是一个数组
cookies = request.getCookies();
if( cookies != null ){
  
   for (int i = 0; i < cookies.length; i++){
      cookie = cookies[i];
     
      username= cookie.getValue();
     
   }
}else{
	response.sendRedirect("error.html");
}


**/

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
List<student> stus = (List<student>)request.getAttribute("students");
%>
<table>
   <tr>
     <th>图书编号</th>
   
	 <th>图书名称</th>
	 <th>ISBN</th>
	 <th>作者</th>
	 <th>出版社</th>
	 <th>价格</th>
	 
	 <th>图书简介</th>
	 <th>图书总数</th>
	 <th>借出数量</th>
	 <th>图书类型</th>
	 <%if("admin".equals(user)==true) {%>
	 <th><a href="addstu">添加</a></th>
   <%} %>
   
   
   </tr>
   <%
   for(student student:stus)%><% {
	   
	   %>
	   <tr>
	      <td><%= student.getBookId() %></td>
	      
	      <td><%= student.getBookName() %></td>
	      
	      <td><%= student.getISBN() %></td>
	      <td><%= student.getAuthor() %></td>
	      <td><%= student.getPublisherId() %></td>
	      <td><%= student.getPricer() %></td>
	      
	      <td><%= student.getIntroduction() %></td>
	      
	      
	      <td><%= student.getTotal()%></td>
	      <td><%= student.getTotalLending()%></td>
	      <td><%= student.getBookTypeId() %></td>
	      <%if("admin".equals(user)==true) {%>
	      <td><a href="deleteStudent?bookId=<%=student.getBookId() %>">删除</a></td>
	      <td><a href="updatestudent?bookId=<%=student.getBookId() %>&bookName=<%=student.getBookName()%>&iSBN=<%=student.getISBN()%>&author=<%=student.getAuthor()%>&publisherId=<%=student.getPublisherId()%>&pricer=<%=student.getPricer()%>&total=<%=student.getTotal()%>&totalLending=<%=student.getTotalLending()%>&bookTypeId=<%=student.getBookTypeId()%>">更新</a></td>
	      <%} %>
	      <%if("student".equals(user)==true) {%>
	      <td><a href="Borrow?StuId=<%=username %>&bookId=<%=student.getBookId() %>">借书</a>  </td> 
	      <%} %>
	    
	    
	   
	   </tr> 
	   
	   <%}%>
	        
	 
   
   
  
  



</table>

</body>
</html>