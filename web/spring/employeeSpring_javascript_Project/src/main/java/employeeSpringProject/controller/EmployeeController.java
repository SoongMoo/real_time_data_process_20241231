package employeeSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import employeeSpringProject.command.EmployeeCommand;
import employeeSpringProject.service.employee.EmployeeAutoNumService;
import employeeSpringProject.service.employee.EmployeeDeleteService;
import employeeSpringProject.service.employee.EmployeeDetailService;
import employeeSpringProject.service.employee.EmployeeListService;
import employeeSpringProject.service.employee.EmployeeUpdateService;
import employeeSpringProject.service.employee.EmployeeWriteService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeListService employeeListService;
	@GetMapping("/empList")
	public String list(Model model) {
		employeeListService.execute(model);
		return "employee/empList";
	}
	@Autowired
	EmployeeAutoNumService employeeAutoNumService;
	@GetMapping("/empWrite")
	public String write(Model model) {
		employeeAutoNumService.execute(model);
		return "employee/empForm";
	}
	@Autowired
	EmployeeWriteService employeeWriteService;
	@PostMapping("/empWrite")
	public String write(EmployeeCommand employeeCommand) {
		employeeWriteService.execute(employeeCommand);
		return "redirect:empList";
	}
	@Autowired
	EmployeeDetailService employeeDetailService ;
	@GetMapping("/empDetail")
	public String detail(String empNum, Model model) {
		employeeDetailService.execute(empNum, model);
		return "employee/empDetail";
	}
	
	@GetMapping("/empUpdate")
	public String update(String empNum , Model model) {
		employeeDetailService.execute(empNum, model);
		return "employee/empUpdate";
	}
	
	@Autowired
	EmployeeUpdateService employeeUpdateService ;
	@PostMapping("/empUpdate")
	public String update(EmployeeCommand employeeCommand, Model model) {
		int i = employeeUpdateService.execute(employeeCommand);
		if(i == 1)
			return "redirect:empDetail?empNum="+employeeCommand.getEmpNum();
		else {
			employeeDetailService.execute(employeeCommand.getEmpNum(), model);
			model.addAttribute("errPw", "비밀버호가 틀렸습니다.");
			return "employee/empUpdate";
		}
	}
	
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	@GetMapping("/empDelete")
	public String delete(String empNum) {
		employeeDeleteService.execute(empNum);
		return "redirect:empList";
	}
	
}









