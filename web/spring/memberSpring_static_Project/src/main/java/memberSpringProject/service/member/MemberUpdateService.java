package memberSpringProject.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import memberSpringProject.command.MemberCommand;
import memberSpringProject.domain.MemberDTO;
import memberSpringProject.repository.MemberRepository;

@Service
public class MemberUpdateService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	public int execute(MemberCommand memberCommand) {
		MemberDTO dto = memberRepository.memberSelectOne(memberCommand.getMemNum());
		int i = 0;
		if(passwordEncoder.matches(memberCommand.getMemPw(), dto.getMemberPw())) {
			dto = new MemberDTO();
			dto.setMemberName(memberCommand.getMemName());
			dto.setMemberAddr(memberCommand.getMemAddr());
			dto.setMemberAddrDetail(memberCommand.getMemDetailAddr());
			dto.setMemberBirth(memberCommand.getMemBirth());
			dto.setMemberId(memberCommand.getMemId());
			dto.setMemberNum(memberCommand.getMemNum());
			dto.setMemberPost(memberCommand.getMemPost());
			memberRepository.memberUpdate(dto);
			i = 1;
		}
		return i;
	}
}
