package springProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springProject.command.LoginCommand;

@Controller
public class IndexController {
	@GetMapping("/")
	public String index(LoginCommand loginCommand) {
		return "index";
	}
}
