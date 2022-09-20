package org.sdet40.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
/*
 * Naming convention:-
 * package--> org.projectName.moduleName ---> camelcase
 * class/interface ---> PascelCase
 * variable/methods---> camelCase
 * 
 * all names should be meaningfull
 */
public class ModifyDataIntoDataBase {
	//for DDL, DML statement
	public static  void main(String[] args) throws SQLException {
		//step 1---> create the object for Driver
		Driver dbdriver=new Driver();
		//step 2---> register the driver instance to the jdbc
		DriverManager.registerDriver(dbdriver);
		//Step 3 --> get/estrablish the database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
		try {
			//Step 4 ---> create the statement
			Statement statement = connection.createStatement();
			//Step 5 ---> Execute the query
			int result = statement.executeUpdate("insert into sdet40 values(1005,'Mohan',8674521,'Shimoga');"); 
			//Step 6 ---> Verify or `	 the data
			System.out.println(result+" Data updated successfully");
		}
		finally {
			//Step 7 --> close the db connection 
			connection.close();//mandatory 
			System.out.println("Connection closed successfully");
		}
	}
}
