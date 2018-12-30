package ml.yompc.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Borrow
 */
@WebServlet("/Borrow")
public class Borrow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Borrow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String StuId = request.getParameter("StuId");
			String bookId = request.getParameter("bookId");
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet =null;
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/yompc?useSSL=false&useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String password = "root";
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			
			
			
			//检查书本数量
			String total ="SELECT total,totalLending FROM books WHERE bookId="+bookId+";";
			preparedStatement = connection.prepareStatement(total);
			resultSet=preparedStatement.executeQuery();
			resultSet.next();
			int total1 = resultSet.getInt(1);
			int totalLending =resultSet.getInt(2);
			System.out.println(total1+"I"+totalLending);
			if (total1<=totalLending) {
				
				response.sendRedirect("error.html");
				
			}else {
			
			
			try {
				Date date = new Date();  
		         
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		        String dateNowStr = sdf.format(date);  
		        
		
				//检查是否匹配用户名和书名
				String BVsql ="SELECT books.bookId,stu.stuId FROM books,stu WHERE books.bookId="+bookId+" AND stu.studentId ="+StuId+";";
				preparedStatement = connection.prepareStatement(BVsql);
				resultSet=preparedStatement.executeQuery();
				resultSet.next();
				int books = resultSet.getInt(1);
				int stu =resultSet.getInt(2);
				
				
				
				
				//获取ID
				String counstsql ="SELECT * FROM lendtable ORDER BY lendBookId ASC;";
				preparedStatement = connection.prepareStatement(counstsql);
				resultSet=preparedStatement.executeQuery();
				resultSet.last();
				int lendBookId = resultSet.getInt(1)+1;
				
				
				
				
				
				connection.setAutoCommit(false);
				
				String sql="INSERT INTO `yompc`.`lendtable` (`lendBookId`,`bookId`,`stuId`,`lendTime`,`returnFlag`)VALUES('"+lendBookId+"','"+bookId+"','"+StuId+"','"+dateNowStr+"','0');";
				
				
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				connection.commit();
				String sql2="UPDATE books SET totalLending = totalLending+1 WHERE bookId='"+bookId+"';";
				
				preparedStatement = connection.prepareStatement(sql2);
				
				preparedStatement.executeUpdate();
				connection.commit();
				response.sendRedirect("ListALLstudent");
			} catch (Exception e) {
				//response.sendRedirect("error.html");
				
			}}
			
			
			
			//request.getRequestDispatcher("ListALLstudent").forward(request, response);
			
			connection.close();
			preparedStatement.close();
			resultSet.close();
			
		}catch (Exception e) {
			response.sendRedirect("error.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
