package employeeSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import employeeSpringProject.command.LoginCommand;
import employeeSpringProject.service.LoginServie;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginServie loginServie;
	@PostMapping("/login")
	public String login(@Validated LoginCommand loginCommand
			, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "index";
		}
		loginServie.execute(loginCommand, session, result);
		if(result.hasErrors()) {
			return "index";
		}
		return "redirect:/";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
}
