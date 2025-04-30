package springProject.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springProject.domain.AuthInfoDTO;
import springProject.domain.MemberDTO;
import springProject.domain.UserChangePasswordDTO;

@Repository
public class MemberRepository{
	@Autowired
	SqlSession sqlSession;
	String namespace="memberSql";
	String statement;
	public int memberInsert(MemberDTO dto) {
		statement = namespace + ".memberInsert";
		return sqlSession.insert(statement, dto);
	}
	public AuthInfoDTO loginSelectOne(String userId) {
		statement = namespace + ".loginSelectOne";
		return sqlSession.selectOne(statement, userId);
	}
	public int userPwUpdate(UserChangePasswordDTO dto) {
		statement = namespace + ".userPwUpdate";
		return sqlSession.update(statement, dto);		
	}
	public Integer emailCheckUpdate(String userId) {
		statement = namespace + ".emailCheckUpdate";
		return sqlSession.update(statement, userId);
	}
	public List<String> selectId(Map<String , String > map) {
		statement = namespace + ".selectId";
		return sqlSession.selectList(statement, map);
	}
	
}


