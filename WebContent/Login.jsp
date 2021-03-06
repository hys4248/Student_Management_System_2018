<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>有民图书管理系统</title>
<link href="css/1.css" rel="stylesheet">
	<link href="css/2.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
<style type="text/css">
		.form-bg{
		    padding: 2em 0;
		}
		.form-horizontal{
		    background: #fff;
		    padding-bottom: 40px;
		    border-radius: 15px;
		    text-align: center;
		}
		.form-horizontal .heading{
		    display: block;
		    font-size: 35px;
		    font-weight: 700;
		    padding: 35px 0;
		    border-bottom: 1px solid #f0f0f0;
		    margin-bottom: 30px;
		}
		.form-horizontal .form-group{
		    padding: 0 40px;
		    margin: 0 0 25px 0;
		    position: relative;
		}
		.form-horizontal .form-control{
		    background: #f0f0f0;
		    border: none;
		    border-radius: 20px;
		    box-shadow: none;
		    padding: 0 20px 0 45px;
		    height: 40px;
		    transition: all 0.3s ease 0s;
		}
		.form-horizontal .form-control:focus{
		    background: #e0e0e0;
		    box-shadow: none;
		    outline: 0 none;
		}
		.form-horizontal .form-group i{
		    position: absolute;
		    top: 12px;
		    left: 60px;
		    font-size: 17px;
		    color: #c8c8c8;
		    transition : all 0.5s ease 0s;
		}
		.form-horizontal .form-control:focus + i{
		    color: #00b4ef;
		}
		.form-horizontal .fa-question-circle{
		    display: inline-block;
		    position: absolute;
		    top: 12px;
		    right: 60px;
		    font-size: 20px;
		    color: #808080;
		    transition: all 0.5s ease 0s;
		}
		.form-horizontal .fa-question-circle:hover{
		    color: #000;
		}
		.form-horizontal .main-checkbox{
		    float: left;
		    width: 20px;
		    height: 20px;
		    background: #11a3fc;
		    border-radius: 50%;
		    position: relative;
		    margin: 5px 0 0 5px;
		    border: 1px solid #11a3fc;
		}
		.form-horizontal .main-checkbox label{
		    width: 20px;
		    height: 20px;
		    position: absolute;
		    top: 0;
		    left: 0;
		    cursor: pointer;
		}
		.form-horizontal .main-checkbox label:after{
		    content: "";
		    width: 10px;
		    height: 5px;
		    position: absolute;
		    top: 5px;
		    left: 4px;
		    border: 3px solid #fff;
		    border-top: none;
		    border-right: none;
		    background: transparent;
		    opacity: 0;
		    -webkit-transform: rotate(-45deg);
		    transform: rotate(-45deg);
		}
		.form-horizontal .main-checkbox input[type=checkbox]{
		    visibility: hidden;
		}
		.form-horizontal .main-checkbox input[type=checkbox]:checked + label:after{
		    opacity: 1;
		}
		.form-horizontal .text{
		    float: left;
		    margin-left: 7px;
		    line-height: 20px;
		    padding-top: 5px;
		    text-transform: capitalize;
		}
		.form-horizontal .btn{
		    float: right;
		    font-size: 14px;
		    color: #fff;
		    background: #00b4ef;
		    border-radius: 30px;
		    padding: 10px 25px;
		    border: none;
		    text-transform: capitalize;
		    transition: all 0.5s ease 0s;
		}
		@media only screen and (max-width: 479px){
		    .form-horizontal .form-group{
		        padding: 0 25px;
		    }
		    .form-horizontal .form-group i{
		        left: 45px;
		    }
		    .form-horizontal .btn{
		        padding: 10px 20px;
		    }
		}
	</style>
</head>
<body>
<%
String username = null;

Cookie[] cookies = request.getCookies();
if(cookies != null && cookies.length > 0)
{
    for(Cookie c : cookies)
    {
        if(c.getName().equalsIgnoreCase("name"))
        {
            username = c.getValue();
            
       }
       
       
    }
}
if(username!=null){
	
	response.sendRedirect("ListALLstudent");
	out.print("欢迎,"+username);
}

%>
<div class="demo form-bg">
	        <div class="container">
	            <div class="row">
	                <div class="col-md-offset-3 col-md-6">
	                    <form action="Login" method="POST" class="form-horizontal">
	                        <span class="heading">用户登录</span>
	                        <div class="form-group">
								
	                           用户名 <input type="text" name="user" class="form-control" id="inputEmail3" placeholder="">
	                            <i></i>
	                        </div>
	                        <div class="form-group help">
	                           密码 <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="">
	                            <i ></i>
	                            
	                        </div>
	                        <div class="form-group">
	                            <div class="main-checkbox">
	                                <input type="radio"  checked="checked" id="checkbox1" name="button" value="student"/>
	                                <label for="checkbox1"></label>
	                            </div>
	                            <span class="text">学生</span>
								<div class="main-checkbox">
	                                <input type="radio"  id="checkbox2" name="button" value="admin"/>
	                                <label for="checkbox2"></label>
	                            </div>
	                            <span class="text">管理员</span>
	                            
								<input type="submit" class="btn btn-default" value="登陆">
								
	                        </div>
	                    </form>
	                </div>
	            </div>
	        </div>
	    </div>





</body>
</html>