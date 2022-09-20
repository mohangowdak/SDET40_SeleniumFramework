package org.sdet40.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.sdet40.genericUtility.DatabaseUtiltiy;
import org.sdet40.genericUtility.IConstantPath;

import com.mysql.cj.jdbc.Driver;
/*
 * Naming convention:-
 * package--> org.projectName.moduleName ---> camelcase
 * class/interface ---> PascelCase
 * variable/methods---> camelCase
 * 
 * all names should be meaningfull
 */
public class FetchDataFromDataBase {
	//for DQL statement
	public static  void main(String[] args) throws SQLException {
		DatabaseUtiltiy databaseUtiltiy=new DatabaseUtiltiy();
		databaseUtiltiy.openDBConnection(IConstantPath.DB_URL, "root", "root");
		boolean status = databaseUtiltiy.verifyDataInDatabase("select * from sdet40;", "emp_name", "rohhith");
	System.out.println(status);
	}
}
