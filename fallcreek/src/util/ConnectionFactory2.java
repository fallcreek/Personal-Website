package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class ConnectionFactory2 {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	
	private static final ConnectionFactory2 factory = new ConnectionFactory2();
	private Connection conn;
	
	static
	{
		Properties prop = new Properties();
		try {
			InputStream in = ConnectionFactory2.class.getClassLoader()
					.getResourceAsStream("dbconfig2.properties");
			prop.load(in);
		} catch (Exception e) {
			System.out.println("error1");
			e.printStackTrace();
		}
		
		driver = prop.getProperty("driver");	
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}
	
	private ConnectionFactory2()
	{
		
	}
	
	public static ConnectionFactory2 getInstance()
	{
		return factory;
	}
	
	public Connection makeConnection()
	{
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl,user,password);
		} catch (Exception e) {
			System.out.println("error2");
			e.printStackTrace();
		}
		return conn;
	}
}
