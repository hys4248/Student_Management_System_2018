package ml.yompc.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String users = request.getParameter("user");
       String passwords=request.getParameter("password");
       String button =request.getParameter("button");
       
       if ("student".equals(button)==true) {
        Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/yompc?useSSL=false&useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String password = "root";
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			try {
				String BVsql ="SELECT studentId,`password` FROM stu WHERE studentId='"+users+"' AND `password`='"+passwords+"';";
				preparedStatement = connection.prepareStatement(BVsql);
				resultSet=preparedStatement.executeQuery();
				resultSet.next();
				String books = resultSet.getString(1);
				String stu =resultSet.getString(2);
				Cookie cookie = new Cookie("name", users);
				Cookie cookies = new Cookie("user", button);
				cookie.setMaxAge(60*60*24);
				cookies.setMaxAge(60*60*24);
				
		        response.addCookie(cookie);
		        response.addCookie(cookies);
		        response.sendRedirect("ListALLstudent");
				System.out.print("a");
			} catch (Exception e) {
				response.sendRedirect("error.html");
				System.out.print("b");
			}
		
			
       

		
		
		
		
		}catch (Exception e){
			System.out.print("b1");
		}
		
		
		
		
		
		
	}
       if ("admin".equals(button)==true) {
    	   System.out.println("admin");
           Connection connection = null;
   		PreparedStatement preparedStatement = null;
   		ResultSet resultSet =null;
   		try {
   			String driverClass = "com.mysql.jdbc.Driver";
   			String url = "jdbc:mysql://localhost:3306/yompc?useSSL=false&useUnicode=true&characterEncoding=utf8";
   			String user = "root";
   			String password = "root";
   			Class.forName(driverClass);
   			connection = DriverManager.getConnection(url, user, password);
   			try {
   				String BVsqls ="SELECT `user`,`password` FROM admin WHERE `user`='"+users+"' AND `password`='"+passwords+"';";
   				System.out.println(BVsqls);
   				preparedStatement = connection.prepareStatement(BVsqls);
   				resultSet=preparedStatement.executeQuery();
   				resultSet.next();
   				String books = resultSet.getString(1);
				String stu =resultSet.getString(2);
   				
   				Cookie cookie = new Cookie("name", users);
   				cookie.setMaxAge(60*60*24);
   				Cookie cookies = new Cookie("user", button);
   				
   				cookies.setMaxAge(60*60*24);
   				
   		        response.addCookie(cookie);
   		        response.addCookie(cookies);
   		        
   		        response.sendRedirect("ListALLstudent");
   				
   			} catch (Exception e) {
   				response.sendRedirect("error.html");
   				System.out.println("识别");
   			}
   		
   			
          

   		
   		
   		
   		
   		}catch (Exception e){
   			System.out.print("b1");
   		}
   		
   		
   		
   		
   		
   		
   	}

}}
