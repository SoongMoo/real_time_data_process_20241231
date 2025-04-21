package employeeSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import employeeSpringProject.command.LoginCommand;
import employeeSpringProject.domain.AuthInfoDTO;
import employeeSpringProject.repository.LoginRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class LoginServie {
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	PasswordEncoder  passwordEncoder;
	public void execute(LoginCommand loginCommand
			,HttpSession session, BindingResult result) {
		AuthInfoDTO auth = loginRepository.loginSelect(loginCommand.getUserId());
		if(auth != null) {
			if(passwordEncoder.matches(loginCommand.getUserPw(), auth.getUserPw())){
				session.setAttribute("auth", auth);
			}else {
				result.rejectValue("userPw", "loginCommand.userPw","비밀번호가 틀렸습니다.");
			}
		}else {
			result.rejectValue("userId", "loginCommand.userId","아이디가 존재하지 않습니다.");
		}
	}
}





