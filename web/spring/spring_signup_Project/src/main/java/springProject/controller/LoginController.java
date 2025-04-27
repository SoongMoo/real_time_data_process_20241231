package springProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import springProject.command.LoginCommand;
import springProject.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;
	@PostMapping("/login")
	public String login(@Validated LoginCommand loginCommand
			,BindingResult result, HttpSession session
			,HttpServletResponse response) {
		if(result.hasErrors()) {
			return "index";
		}
		loginService.execute(loginCommand, result, session, response);
		if(result.hasErrors()) {
			return "index";
		}
		return "redirect:/";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session, HttpServletResponse response) {
		Cookie cookie = new Cookie("autoLogin","");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		session.invalidate();
		return "redirect:/";
	}
}


