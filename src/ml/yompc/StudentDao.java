package ml.yompc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.jdbc.ServerPreparedStatement;

import ml.yompc.Entity.booktypeEntity;
import ml.yompc.Entity.publicherEntity;



public class StudentDao{
	
	String Rsqls=null;	
	   public void countsql(String Rsql) {
		   Rsqls=Rsql;
		   System.out.println(Rsql);
	   }
	



	public void deletetest(Integer bookId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/yompc?useSSL=false&useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String password = "root";
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			
			String sql = "DELETE FROM books WHERE bookId = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bookId);
			preparedStatement.executeUpdate();
			connection.close();
			preparedStatement.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		
		
		
	}
	
	public List<publicherEntity>getpublicherEntity(){
		List<publicherEntity> publicherEntitys=new ArrayList<>();
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
			String sql = "SELECT * FROM publicher;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				String publisherId = resultSet.getString(1);
				String publisher = resultSet.getString(2);
				publicherEntity publicherEntity =new publicherEntity(publisherId, publisher);
				publicherEntitys.add(publicherEntity);
			}connection.close();
			preparedStatement.close();
			resultSet.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return publicherEntitys;
		
		
		
	}
	
	public List<booktypeEntity>getbooktypeEntity(){
		List<booktypeEntity> booktypeEntities=new ArrayList<>();
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
			String sql = "SELECT * FROM booktype;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				String bookTypeId = resultSet.getString(1);
				String bookType = resultSet.getString(2);
				booktypeEntity booktypeEntity =new booktypeEntity(bookTypeId, bookType);
				booktypeEntities.add(booktypeEntity);
			}connection.close();
			preparedStatement.close();
			resultSet.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return booktypeEntities;
		
		
		
	}
	
	
	
	
	
	
	

	
	public List<student>getALL(){
		
		
		
		
		List<student> students = new ArrayList<>();
		
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
			String sql = Rsqls;
			
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				String bookId = resultSet.getString(1);
				String bookName = resultSet.getString(2);
				String iSBN = resultSet.getString(3);
				String author = resultSet.getString(4);
				String publisherId = resultSet.getString(5);
				String pricer = resultSet.getString(6);
				String total = resultSet.getString(7);
				String introduction = resultSet.getString(8);
				
				String totalLending = resultSet.getString(9);
				String bookTypeId = resultSet.getString(10);
				
				student student = new student(bookId, bookName, iSBN, author, publisherId, pricer, total, introduction, totalLending, bookTypeId);
				students.add(student);
			}
			connection.close();
			preparedStatement.close();
			resultSet.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (resultSet !=null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (preparedStatement !=null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (connection !=null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}

}
