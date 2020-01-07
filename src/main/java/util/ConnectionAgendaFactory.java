package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.AgendaException;

/* public class ConnectionAgendaFactory {

	public static Connection getConnection() throws AgendaException {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			return DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/agendadb","sa","");
		} catch (Exception e) {
			throw new AgendaException(e.getMessage());
		}	

	} **/
 public class ConnectionAgendaFactory {
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("jdbc:mysql://localhost/teste");
			return DriverManager.getConnection("com.mysql.jdbc.Driver", "root", "******");

		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}

	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws AgendaException {
		close(conn, stmt, rs);
	}

	public static void closeConnection(Connection conn, Statement stmt) throws AgendaException {
		close(conn, stmt, null);
	}

	public void closeConnection(Connection conn) throws AgendaException {
		close(conn, null, null);
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) throws AgendaException {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			throw new AgendaException(e.getMessage());
		}
	}
}
