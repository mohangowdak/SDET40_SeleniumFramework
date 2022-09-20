package org.sdet40.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;
/**
 * This class contains all reusable actions of Database
 * @author MOHAN GOWDA
 *
 */
public  class DatabaseUtiltiy {
	private Connection connection;
	/**
	 * 
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */
	public List<String> getDataFromDatabase(String query, String columnName) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query); 
		List<String> list=new ArrayList<>();
		while(result.next()) {
			list.add(result.getString(columnName));
		}

		return list;
	}

	public void openDBConnection(String dbURL, String dbUserName, String dbPassword) throws SQLException {
		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
		connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
	}

	public void closeDB() throws SQLException {
		connection.close();
	}

	public void modifyDataIntoDB(String query) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(query); 
	}

	public boolean verifyDataInDatabase(String query, String columnName, String expectedData) throws SQLException {
		List<String> list = getDataFromDatabase(query, columnName);
		boolean flag=false;
		for(String actualData:list) {
			if (actualData.equalsIgnoreCase(expectedData)) {
				flag=true;
				break;
			}
		}
		return flag;
	}


}
