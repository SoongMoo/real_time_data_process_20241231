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
import memberSpringProject.service.member.MemberUpdateServce;
import memberSpringProject.service.member.MemberWriteService;

@Controller
@RequestMapping("/member") // 공통주소 사용
public class MemberContoller {
	@Autowired
	MemberListService memberListService ;
	@GetMapping("/memberList")
	public String list(Model model) {
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
	MemberWriteService memberWriteService;
	@PostMapping("/memberWrite")
	public String write(MemberCommand memberCommand) {
		memberWriteService.execute(memberCommand);
		return "redirect:memberList";
	}
	@Autowired
	MemberDetailService memberDetailService;
	@GetMapping("/memberDetailt")
	public String detail(String memberNum,Model model) {
		memberDetailService.execute(memberNum, model);
		return "member/memberInfo";
	}
	
	@GetMapping("/memberUpdate")
	public String update(String memberNum, Model model) {
		memberDetailService.execute(memberNum, model);
		return "member/memberModify";
	}
	@Autowired
	MemberUpdateServce memberUpdateServce;
	@PostMapping("/memberUpdate")
	public String update(MemberCommand memberCommand, Model model) {
		int i = memberUpdateServce.execute(memberCommand);
		if(i == 1)
			return "redirect:memberDetailt?memberNum="+memberCommand.getMemberNum();
		else {
			model.addAttribute("pwErr", "비밀번호가 틀렸습니다.");
			memberDetailService.execute(memberCommand.getMemberNum(), model);
			return "member/memberModify";
		}
	}
	@Autowired
	MemberDeleteService memberDeleteService;
	@GetMapping("memberDelete")
	public String delete(String memberNum) {
		memberDeleteService.execute(memberNum);
		return "redirect:memberList";
	}
}












