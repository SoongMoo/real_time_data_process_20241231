package boardSpringProject.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import boardSpringProject.service.BoardUpdateService;
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
	public List<BoardDTO> boardSelectAll(){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		conn = getConnection();
		sql = " select BOARD_NUM, BOARD_WRITER, BOARD_SUBJECT, BOARD_CONTENT"
			+ " from board ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoardContent(rs.getString("BOARD_CONTENT"));
				dto.setBoardNum(rs.getInt("BOARD_NUM"));
				dto.setBoardSubject(rs.getString("BOARD_SUBJECT"));
				dto.setBoardWriter(rs.getString("BOARD_WRITER"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public BoardDTO boardSelectOne(String boardNum) {
		BoardDTO dto = null;
		conn = getConnection();
		sql = " select BOARD_NUM, BOARD_WRITER, BOARD_SUBJECT, BOARD_CONTENT"
				+ " from board "
			+ " where board_num = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new BoardDTO();
				dto.setBoardContent(rs.getString("BOARD_CONTENT"));
				dto.setBoardNum(rs.getInt("BOARD_NUM"));
				dto.setBoardSubject(rs.getString("BOARD_SUBJECT"));
				dto.setBoardWriter(rs.getString("BOARD_WRITER"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	public void boardUpdate(BoardDTO dto) {
		conn = getConnection();
		sql = " update board "
			+ " set board_writer = ?"
			+ "    ,board_subject = ?"
			+ "    ,board_content = ? "
			+ " where board_num = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardWriter());
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			pstmt.setInt(4, dto.getBoardNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이(가) 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void boardDelete(String boardNum) {
		conn = getConnection();
		sql = " delete from board "
			+ " where board_num =? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + " 행이(가) 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
}