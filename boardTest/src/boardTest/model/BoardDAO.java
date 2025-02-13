package boardTest.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	public String jdbcURL;
	public String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public BoardDAO(){ // 객체가 생성될 때 멤버필드에 값을 주기 위해 사용 : 생성자
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	}
	public Connection getConnection() { // 디비연결
		Connection conn = null;
		try {
		Class.forName(jdbcDriver);
		conn = DriverManager.getConnection(jdbcURL, "rhsm", "1234");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public List<BoardDTO> boardList(){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		con = getConnection();
		sql = " select board_num, user_id, board_name , board_subject, board_content "
			+ " from board";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoardNum(rs.getInt("board_num"));
				dto.setBoardContent(rs.getString("board_content"));
				dto.setBoardName(rs.getString("board_name"));
				dto.setBoardSubject(rs.getString("board_subject"));
				dto.setUserId(rs.getString("user_id"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void boardInsert(BoardDTO dto) {
		con = getConnection(); // db 연결 정보를 전달	
		sql = "insert into board(board_num, user_id, board_name , board_subject, board_content)"
		    + "values ( (select max(board_num) + 1 from board) , ?, ?, ?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getBoardName());
			pstmt.setString(3, dto.getBoardSubject());
			pstmt.setString(4, dto.getBoardContent());
			int i = pstmt.executeUpdate();
			System.out.println( i + " 행 이(가) 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}


