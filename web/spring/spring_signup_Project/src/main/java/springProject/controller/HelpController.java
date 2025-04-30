package springProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springProject.service.help.FindIdService;
import springProject.service.help.FindPwService;

@Controller
@RequestMapping("/help")
public class HelpController {
	@GetMapping("/findPassword")
	public String findPassword() {
		return "help/findPw";
	}
	@Autowired
	FindPwService findPwService;
	@PostMapping("/findPassword")
	public String findPassword(String userId, String userPhone, Model model) {
		findPwService.execute(userId, userPhone, model);
		return "help/findPwOk";
	}
	@GetMapping("/findId")
	public String findId() {
		return "thymeleaf/help/findId";
	}
	@Autowired
	FindIdService findIdService;
	@PostMapping("/findId")
	public String findId(String userPhone, String userEmail, Model model) {
		findIdService.execute(userPhone, userEmail, model);
		return "thymeleaf/help/findIdOk"; // 찾은 아이디 출력
	}
	
}







