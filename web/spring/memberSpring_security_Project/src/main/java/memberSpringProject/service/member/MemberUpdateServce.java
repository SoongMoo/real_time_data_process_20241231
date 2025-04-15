package memberSpringProject.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import memberSpringProject.command.MemberCommand;
import memberSpringProject.domain.MemberDTO;
import memberSpringProject.repository.MemberRepository;

@Service
public class MemberUpdateServce {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	public int execute(MemberCommand memberCommand) {
		int i = 0;
		MemberDTO dto = memberRepository.memberSelectOne(memberCommand.getMemberNum());
		//                          본문    
		if(passwordEncoder.matches(memberCommand.getMemberPw()
				//암호문
				,dto.getMemberPw())) { // 본문과 암호문이 일치하는지 비교
			dto = new MemberDTO();
			dto.setMemberId(memberCommand.getMemberId());
			dto.setMemberName(memberCommand.getMemberName());
			dto.setMemberNum(memberCommand.getMemberNum());
			memberRepository.memberUpdate(dto);
			i = 1;
		}
		return i;
	}
}
