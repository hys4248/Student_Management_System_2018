package ml.yompc.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ml.yompc.Entity.bookstu;


public class bookstuDao {
	public void deletebookstu(Integer stuId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/yompc?useSSL=false&useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String password = "root";
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			
			String sql = "DELETE FROM stu WHERE stuId = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, stuId);
			preparedStatement.executeUpdate();
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

	
	public List<bookstu>getbookAll(){
		List<bookstu> bookstus = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet =null;
		try {
			
			
			
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/yompc?useSSL=false&useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String password = "root";
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			String sql = "SELECT a.`stuId`,a.`studentId`,a.`stuName`,CASE a.`sexId` WHEN 0 THEN '女' ELSE '男' END AS sex,b.`className`,a.`enterTime` FROM stu AS a LEFT JOIN classtable AS b ON a.`classId` = b.`classId`;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String stuId =resultSet.getString(1);
				String studentId =resultSet.getString(2);
				String stuName = resultSet.getString(3);
				String sexId=resultSet.getString(4);
				String classId=resultSet.getString(5);
				String enterTime=resultSet.getString(6);
				bookstu bookstu = new bookstu(stuId, studentId, stuName, sexId, classId, enterTime);
				bookstus.add(bookstu);
			}
			
			connection.close();
			preparedStatement.close();
			resultSet.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookstus;
	
		
		
	}
	

}
