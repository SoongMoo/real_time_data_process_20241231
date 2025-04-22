package springProject.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springProject.command.MemberCommand;
import springProject.domain.MemberDTO;
import springProject.repository.MemberRepository;

@Service
public class UserWriteService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberRepository MemberRepository;
	public void execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setMemberEmail(memberCommand.getMemberEmail());
		dto.setMemberId(memberCommand.getMemberId());
		dto.setMemberName(memberCommand.getMemberName());
		dto.setMemberPw(passwordEncoder.encode(memberCommand.getMemberPw()));
		MemberRepository.memberInsert(dto);
	}
}
