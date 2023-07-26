package com.ems.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getdbConnection() {
		try {
			//executing the static block of DBDRIVER class to load the drivers 
			Class.forName(DbDetails.DBDRIVER);
			Connection con = DriverManager.getConnection(DbDetails.CONSTR, 
					DbDetails.USERNAME, DbDetails.PASSWORD);
			return con;
		} catch (ClassNotFoundException  | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
