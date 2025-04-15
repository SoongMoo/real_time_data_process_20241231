package memberSpringProject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import memberSpringProject.domain.MemberDTO;

@Repository
public class MemberRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	String sql;
	public String memberNumAutoSelect() {
		sql = " select concat('mem_' , nvl(substr(max(member_num),5),100000) + 1) from members";
		/// 결과가 하나일 때는 queryForObject
		return jdbcTemplate.queryForObject(sql, String.class);
	}
	public int memberInsert(MemberDTO dto) {
		sql = " insert into members(MEMBER_NUM, MEMBER_NAME, MEMBER_ID, MEMBER_PW"
				+ "                ,MEMBER_ADDR, MEMBER_ADDR_DETAIL, MEMBER_POST"
				+ "                ,MEMBER_BIRTH) "
			+ " values(?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, dto.getMemberNum()
									  , dto.getMemberName()
									  , dto.getMemberId()
									  , dto.getMemberPw()
									  , dto.getMemberAddr()
									  , dto.getMemberAddrDetail()
									  , dto.getMemberPost()
									  , dto.getMemberBirth());
	}
	public List<MemberDTO> memberSelectAll(){
		sql = " select MEMBER_NUM , MEMBER_NAME, MEMBER_ID, MEMBER_PW"
			+ "       ,MEMBER_ADDR, MEMBER_ADDR_DETAIL, MEMBER_POST"
			+ "       ,MEMBER_BIRTH"
			+ " from members ";
		System.out.println(sql);
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}
	public MemberDTO memberSelectOne(String memberNum) {
		sql = " select MEMBER_NUM , MEMBER_NAME, MEMBER_ID, MEMBER_PW"
				+ "       ,MEMBER_ADDR, MEMBER_ADDR_DETAIL, MEMBER_POST"
				+ "       ,MEMBER_BIRTH"
				+ " from members "
				+ " where MEMBER_NUM = ?";
		return jdbcTemplate.queryForObject(sql
				, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class)
				, memberNum);
	}
	public int memberUpdate(MemberDTO dto) {
		sql = " update members "
			+ " set MEMBER_NAME = ? "
			+ "    ,MEMBER_ADDR = ? "
			+ "    ,MEMBER_ADDR_DETAIL = ? "
			+ "    ,MEMBER_POST = ? "
			+ "    ,MEMBER_BIRTH = ? "
			+ " where MEMBER_NUM = ?";
		return jdbcTemplate.update(sql, dto.getMemberName()
									  , dto.getMemberAddr()
									  , dto.getMemberAddrDetail()
									  , dto.getMemberPost()
									  , dto.getMemberBirth()
									  , dto.getMemberNum());
	}
	public int memberDelete(String memberNum) {
		sql = " delete from members "
			+ " where member_num = ? ";
		return jdbcTemplate.update(sql,memberNum);
	}
}










