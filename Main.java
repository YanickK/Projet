package com.geo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Load your JDBC driver:
		Class.forName("org.sqlite.JDBC");
		
		//Connect to the DB		
		Connection conn = DriverManager.getConnection("jdbc:sqlite:/path/to/your/db/demo.db");
                
        //Prepare the query:
		Statement stat = conn.createStatement();
        ResultSet rs=stat.executeQuery("SELECT * from your_table");
        
        //Loop through results:
        while(rs.next()){
        	System.out.println(rs.getString("column_name"));
        }
        
        //Close Connection:
        conn.close();

	}

}
