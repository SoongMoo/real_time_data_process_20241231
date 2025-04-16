package employeeSpringProject.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import employeeSpringProject.repository.EmployeeRepository;

@Service
public class EmployeeDeleteService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void execute(String empNum) {
		employeeRepository.empDelete(empNum);
	}
}
