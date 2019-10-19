package com.dss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//1. Load the Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Loading Driver Is Done...");
		
		//2. Create the connection
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "manager");
		System.out.println("Connect is created successfully....."+conn);
		
		// 3.Write query
		String q1= "create table emp(eid number,ename varchar2(30),esal number)";
		
		//4.Process the query
		// carry the query from java to database: Statement
		Statement stmt= conn.createStatement();
		int x = stmt.executeUpdate(q1);
		System.out.println("Table created successfully..."+x);
		
		//5.Close the resources
		stmt.close();
		conn.close();
		System.out.println("Connection closed successfully...");
		

	}

}
