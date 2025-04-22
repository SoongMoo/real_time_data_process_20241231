package springProject.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springProject.domain.MemberDTO;

@Repository
public class MemberRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace="memberSql";
	String statement;
	public int memberInsert(MemberDTO dto) {
		statement = namespace + ".memberInsert";
		return sqlSession.insert(statement, dto);
	}
}


