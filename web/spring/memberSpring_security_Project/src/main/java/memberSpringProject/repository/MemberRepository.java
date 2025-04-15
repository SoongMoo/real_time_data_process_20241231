package memberSpringProject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import memberSpringProject.domain.MemberDTO;

@Repository
public class MemberRepository {
	String sql;
	@Autowired
	JdbcTemplate jdbcTemplate;    
	public String autoMemberNum() { // mem_100001
		// jdbcTemplate.queryForObject : row가 하나일 때
		sql = " select concat('mem_' , nvl(substr(max(member_num),5),100000) + 1) from members " ;
		System.out.println(sql);
		return jdbcTemplate.queryForObject(sql, String.class);
	}
	public int memberInsert(MemberDTO dto) {
		//jdbcTemplate.update() : insert, update, delete
		//String memberNum = autoMemberNum();
		sql = " insert into members(member_num, member_id, member_pw, member_name ) "
			+ " values( ? , ?, ?, ?) ";
		return jdbcTemplate.update(sql, dto.getMemberNum(), dto.getMemberId()
									  , dto.getMemberPw(),dto.getMemberName());
	}
	
	public List<MemberDTO> memberSelectAll(){
		sql = " select member_num, member_id, member_pw, member_name "
			+ " from members ";
		// query: list
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}
	
	public MemberDTO memberSelectOne(String memberNum) {
		sql = " select member_num, member_id, member_pw, member_name "
			+ " from members "
			+ " where member_num = ?"	;
			// dto : queryForObject
		return jdbcTemplate.queryForObject(sql
				, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class)
				, memberNum);
	}
	public int memberUpdate(MemberDTO dto) {
		sql = " update members "
			+ " set   member_name = ? "
			+ " where member_num = ?";
		return jdbcTemplate.update(sql, dto.getMemberName(), dto.getMemberNum()); 
	}
	public int memberDelete(String memberNum) {
		sql = " delete from members "
			+ " where member_num = ?";
		return jdbcTemplate.update(sql, memberNum); 
	}
	//IOC : Inversion of Control(제어의 역전)
}








