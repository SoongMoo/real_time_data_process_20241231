package springProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springProject.command.MemberCommand;
import springProject.service.user.UserWriteService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@GetMapping("/userAgree")
	public String agree() {
		return "memberJoin/agree";
	}
	@GetMapping("/userWrite")
	public String write(MemberCommand memberCommand) {
		return "memberJoin/userForm";
	}
	@Autowired
	UserWriteService userWriteService; 
	@PostMapping("/userWrite")
	public String write(@Validated MemberCommand memberCommand
			,BindingResult result) {
		if(result.hasErrors()) {
			return "memberJoin/userForm";
		}
		if(!memberCommand.isMemberPwEqualsMemberPwCon()) {
			result.rejectValue("memberPwCon"
					, "memberCommand.memberPwCon", "비밀번호가 다릅니다.");
			return "memberJoin/userForm";
		}
		userWriteService.execute(memberCommand);
		return "redirect:/";
	}
}






