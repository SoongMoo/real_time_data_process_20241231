package employeeSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import employeeSpringProject.command.EmployeeCommand;
import employeeSpringProject.service.EmployeeAutoNumService;
import employeeSpringProject.service.EmployeeDeleteService;
import employeeSpringProject.service.EmployeeDetailService;
import employeeSpringProject.service.EmployeeListService;
import employeeSpringProject.service.EmployeeUpdateService;
import employeeSpringProject.service.EmployeeWriteService;

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
	public String form(/* @ModelAttribute("employeeCommand") EmployeeCommand employeeCommand */
			Model model) {
		employeeAutoNumService.execute(model);
		return "employee/empForm";
	}

	@Autowired
	EmployeeWriteService employeeWriteService;

	@PostMapping("/empWrite")
	public String write(@Validated EmployeeCommand employeeCommand
			, BindingResult result) {
		if(result.hasErrors()) {
			return "employee/empForm";
		}
		if (!employeeCommand.isEmpPwEquealsEmpPwCon()) {
			result.rejectValue("empPwCon", "pwConErr", "비밀번호 확인이 일치하지 않습니다.");
			return "employee/empForm";
		}
		employeeWriteService.execute(employeeCommand);
		return "redirect:empList";
	}

	@Autowired
	EmployeeDetailService employeeDetailService;

	@GetMapping("/empDetail")
	public String info(String empNum, Model model) {
		employeeDetailService.execute(empNum, model);
		return "employee/empDetail";
	}

	@GetMapping("/empUpdate")
	public String update(String empNum, Model model) {
		employeeDetailService.execute(empNum, model);
		return "employee/empUpdate";
	}

	@Autowired
	EmployeeUpdateService employeeUpdateService;

	@PostMapping("/empUpdate")
	public String update(@Validated  EmployeeCommand employeeCommand
			, BindingResult result) {
		if(result.hasErrors()) {
			return "employee/empUpdate";
		}
		int i = employeeUpdateService.execute(employeeCommand);
		if (i == 0) {
			result.rejectValue("empPw", "employeeCommand.empPw", "비밀번호가 틀렸습니다.");
			return "employee/empUpdate";
		}
		return "redirect:empDetail?empNum=" + employeeCommand.getEmpNum();
	}

	@Autowired
	EmployeeDeleteService employeeDeleteService;

	@GetMapping("/empDelete")
	public String delete(String empNum) {
		employeeDeleteService.execute(empNum);
		return "redirect:empList";
	}
}
