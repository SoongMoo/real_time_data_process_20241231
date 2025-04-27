package springProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import springProject.command.LibraryCommand;
import springProject.command.LoginCommand;
import springProject.command.MailCommand;
import springProject.domain.AuthInfoDTO;
import springProject.repository.MemberRepository;
import springProject.service.EmailService;
import springProject.service.library.LibraryInsertService;
import springProject.service.library.LibraryListService;

@Controller
public class IndexController {
	@Autowired
	MemberRepository memberRepository;
	@GetMapping("/") // "/" : root
	public String index(@ModelAttribute("loginCommand") LoginCommand loginCommand
			, HttpServletRequest request) {
		Cookie [] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("idStore")) {
					System.out.println("idStore 쿠키가 있어요.");
					loginCommand.setIdStore(true);
					loginCommand.setUserId(cookie.getValue());
				}
				if(cookie.getName().equals("autoLogin")) {
					System.out.println("autoLogin 쿠키가 있어요.");
					String userId = cookie.getValue();
					AuthInfoDTO auth = memberRepository.loginSelectOne(userId);
					///쿠키를 이용해서 로그인 session을 만들어주는 것이 자동 로그인이다.
					HttpSession session = request.getSession();
					session.setAttribute("auth", auth);
				}
			}
		}
		return "index";
	}
	
	@GetMapping("/mailling")
	public String mailSend() {
		return "email";
	}
	@Autowired
	EmailService emailService; 
	@PostMapping("/mailling")
	public String mailSend(MailCommand mailCommand) {
		emailService.execute(mailCommand);
		return "redirect:/";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
