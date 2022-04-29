package org.diginamic.fr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class TestConnexionJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			TestConnexionJdbc.getConnection();
			
		}
		catch(Exception ex){
			System.err.println(ex.getMessage());
			
		}
	}
	
	public static Connection getConnection() throws Exception{
		ResourceBundle dabaseConf = ResourceBundle.getBundle("database");

		Class.forName(dabaseConf.getString("database.driver"));
		
        return DriverManager.
                getConnection(
                		dabaseConf.getString("database.url"),
                		dabaseConf.getString("database.user"),
                		dabaseConf.getString("database.password"));
	}

}
