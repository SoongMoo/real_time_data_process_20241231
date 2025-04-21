package employeeSpringProject.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DuplicationRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "duplicationSql";
	String statement;
	public String userIdSelectOne(String userId) {
		statement = namespace + ".userIdSelectOne";
		return sqlSession.selectOne(statement, userId);
	}
	public String userEmailSelectOne(String userEmail) {
		statement = namespace + ".userEmailSelectOne";
		return sqlSession.selectOne(statement, userEmail);
	}
}
