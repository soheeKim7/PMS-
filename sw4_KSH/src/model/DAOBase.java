package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOBase implements DAO {

	@Override
	public Connection getConnection() {
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String db_url = "jdbc:mysql://127.0.0.1:3306/sw4_ksh";
		try {
			Class.forName(jdbc_driver);
			Connection conn = DriverManager.getConnection(db_url, "mit", "pw1234pw1234");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void closeDBResources(ResultSet rs, Statement stmt, Connection conn) {
		if(rs!= null) try{ rs.close(); } catch (SQLException e){e.printStackTrace();} 
		if(stmt != null) try{ stmt.close(); } catch (SQLException e){e.printStackTrace();} 
		if(conn  != null) try{ conn.close(); } catch (SQLException e){e.printStackTrace();} 

	}

}
