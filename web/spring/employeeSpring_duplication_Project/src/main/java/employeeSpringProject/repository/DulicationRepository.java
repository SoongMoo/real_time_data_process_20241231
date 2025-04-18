package employeeSpringProject.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
// 마이바티스는 xml파일과 연동을 해야 한다.
public class DulicationRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "duplicationSql";
	String statement;
	public String idCheckSelectOne(String userId) {
		statement = namespace + ".idcheck";
		return sqlSession.selectOne(statement, userId);
	}
}
