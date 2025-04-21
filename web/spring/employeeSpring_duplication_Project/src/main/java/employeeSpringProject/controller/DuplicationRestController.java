package employeeSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employeeSpringProject.service.UserEmailCheckService;
import employeeSpringProject.service.UserIdCheckService;


/// csr
@RestController // Rest API : html문서를 넘기는 것이 아니라 문자열, dto, list, map
@RequestMapping("/duplication")
public class DuplicationRestController {
	@Autowired
	UserIdCheckService userIdCheckService;
	@PostMapping("/idCheck")
	public String idCheck(String userId) {
		return userIdCheckService.execute(userId);
	}
	@Autowired
	UserEmailCheckService userEmailCheckService;
	@PostMapping("/emailCheck")
	public String emailCheck(String userEmail) {
		return userEmailCheckService.execute(userEmail);
	}
	
	
	
	
	
	
	
}
