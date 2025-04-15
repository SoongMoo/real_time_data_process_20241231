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
	PasswordEncoder  passwordEncoder;
	public void execute(MemberCommand memberCommand) {
		// memberPw를 암호화
		// newPw:암호문
		String newPw = passwordEncoder.encode(memberCommand.getMemberPw());
		MemberDTO dto = new MemberDTO();
		dto.setMemberNum(memberCommand.getMemberNum());
		dto.setMemberId(memberCommand.getMemberId());
		dto.setMemberName(memberCommand.getMemberName());
		dto.setMemberPw(newPw);
		memberRepository.memberInsert(dto);
	}
}
