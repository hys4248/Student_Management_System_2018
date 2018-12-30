package ml.yompc;

import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addstuservlet
 */
@WebServlet("/addstuservlet")
public class addstuservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bookName = request.getParameter("bookName");
		String ISBN =request.getParameter("iSBN");
		String author =request.getParameter("author");
		String publisherId=request.getParameter("publisherId");
		String pricer=request.getParameter("pricer");
		String total=request.getParameter("total");
		String introduction=request.getParameter("introduction");
		String frontCover=request.getParameter("frontCover");
		String totalLending=request.getParameter("totalLending");
		String bookTypeId=request.getParameter("bookTypeId");
		
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
			
			
			String counstsql ="SELECT * FROM books ORDER BY bookId ASC;";
			preparedStatement = connection.prepareStatement(counstsql);
			
			resultSet=preparedStatement.executeQuery();
			resultSet.last();
			int bookId = resultSet.getInt(1)+1;
			
			
			String sql = "INSERT INTO books(`bookId`,`bookName`,`ISBN`,`author`,`publisherId`,`pricer`,`total`,`introduction`,`frontCover`,`totalLending`,`bookTypeId`) VALUES("+bookId+",'"+bookName+"','"+ISBN+"','"+author+"','"+publisherId+"','"+pricer+"','"+total+"','"+introduction+"','"+frontCover+"','"+totalLending+"','"+bookTypeId+"');";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
			
			//request.getRequestDispatcher("ListALLstudent").forward(request, response);
			response.sendRedirect("ListALLstudent");
			connection.close();
			preparedStatement.close();
			
		
		
	}catch (Exception e) {
		// TODO: handle exception
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
