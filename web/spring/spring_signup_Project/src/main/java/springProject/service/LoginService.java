package springProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import springProject.command.LoginCommand;
import springProject.domain.AuthInfoDTO;
import springProject.repository.MemberRepository;

@Service
public class LoginService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(LoginCommand loginCommand, BindingResult result
			, HttpSession session, HttpServletResponse response) {
		AuthInfoDTO auth = memberRepository.loginSelectOne(loginCommand.getUserId());
		if(auth == null) {
			System.out.println("아이디가 존재하지 않아요");
			result.rejectValue("userId", "loginCommand.userId","아이디가 존재하지 않아요.");
		}else {
			if(passwordEncoder.matches(loginCommand.getUserPw()
									, auth.getUserPw())) {
				System.out.println("로그인되었습니다.");
				session.setAttribute("auth", auth);
				if(loginCommand.isAutoLogin()) {
					Cookie cookie = new Cookie("autoLogin",loginCommand.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}
				if(loginCommand.isIdStore()) {
					// 쿠키 생성
					Cookie cookie = new Cookie("idStore",loginCommand.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}else {
					// 쿠키 삭제
					Cookie cookie = new Cookie("idStore","");
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}else {
				System.out.println("비밀번호가 틀렸습니다.");
				result.rejectValue("userPw", "loginCommand.userPw"
						, "비밀번호가 틀렸습니다.");
			}
		}
	}
}
