package jspMVCHKShopping.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public UserDAO() {
		jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	}
	public Connection getConnection() {
		Connection co = null;
		try {
			Class.forName(jdbcDriver);
			co = DriverManager.getConnection(jdbcURL, "smrit", "1234");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return co;
	}
	public AuthInfoDTO loginSelectOne(String userId) {
		AuthInfoDTO dto = null;
		con = getConnection();
		sql = " select member_id userId, member_pw userPw, member_name userName"
			+ "      , member_Email userEmail, 'mem' grade"
			+ " from members "
			+ " where member_id = ? "
			+ " union "
			+ " select EMP_ID, EMP_PW, EMP_NAME, EMP_EMAIL, 'emp' "
			+ " from employees "
			+ " where EMP_ID = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new AuthInfoDTO();
				dto.setGrade(rs.getString("grade"));
				dto.setUserEmail(rs.getString("userEmail"));
				dto.setUserId(rs.getString("userId"));
				dto.setUserName(rs.getString("userName"));
				dto.setUserPw(rs.getString("userPw"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	public void userInsert(MemberDTO dto) {
		con = getConnection();
		String userNum = " select concat('mem_', nvl(substr(max(MEMBER_NUM),5),100000) + 1 )from members";
		sql = " insert into members(MEMBER_NUM, MEMBER_NAME, MEMBER_ID, MEMBER_PW"
				+ "               ,MEMBER_ADDR, MEMBER_ADDR_DETAIL, MEMBER_POST"
				+ "               ,MEMBER_REGIST, GENDER, MEMBER_PHONE1, MEMBER_PHONE2"
				+ "               ,MEMBER_EMAIL, MEMBER_BIRTH) "
			+ " values (("+userNum+"), ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?) ";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberName());
			pstmt.setString(2, dto.getMemberId());
			pstmt.setString(3, dto.getMemberPw());
			pstmt.setString(4, dto.getMemberAddr());
			pstmt.setString(5, dto.getMemberAddrDetail());	
			pstmt.setString(6, dto.getMemberPost());
			pstmt.setString(7, dto.getMemberGender());
			pstmt.setString(8, dto.getMemberPhone1());
			pstmt.setString(9, dto.getMemberPhone2());
			pstmt.setString(10, dto.getMemberEmail());
			pstmt.setString(11, dto.getMemberBirth());
			int i = pstmt.executeUpdate();
			System.out.println(i + " 행이(가) 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
}
