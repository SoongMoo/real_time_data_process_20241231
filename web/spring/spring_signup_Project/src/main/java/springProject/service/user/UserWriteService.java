package springProject.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springProject.command.MemberCommand;
import springProject.domain.MemberDTO;
import springProject.repository.MemberRepository;
import springProject.service.EmailSendService;

@Service
public class UserWriteService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberRepository MemberRepository;
	@Autowired
	EmailSendService emailSendService;
	public void execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setMemberEmail(memberCommand.getMemberEmail());
		dto.setMemberId(memberCommand.getMemberId());
		dto.setMemberName(memberCommand.getMemberName());
		dto.setMemberPw(passwordEncoder.encode(memberCommand.getMemberPw()));
		MemberRepository.memberInsert(dto);
		
		String fromEmail ="soongmoostudent@gmail.com";	
		String toEmail = dto.getMemberEmail();
		String subject = "가입을 환영합니다.";
		String contents = dto.getMemberName() +" 님 환영합니다. <br />" 
				        + "가입을 완료하시려면 <a href='http://localhost:8080/help/userConfirm?chk="
				        + dto.getMemberId() + "'>여기</a>를 클릭하세요";
		emailSendService.send(fromEmail, toEmail, subject, contents);
	}
}
