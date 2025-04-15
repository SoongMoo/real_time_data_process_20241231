package memberSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import memberSpringProject.command.MemberCommand;
import memberSpringProject.service.member.MemberAutoNumService;
import memberSpringProject.service.member.MemberDeleteService;
import memberSpringProject.service.member.MemberDetailService;
import memberSpringProject.service.member.MemberListService;
import memberSpringProject.service.member.MemberUpdateService;
import memberSpringProject.service.member.MemberWriteService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberListService memberListService;
	@GetMapping("/memberList")
	public String main(Model model) {
		memberListService.execute(model);
		return "member/memberList";
	}
	@Autowired
	MemberAutoNumService memberAutoNumService ;
	@GetMapping("/memberWrite")
	public String write(Model model) {
		memberAutoNumService.execute(model);
		return "member/memberForm";
	}
	@Autowired
	MemberWriteService memberWriteService ;
	@PostMapping("/memberWrite")
	public String write(MemberCommand memberCommand) {
		memberWriteService.execute(memberCommand);
		return "redirect:memberList";
	}
	
	@Autowired
	MemberDetailService memberDetailService ;
	@GetMapping("/memberDetail")
	public String info(Model model, String memberNum) {
		memberDetailService.execute(model, memberNum);
		return "member/memberDetail";
	}
	
	@GetMapping("/memberUpdate")
	public String update(Model model, String memberNum) {
		memberDetailService.execute(model, memberNum);
		return "member/memberModify";
	}
	@Autowired
	MemberUpdateService memberUpdateService;
	@PostMapping("/memberUpdate")
	public String update(MemberCommand memberCommand, Model model) {
		int i = memberUpdateService.execute(memberCommand);
		if(i == 1)
			return "redirect:memberDetail?memberNum=" + memberCommand.getMemNum();
		else {
			memberDetailService.execute(model, memberCommand.getMemNum());
			model.addAttribute("pwErr", "비밀번호가 틀렸습니다.");
			return "member/memberModify";
		}
	}
	@Autowired
	MemberDeleteService memberDeleteService;
	@GetMapping("/memberDelete")
	public String delete(String memberNum) {
		memberDeleteService.execute(memberNum);
		return "redirect:memberList";
	}
}






