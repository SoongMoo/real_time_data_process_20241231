package memberSpringProject.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import memberSpringProject.domain.MemberDTO;
import memberSpringProject.repository.MemberRepository;

@Service
public class MemberDetailService {
	@Autowired
	MemberRepository memberRepository;
	public void execute(Model model, String memberNum) {
		MemberDTO dto = memberRepository.memberSelectOne(memberNum);
		model.addAttribute("dto", dto);
	}
}
