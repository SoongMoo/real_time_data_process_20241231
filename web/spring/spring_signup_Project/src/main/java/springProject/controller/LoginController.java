package springProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springProject.command.LoginCommand;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;
	@PostMapping("/login")
	public String login(@Validated LoginCommand loginCommand
			,BindingResult result) {
		if(result.hasErrors()) {
			return "index";
		}
		loginService.execute(loginCommand);
		return "redirect:/";
	}
}
