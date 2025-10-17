package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.collections4.functors.CatchAndRethrowClosure;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn;
	public void getDbconnection(String URL,String username,String password) throws SQLException {
		try{
		Driver  driver = new Driver();
		
		DriverManager.registerDriver(driver);
		
	 conn=	DriverManager.getConnection(URL,username,password);
	}
	catch (Exception e) {
	}
		
	}
	public void getDbconnection() throws SQLException {
		try{
		Driver  driver = new Driver();
		
		DriverManager.registerDriver(driver);
		
	 conn=	DriverManager.getConnection("jsbc:mysql://localhost:3306/projects","roots","roots");
	}
	catch (Exception e) {
	}
		
	}
	public void closeDbconnection() throws SQLException {
		try {
		conn.close();
		}
		catch(Exception e) {
			
		}
	}
	
	
	
	public ResultSet ExecuteSelectQuery(String query) throws SQLException {
		ResultSet result=null;
	try {	
	Statement sta =	conn.createStatement();
	 result =sta.executeQuery(query);
	}
	catch(Exception e) {
		
	}
	return result;
	}
	public int executeNonselectQuery(String query) {
		int result=0;
		try {
			Statement sta =	conn.createStatement();
		result =	sta.executeUpdate(query);
		}
		catch(Exception e) {
			
		}
		return result;
	}
}
