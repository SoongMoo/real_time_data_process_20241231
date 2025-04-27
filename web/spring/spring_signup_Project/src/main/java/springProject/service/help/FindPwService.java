package springProject.service.help;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springProject.domain.AuthInfoDTO;
import springProject.domain.UserChangePasswordDTO;
import springProject.repository.MemberRepository;
import springProject.service.EmailSendService;

@Service
public class FindPwService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	EmailSendService emailSendService;
	public void execute(String userId, String userPhone, Model model ) {
		// 임시비밀번호(8 자리)
		String newPw = UUID.randomUUID().toString().substring(0, 8);
		
		AuthInfoDTO auth =  memberRepository.loginSelectOne(userId);
		UserChangePasswordDTO dto = new UserChangePasswordDTO();
		if(auth.getGrade().equals("emp")) {
			dto.setTableName("employees");
			dto.setPhoneColumnName("emp_phone");
			dto.setUserIdColumnName("emp_id");
			dto.setPwColumnName("emp_pw");
		}else {
			dto.setTableName("members");
			dto.setPhoneColumnName("MEMBER_PHONE1");
			dto.setUserIdColumnName("MEMBER_ID");
			dto.setPwColumnName("MEMBER_PW");
		}
		dto.setUserPhone(userPhone);
		dto.setUserId(userId);
		dto.setUserPw(passwordEncoder.encode(newPw));
		int i = memberRepository.userPwUpdate(dto);
		if(i != 0) {
			model.addAttribute("email", auth.getUserEmail());
			
			String html = auth.getUserName()+"님의 임시 비밀번호는 <b>"+newPw+"</b> 입니다.";
			String subject = auth.getUserName() + "님의 임시비밀번호입니다."; 
			String fromEmail = "soongmoostudent@gmail.com";
			String toEmail = auth.getUserEmail();
			
			emailSendService.send(fromEmail, toEmail, subject, html);
		}else {
			model.addAttribute("email", null);
		}
	}
}









