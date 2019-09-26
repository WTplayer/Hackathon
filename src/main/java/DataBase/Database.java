package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	static String databaseURL = "jdbc:ucanaccess://C://Users//teren//Desktop//Hackathon_2019//Hackathon_BDD.accdb";
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		return DriverManager.getConnection(databaseURL);
	}

}


