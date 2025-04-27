package springProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
