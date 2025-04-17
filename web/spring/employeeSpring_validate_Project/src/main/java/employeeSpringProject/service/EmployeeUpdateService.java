package employeeSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import employeeSpringProject.command.EmployeeCommand;
import employeeSpringProject.domain.EmployeeDTO;
import employeeSpringProject.repository.EmployeeRepository;

@Service
public class EmployeeUpdateService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	PasswordEncoder  passwordEncoder;
	public int execute(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = employeeRepository.employeeSelectOne(employeeCommand.getEmpNum());
		int i = 0;
		if(passwordEncoder.matches(employeeCommand.getEmpPw(), dto.getEmpPw())) {
			dto = new EmployeeDTO();
			dto.setEmpHireDate(employeeCommand.getEmpHireDate());
			dto.setEmpName(employeeCommand.getEmpName());
			dto.setEmpNum(employeeCommand.getEmpNum());
			employeeRepository.employeeUpdate(dto);
			i = 1;
		}
		return i;
	}
}
