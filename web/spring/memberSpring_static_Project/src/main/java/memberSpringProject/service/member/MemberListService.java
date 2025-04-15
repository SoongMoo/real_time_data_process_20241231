package memberSpringProject.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import memberSpringProject.domain.MemberDTO;
import memberSpringProject.repository.MemberRepository;

@Service
public class MemberListService {
	@Autowired
	MemberRepository memberRepository;
	public void execute(Model model) {
		List<MemberDTO> list = memberRepository.memberSelectAll();
		model.addAttribute("list", list);
	}
}






