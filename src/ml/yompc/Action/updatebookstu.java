package ml.yompc.Action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ml.yompc.Entity.bookstu;

/**
 * Servlet implementation class updatebookstu
 */
@WebServlet("/updatebookstu")
public class updatebookstu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatebookstu() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/yompc?useSSL=false&useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String password = "root";
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			String sql = "UPDATE `yompc`.`stu` SET `studentId` = '"+StudentId+"' , `stuName` = '"+StuName+"' , `sexId` = '"+SexId+"' , `classId` = '"+ClassId+"' , `enterTime` = '"+EnterTime+"' WHERE `stuId` = '"+StuId+"'; " ;
			
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
