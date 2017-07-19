package com.revature.abstracts;

import java.sql.DriverManager;
import java.sql.SQLException;

import static com.revature.constants.ConnectionInfo.*;
public interface Connection {
	public default java.sql.Connection getCon() {
		java.sql.Connection connection = null;		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			connection.setAutoCommit(true);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//overload to allow for acquiring a non-auto committing connection object
	public default java.sql.Connection getCon(boolean autocommit){
		java.sql.Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			connection.setAutoCommit(autocommit);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
