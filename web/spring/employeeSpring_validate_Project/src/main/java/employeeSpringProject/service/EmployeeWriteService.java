package employeeSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import employeeSpringProject.command.EmployeeCommand;
import employeeSpringProject.domain.EmployeeDTO;
import employeeSpringProject.repository.EmployeeRepository;

@Service
public class EmployeeWriteService {
	@Autowired
	PasswordEncoder  passwordEncoder;
	@Autowired
	EmployeeRepository employeeRepository;
	public void execute(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpHireDate(employeeCommand.getEmpHireDate());
		dto.setEmpId(employeeCommand.getEmpId());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpNum(employeeCommand.getEmpNum());
		dto.setEmpPw(passwordEncoder.encode(employeeCommand.getEmpPw()));
		employeeRepository.employeeInsert(dto);
	}
}


