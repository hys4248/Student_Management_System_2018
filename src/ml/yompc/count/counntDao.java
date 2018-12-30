package ml.yompc.count;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class counntDao {
   String countql=null;	
   public void countsql(String countsql) {
	   countql=countsql;
	   System.out.println(countsql);
   }
	
	
	
	public List<countEntity>getcountALL(){
	  List<countEntity> countEntities=new ArrayList<>();
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
			String sql=countql;
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				String lendBookId = resultSet.getString(1);
				String bookId = resultSet.getString(2);
				String stuId = resultSet.getString(3);
				String lendTime = resultSet.getString(4);
				String returnTime = resultSet.getString(5);
				String returnFlag = resultSet.getString(6);
				countEntity countEntity=new countEntity(lendBookId, bookId, stuId, lendTime, returnTime, returnFlag);
				countEntities.add(countEntity);
			}
			
			
			connection.close();
			preparedStatement.close();
			resultSet.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	  
	return countEntities;
	 
  }
  
	
}
