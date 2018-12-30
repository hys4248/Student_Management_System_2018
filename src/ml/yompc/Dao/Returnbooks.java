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

/**
 * Servlet implementation class Returnbooks
 */
@WebServlet("/Returnbooks")
public class Returnbooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Returnbooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lendBookId = request.getParameter("lendBookId");
		//String Stuid = request.getParameter("StuId");
		String bookId=request.getParameter("bookId");
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
				Date date = new Date();  
		         
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		        //时间
		        String dateNowStr = sdf.format(date);  
		        
		        connection.setAutoCommit(false);
		        //AO的还书
		        String sql="UPDATE lendtable SET returnFlag=1,returnTime='"+dateNowStr+"' WHERE lendBookId="+lendBookId+";";
		        preparedStatement = connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				connection.commit();
				//books的还书
				String sql2="UPDATE books SET totalLending = totalLending-1 WHERE bookId="+bookId+";";
				System.out.println(sql2);
                preparedStatement = connection.prepareStatement(sql2);
				
				preparedStatement.executeUpdate();
				connection.commit();
				
} catch (Exception e) {
				
				response.sendRedirect("error.html");
			}
			
			
			
			//request.getRequestDispatcher("ListALLstudent").forward(request, response);
			response.sendRedirect("lendtable");
			
			connection.close();
			preparedStatement.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		//response.sendRedirect("lendtable");
		   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
