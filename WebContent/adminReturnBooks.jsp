<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>强制还书</title>
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
<table >
  <tbody>
    <tr>
      <td><h1>强制还书</h1></td>
    </tr>
    <tr>
     <form action="Returnbooks">
      <td>借书编号：<input type="text" name="lendBookId" value=""><br>
图书编号：<input type="text" name="bookId" value=""><br></td>
    </tr>
    <tr>
      <td><input type="submit" value="提交"></td>
	</form>
    </tr>
  </tbody>
</body>
</html>