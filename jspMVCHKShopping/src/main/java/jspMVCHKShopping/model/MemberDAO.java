package jspMVCHKShopping.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public MemberDAO() {
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
	
	public void memberPwUpdate(String memberId, String newPw) {
		con = getConnection();
		sql = " update members "
			+ " set member_pw = ? "
			+ " where member_id = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setString(2, memberId);
			int i = pstmt.executeUpdate();
			System.out.println(i + " 행이(가) 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void memberDelete(String memberNum) {
		con = getConnection();
		sql = " delete from  members where member_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + " 행이(가) 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public MemberDTO memberSelectOne(String memberNum) { // memberNum, memberId
		MemberDTO dto  = null;
		con = getConnection();
		sql = " select MEMBER_NUM, MEMBER_NAME, MEMBER_ID, MEMBER_PW"
				+ "		 , MEMBER_ADDR, MEMBER_ADDR_DETAIL, MEMBER_POST"
				+ "		 , MEMBER_REGIST, GENDER, MEMBER_PHONE1, MEMBER_PHONE2"
				+ "		 , MEMBER_EMAIL, MEMBER_BIRTH "
				+ " from members "
				+ " where MEMBER_NUM = ? or member_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			pstmt.setString(2, memberNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setMemberNum(rs.getString(1));
				dto.setMemberName(rs.getString("MEMBER_NAME"));
				dto.setMemberId(rs.getString(3));
				dto.setMemberPw(rs.getString(4));
				dto.setMemberAddr(rs.getString(5));
				dto.setMemberAddrDetail(rs.getString("MEMBER_ADDR_DETAIL"));
				dto.setMemberPost(rs.getString(7));
				dto.setMemberRegist(rs.getString(8));
				dto.setMemberGender(rs.getString(9));
				dto.setMemberPhone1(rs.getString(10));
				dto.setMemberPhone2(rs.getString(11));
				dto.setMemberEmail(rs.getString(12));
				dto.setMemberBirth(rs.getString(13));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	public void memberUpdate(MemberDTO dto) {
		con = getConnection();
		sql = " update members "
			+ " set MEMBER_NAME = ?  "
			+ "    ,MEMBER_ADDR = ? "
			+ "    ,MEMBER_ADDR_DETAIL = ?"
			+ "    ,MEMBER_POST = ?"
			+ "    ,GENDER = ? "
			+ "    ,MEMBER_PHONE1 = ?"
			+ "    ,MEMBER_PHONE2 = ?"
			+ "    ,MEMBER_EMAIL = ? "
			+ " where member_num = ? or member_id = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(10, dto.getMemberId());
			pstmt.setString(9, dto.getMemberNum());
			pstmt.setString(1, dto.getMemberName());
			pstmt.setString(2, dto.getMemberAddr());
			pstmt.setString(3, dto.getMemberAddrDetail());
			pstmt.setString(4, dto.getMemberPost());
			pstmt.setString(5, dto.getMemberGender());
			pstmt.setString(6, dto.getMemberPhone1());
			pstmt.setString(7, dto.getMemberPhone2());
			pstmt.setString(8, dto.getMemberEmail());
			
			int i = pstmt.executeUpdate();
			System.out.println(i + " 행이(가) 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<MemberDTO> memberSelectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		con = getConnection();
		sql = " select MEMBER_NUM, MEMBER_NAME, MEMBER_ID, MEMBER_PW"
			+ "		 , MEMBER_ADDR, MEMBER_ADDR_DETAIL, MEMBER_POST"
			+ "		 , MEMBER_REGIST, GENDER, MEMBER_PHONE1, MEMBER_PHONE2"
			+ "		 , MEMBER_EMAIL, MEMBER_BIRTH "
			+ " from members ";
		try {
			pstmt =con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setMemberNum(rs.getString(1));
				dto.setMemberName(rs.getString("MEMBER_NAME"));
				dto.setMemberId(rs.getString(3));
				dto.setMemberPw(rs.getString(4));
				dto.setMemberAddr(rs.getString(5));
				dto.setMemberAddrDetail(rs.getString("MEMBER_ADDR_DETAIL"));
				dto.setMemberPost(rs.getString(7));
				dto.setMemberRegist(rs.getString(8));
				dto.setMemberGender(rs.getString(9));
				dto.setMemberPhone1(rs.getString(10));
				dto.setMemberPhone2(rs.getString(11));
				dto.setMemberEmail(rs.getString(12));
				dto.setMemberBirth(rs.getString(13));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			
		return list;
	}
	public String selectAutoNum() {
		String memberNum = null;
		con = getConnection();
		sql = " select concat('mem_', nvl(substr(max(member_num),5),100000) + 1) "
			+ " from members";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			memberNum = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberNum;
	}
	public void memberInsert(MemberDTO dto) {
		con = getConnection();
		sql = " insert into members (MEMBER_NUM, MEMBER_NAME, MEMBER_ID, MEMBER_PW"
			+ "                    , MEMBER_ADDR, MEMBER_ADDR_DETAIL, MEMBER_POST"
			+ "                    , MEMBER_REGIST, GENDER, MEMBER_PHONE1, MEMBER_PHONE2"
			+ "                    , MEMBER_EMAIL, MEMBER_BIRTH) "
			+ " values (?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?) ";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getMemberNum());
				pstmt.setString(2, dto.getMemberName());
				pstmt.setString(3, dto.getMemberId());
				pstmt.setString(4, dto.getMemberPw());
				pstmt.setString(5, dto.getMemberAddr());
				pstmt.setString(6, dto.getMemberAddrDetail());
				pstmt.setString(7, dto.getMemberPost());
				pstmt.setString(8, dto.getMemberGender());
				pstmt.setString(9, dto.getMemberPhone1());
				pstmt.setString(10, dto.getMemberPhone2());
				pstmt.setString(11, dto.getMemberEmail());
				pstmt.setString(12, dto.getMemberBirth());
				int i = pstmt.executeUpdate();
				System.out.println(i + " 행이(가) 삽입되었습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		
		
	}
}













