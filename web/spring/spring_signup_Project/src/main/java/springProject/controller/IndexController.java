package springProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import springProject.command.LoginCommand;
import springProject.command.MailCommand;
import springProject.repository.MemberRepository;
import springProject.service.CookieService;
import springProject.service.EmailService;
import springProject.service.library.LibraryListService;

@Controller
public class IndexController {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	CookieService cookieService;
	@Autowired
	LibraryListService libraryListService;
	@GetMapping("/") // "/" : root
	public String index(@ModelAttribute("loginCommand") LoginCommand loginCommand
			, HttpServletRequest request, Model model
			,@RequestParam(value="page" , defaultValue = "1" ,required = false)int page) {
		cookieService.execute(loginCommand, request);
		libraryListService.execute(model, page, "");
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
	
	@PostMapping("/loadMore")
	public ModelAndView loadMore(int page, Model model) {
		System.out.println(page);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		libraryListService.execute(model, page, "");
		return mav;
	}

	@GetMapping("/realStock")
	public String realStock() {
		return "/socket/chattingClient";
	}
	
	
	
	
	
	
	
	
	
	
	
}
