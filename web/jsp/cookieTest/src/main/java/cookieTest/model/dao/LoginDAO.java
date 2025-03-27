package cookieTest.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	String jdbcURL;
	String jdbcDriver;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public LoginDAO() {
		jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	}
	public Connection getConnection() {
		Connection con=  null;
		try {
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(jdbcURL, "smrit", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public String authSelect(String userId) {
		String memberPw = null;
		conn = getConnection();
		sql = " select member_pw from members "
			+ " where member_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberPw = rs.getString("member_pw");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberPw;
	}
	
	
}






