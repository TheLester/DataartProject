package service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TestUtilities {
	Connection conn = null;
	static TestUtilities test=null;
	
	public TestUtilities() {
		conn=setUpDB();
	}
	
	public void cleanDB() {
		Statement stmt = null;
		try {
			stmt = (Statement) conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "DELETE FROM Arrangements";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static TestUtilities getInstance() {
		if (test==null) {
			test=new TestUtilities();	
		}
		return test;
	}
	
	private Connection setUpDB() {
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/LOGDB";
		String USER = "root";
		String PASS = "123";
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/* Returns date from its string representation */
	public Date getDate(String year, String month, String day) {
		 GregorianCalendar newGregCal = new GregorianCalendar(
		     Integer.parseInt(year),
		     Integer.parseInt(month) - 1,
		     Integer.parseInt(day)
		 );
		return newGregCal.getTime();
	}
}
