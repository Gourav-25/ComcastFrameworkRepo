package com.comcast.crm.generic.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {

	Connection conn;
public void getDbConnection(String url,String un,String pswd) throws SQLException {
	try {
	 conn=DriverManager.getConnection(url,un,pswd);	
    }
catch(Exception e) {
       }
    }
public void getDbConnection() throws SQLException {
	try {
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");	
}
	catch(Exception e) {
		}
	}
	
public void closeDbConnection() throws SQLException {
	try {
	conn.close();
    }
	catch(Exception e) {
		
	}
}
 public ResultSet executeSelectQuery(String query) throws SQLException{
	 ResultSet res=null;
	 try {
	Statement stat=conn.createStatement();
	 res= stat.executeQuery(query); 		 	 
 }
	 catch(Exception e){		 
	 }
	 return res;
    }
 public int executeNonSelectQuery(String query) {
	int  result=0;
	 try {
		 Statement stat=conn.createStatement();
		  result=stat.executeUpdate(query);
	 }
	 catch(Exception e){	 
	 }
	 return result;
    }
}