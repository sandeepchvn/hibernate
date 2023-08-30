package com.hdhdhd;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		String url="jdbc:postgresql://localhost:5432/collage";
		String user="postgres";
		String password="root";
		DriverManager.getConnection(url,user,password);
		System.out.println("done-----------!");
	}
}

