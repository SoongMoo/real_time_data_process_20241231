package memberSpringProject.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import memberSpringProject.command.MemberCommand;
import memberSpringProject.domain.MemberDTO;
import memberSpringProject.repository.MemberRepository;

@Service
public class MemberWriteService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setMemberName(memberCommand.getMemName());
		dto.setMemberAddr(memberCommand.getMemAddr());
		dto.setMemberAddrDetail(memberCommand.getMemDetailAddr());
		dto.setMemberBirth(memberCommand.getMemBirth());
		dto.setMemberId(memberCommand.getMemId());
		dto.setMemberNum(memberCommand.getMemNum());
		dto.setMemberPw(passwordEncoder.encode(memberCommand.getMemPw()));
		dto.setMemberPost(memberCommand.getMemPost());
		memberRepository.memberInsert(dto);
	}
}
