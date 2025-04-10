package boardSpringProject.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import boardSpringProject.domain.BoardDTO;

@Repository
public class BoardDAO {
	String jdbcURL;
	String jdbcDriver;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public BoardDAO() {
		jdbcURL="jdbc:oracle:thin:@localhost:1521:xe";
		jdbcDriver="oracle.jdbc.driver.OracleDriver";
	}
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(jdbcURL, "smrit", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public void boardInsert(BoardDTO dto) {
		conn = getConnection();
		String autoNum = " select nvl(max(BOARD_NUM),0) + 1 from board "; 
		sql = " insert into board(BOARD_NUM, BOARD_WRITER, BOARD_SUBJECT"
				+ "              ,BOARD_CONTENT)"
			+ " values (("+autoNum+"),?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardWriter());
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이(가) 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}