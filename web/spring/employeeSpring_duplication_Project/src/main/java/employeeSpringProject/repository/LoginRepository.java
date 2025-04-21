package employeeSpringProject.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import employeeSpringProject.domain.AuthInfoDTO;

@Repository
public class LoginRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace="loginMapperSql";
	String statement;
	public AuthInfoDTO loginSelect(String userId) {
		statement = namespace + ".loginSelectOne";
		return sqlSession.selectOne(statement, userId);
	}
	
	
	
	
	
	
	
}
