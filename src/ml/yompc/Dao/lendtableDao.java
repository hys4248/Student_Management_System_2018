package ml.yompc.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ml.yompc.Entity.lendtableEntity;

public class lendtableDao {
	int usernames = 0;
	public void lendtablestu(Integer username) {
		usernames=username;
	}
	
	
	public List<lendtableEntity>getlendtableAll(){
		List<lendtableEntity> lendtableEntities = new ArrayList<>();
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
			String sql ="SELECT a.lendBookId,a.bookId,b.bookName,c.stuName,a.lendTime,CASE a.returnFlag WHEN 0 THEN '否' ELSE'男' END AS returnFlag FROM lendtable AS a JOIN books AS b ON a.bookId=b.bookId JOIN stu AS c ON a.stuId=c.studentId WHERE a.stuId="+usernames+" AND a.returnFlag=0;";
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String lendBookId =resultSet.getString(1);
				String bookId =resultSet.getString(2);
				String bookName =resultSet.getString(3);
				String stuName = resultSet.getString(4);
				String lendTime=resultSet.getString(5);
				String returnFlag=resultSet.getString(6);
				lendtableEntity lendtable = new lendtableEntity(lendBookId, bookId, bookName, stuName, lendTime, returnFlag);
				lendtableEntities.add(lendtable);
				
			}connection.close();
			preparedStatement.close();
			resultSet.close();}catch (Exception e) {
				e.printStackTrace();
			}
            

			return lendtableEntities;
		
		
		
		
		
	
	}
}
