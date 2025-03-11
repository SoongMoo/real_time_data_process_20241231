package jspBoardMVCProject.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	String jdbcURL;// 오라클 주소
	String jdbcDriver;// 오라클에 접속하기 위한 API
	Connection con;// 오라클 접속정보
	PreparedStatement pstmt; // sql문을 실행하기 위해서 사용 
	String sql; // sql문
	ResultSet rs;
	public BoardDAO() {
		jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	}
	public Connection getConnection() {
		Connection co = null;
		try {
		Class.forName(jdbcDriver);
		co = DriverManager.getConnection(jdbcURL, "rhsm", "1234");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return co;
	}
	public void boardDelete(int boardNum) {
		con = getConnection();
		sql = " delete from board "
			+ " where board_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			int i = pstmt.executeUpdate();
			System.out.println( i + " 행이(가) 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void boardUpdate(BoardDTO dto) {
		con = getConnection();
		sql = "update board "
			+ " set board_name = ? ,"    //1
			+ "     board_subject = ?, "  //2
			+ "     board_content = ? "  //3
			+ " where board_num = ? ";   //4
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardName());
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			pstmt.setInt(4, dto.getBoardNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + " 행이(가) 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public BoardDTO boardSelectOne(int boardNum) {
		BoardDTO dto = null;
		con = getConnection();
		sql = " select BOARD_NUM, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT "
			+ " from board "
			+ " where board_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery(); 
			if(rs.next()) {
				dto = new BoardDTO(); // record가 있을 때만 dto를 생성
				dto.setBoardNum(rs.getInt("BOARD_NUM"));		
				dto.setBoardName(rs.getString("BOARD_NAME"));
				dto.setBoardSubject(rs.getString("BOARD_SUBJECT"));
				dto.setBoardContent(rs.getString("BOARD_CONTENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	public List<BoardDTO> boardSelectAll() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		con=getConnection();
		sql = " select BOARD_NUM, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT "
			+ " from board ";
		try {
			pstmt = con.prepareStatement(sql);
			/*  select인 recordSet은 resultSet으로 받아온다. */
			/* recode는 dto이다. */ 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(); // record : 한행
				dto.setBoardNum(rs.getInt("BOARD_NUM"));
				dto.setBoardName(rs.getString("BOARD_NAME"));
				dto.setBoardSubject(rs.getString("BOARD_SUBJECT"));
				dto.setBoardContent(rs.getString("BOARD_CONTENT"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void boardInsert(BoardDTO dto) {
		con = getConnection();
		String autoNum = "select nvl(max(board_num),0) + 1 from board";
		sql = " insert into board(BOARD_NUM, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT) "
			+ " values ( (" + autoNum + "), ?, ?, ?) ";
		//                                  1  2  3
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardName());
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이(가) 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}




