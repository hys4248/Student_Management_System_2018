package ml.yompc.Action;

import java.io.IOException;
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
 * Servlet implementation class addstubooks
 */
@WebServlet("/addstubooks")
public class addstubooks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String StuId =request.getParameter("StuId");
		String StudentId =request.getParameter("StudentId");
		String StuName =request.getParameter("StuName");
		String SexId =request.getParameter("SexId");
		String ClassId =request.getParameter("ClassId");
		String EnterTime =request.getParameter("EnterTime");
		
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
			
			String counstsql ="SELECT * FROM stu ORDER BY stuId ASC;";
			preparedStatement = connection.prepareStatement(counstsql);
			
			resultSet=preparedStatement.executeQuery();
			resultSet.last();
			int stuId = resultSet.getInt(1)+1;
			
			
			String sql = "INSERT INTO `stu` VALUES ('"+stuId+"','"+StudentId+"','"+StuName+"','"+SexId+"','"+ClassId+"','"+EnterTime+"','123');";
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			//request.getRequestDispatcher("bookstusview").forward(request, response);
			response.sendRedirect("bookstusview");
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
