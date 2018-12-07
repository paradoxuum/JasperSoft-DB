package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;	

public class JdbcUtil {
	private static String connectionDriverClass="com.mysql.jdbc.Driver";
	private static String connectionUrl="jdbc:mysql://localhost/java?useUnicode=true&useSSL=true&useJDBCCompliantTimezonShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String connectionUsername="root";
	private static String connectionPassword="";
	private static Connection conn;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		if(JdbcUtil.conn != null) {
			return JdbcUtil.conn;
		}else {
			Class.forName(connectionDriverClass);
			return conn = DriverManager.getConnection(
					JdbcUtil.connectionUrl,
					JdbcUtil.connectionUsername,
					JdbcUtil.connectionPassword);
		}
	}
	
	public static void close () throws SQLException {
		if(conn != null) conn.close();
		conn = null;
	}
}

