package memberSpringProject.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import memberSpringProject.repository.MemberRepository;

@Service
public class MemberAutoNumService {
	@Autowired
	MemberRepository memberRepository ;
	public void execute(Model model) {
		String memberNum = memberRepository.memberNumAutoSelect();
		model.addAttribute("memberNum", memberNum);
	}
}
