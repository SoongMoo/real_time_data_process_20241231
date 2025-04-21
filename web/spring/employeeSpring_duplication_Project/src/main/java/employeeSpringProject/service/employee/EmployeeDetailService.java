package employeeSpringProject.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import employeeSpringProject.domain.EmployeeDTO;
import employeeSpringProject.repository.EmployeeRepository;

@Service
public class EmployeeDetailService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void execute(String empNum, Model model) {
		EmployeeDTO dto = employeeRepository.employeeSelectOne(empNum);
		model.addAttribute("employeeCommand", dto);
	}
}
