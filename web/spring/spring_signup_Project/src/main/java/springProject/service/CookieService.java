package springProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import springProject.command.LoginCommand;
import springProject.domain.AuthInfoDTO;
import springProject.repository.MemberRepository;

@Service
public class CookieService {
	@Autowired
	MemberRepository memberRepository;
	public void execute(LoginCommand loginCommand , HttpServletRequest request) {
		Cookie [] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("idStore")) {
					System.out.println("idStore 쿠키가 있어요.");
					loginCommand.setIdStore(true);
					loginCommand.setUserId(cookie.getValue());
				}
				if(cookie.getName().equals("autoLogin")) {
					System.out.println("autoLogin 쿠키가 있어요.");
					String userId = cookie.getValue();
					AuthInfoDTO auth = memberRepository.loginSelectOne(userId);
					///쿠키를 이용해서 로그인 session을 만들어주는 것이 자동 로그인이다.
					HttpSession session = request.getSession();
					session.setAttribute("auth", auth);
				}
			}
		}
	}
}
