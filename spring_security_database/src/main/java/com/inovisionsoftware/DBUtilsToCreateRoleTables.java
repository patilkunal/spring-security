package com.inovisionsoftware;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DBUtilsToCreateRoleTables {
	
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void createRoleTables(){
		DataSource dataSource = getDataSource();
		Connection connection =null;
		Statement statement =null;
		try {
			System.out.println("inside createRoleTables method");
			 connection = dataSource.getConnection();
			 statement = connection.createStatement();
			 System.out.println("connection - "+connection);
			 System.out.println("statement - "+statement);
			statement.executeUpdate("DROP TABLE USERS IF EXISTS");
			statement.executeUpdate("CREATE TABLE USERS(USER_ID INTEGER,USERNAME VARCHAR(50),PASSWORD VARCHAR(50),ENABLED BOOLEAN);");
			statement.executeUpdate("INSERT INTO USERS VALUES(1,'kb','1234',TRUE);");
			statement.executeUpdate("DROP TABLE USERS_ROLES IF EXISTS");
			statement.executeUpdate("CREATE TABLE USERS_ROLES(USER_ROLE_ID INTEGER,USER_ID INTEGER,ROLE VARCHAR(50));");
			statement.executeUpdate("INSERT INTO USERS_ROLES VALUES(1,1,'ROLE_ADMIN');");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
