package ml.yompc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ml.yompc.Entity.booktypeEntity;
import ml.yompc.Entity.publicherEntity;

/**
 * Servlet implementation class updateservlet
 */
@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		StudentDao studentDao = new StudentDao();
		List<booktypeEntity> booktypeEntities=studentDao.getbooktypeEntity();
		List<publicherEntity> publicherEntities=studentDao.getpublicherEntity();
		request.setAttribute("publicherEntities", publicherEntities);
		request.setAttribute("booktypeEntities", booktypeEntities);
		
		String bookId = request.getParameter("bookId");
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
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/yompc?useSSL=false&useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String password = "root";
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			String sql = "UPDATE `yompc`.`books` SET `total`='"+total+"',`bookName` = '"+bookName +"',`ISBN`='"+ISBN+"',`author`='"+author+"',`publisherId`='"+publisherId+"',`pricer`='"+pricer+"',`introduction`='"+introduction+"',`frontCover`='"+frontCover+"',`totalLending`='"+totalLending+"',`bookTypeId`='"+bookTypeId+"' WHERE `bookId` = '"+bookId+"'; ";
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
			
			
			//request.getRequestDispatcher("ListALLstudent").forward(request, response);
			
			response.sendRedirect("ListALLstudent");
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
