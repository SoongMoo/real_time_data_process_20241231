package employeeSpringProject.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import employeeSpringProject.domain.EmployeeDTO;
import employeeSpringProject.repository.EmployeeRepository;

@Service
public class EmployeeListService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void execute(Model model) {
		List<EmployeeDTO> list = employeeRepository.employeeSelectAll();
		model.addAttribute("list", list);
	}
}




