package springProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // rest API  <===> ajax와 연동
//html(jsp)문서가 아닌 데이터를 전송할 때,DTO, Map, List, String, int
public class IndexRestController {
	@GetMapping("/")
	public String index() {
		return "안녕하세요.";  
	}
	@GetMapping("/emp")
	public EmployeeDTO emp() {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpId("아이디");
		return dto;
	}
}
