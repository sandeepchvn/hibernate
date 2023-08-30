package com.tyss.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class CreateConnection {
	public static void main(String[] args) throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		String URl="jdbc:postgresql://localhost:5432/collage";
		String userName="postgres";
		String password="root";
		DriverManager.getConnection(URl,userName,password);
		System.out.println("connection is established");
	}
}
