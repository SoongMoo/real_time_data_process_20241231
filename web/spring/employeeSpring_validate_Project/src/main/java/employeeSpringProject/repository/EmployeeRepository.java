package employeeSpringProject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import employeeSpringProject.domain.EmployeeDTO;

@Repository
public class EmployeeRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	String sql;
	public String empNumAutoSelect() {
		sql = " select concat('emp_' , nvl(substr(max(emp_num),5),100000) + 1) from employees";
		return jdbcTemplate.queryForObject(sql, String.class);
	}
	public int employeeInsert(EmployeeDTO dto) {
		sql = " insert into employees (EMP_NUM, EMP_ID, EMP_PW, EMP_NAME, EMP_HIRE_DATE)"
			+ " values(?,?,?,?,?)";
		return jdbcTemplate.update(sql, dto.getEmpNum() 
				                      , dto.getEmpId()
				                      , dto.getEmpPw()
				                      , dto.getEmpName()
				                      , dto.getEmpHireDate());
	}
	public List<EmployeeDTO> employeeSelectAll(){
		sql = " select EMP_NUM, EMP_ID, EMP_PW, EMP_NAME, EMP_HIRE_DATE "
			+ " from employees ";
		return jdbcTemplate.query(sql
				, new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class));
	}
	
	public EmployeeDTO employeeSelectOne(String empNum) {
		sql = " select EMP_NUM, EMP_ID, EMP_PW, EMP_NAME, EMP_HIRE_DATE "
			+ " from employees "
			+ " where EMP_NUM = ?";
		return jdbcTemplate.queryForObject(sql
				, new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class)
				, empNum);
	}
	public int employeeUpdate(EmployeeDTO dto) {
		sql = " update employees "
			+ " set EMP_NAME = ? "
			+ "    ,EMP_HIRE_DATE = ? "
			+ " where EMP_NUM = ? ";
		return jdbcTemplate.update(sql, dto.getEmpName()
				                      , dto.getEmpHireDate()
				                      , dto.getEmpNum());		
	}
	public int employeeDelete(String empNum) {
		sql = " delete from employees "
			+ " where EMP_NUM = ? ";
		return jdbcTemplate.update(sql, empNum);
	}

}



