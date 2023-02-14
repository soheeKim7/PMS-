package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface DAO {
	Connection getConnection();
	void closeDBResources(ResultSet rs, Statement stmt, Connection conn);
}
