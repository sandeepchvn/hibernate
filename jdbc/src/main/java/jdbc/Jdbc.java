package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1st step Load the Driver
		Class.forName("org.postgresql.Driver");

		// 2nd step Create Connection
		String url = "jdbc:postgresql://localhost:5432/tyss";
		String userName = "postgres";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, userName, password);
		
		//3rd step Create Statement or Platform
		CallableStatement callableStatement=connection.prepareCall("call create_person(2,'xyz',567)");
		callableStatement.execute();
		//4th step execute the Query
	
		
	
		//5th step
		connection.close();
		
	}
}
