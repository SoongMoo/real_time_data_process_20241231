package employeeSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import employeeSpringProject.SpringSecurityConfig;
import employeeSpringProject.service.IdcheckService;

@RestController
@RequestMapping("/duplication")
public class DuplicationRestController {
	@Autowired
	IdcheckService idcheckService;
  
	@PostMapping("/userIdCheck")
	public String idcheck(String userId) {
		return idcheckService.execute(userId);
	}
}
