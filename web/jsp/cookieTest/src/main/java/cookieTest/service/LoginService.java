package cookieTest.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cookieTest.model.dao.LoginDAO;

public class LoginService {
	public void execute(HttpServletRequest request,
			HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String storeId = request.getParameter("storeId");
		String autoLogin = request.getParameter("autoLogin");
		System.out.println("autoLogin :" + autoLogin);
		LoginDAO dao = new LoginDAO();
		String memberPw = dao.authSelect(userId);
		if(memberPw != null) {
			 if(memberPw.equals(userPw)) {
				 System.out.println("로그인되었습니다.");
				 HttpSession session = request.getSession();
				 session.setAttribute("auth", userId);
				 if(autoLogin.equals("on")) {
					Cookie cookie = new  Cookie("auto" , userId);
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				 }
				 if(storeId != null &&storeId.equals("store")) {
					Cookie cookie = new  Cookie("member" , userId);
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				 }else {
					 System.out.println("쿠키삭제");
					Cookie cookie = new  Cookie("member" , "");
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				 }
			 }else {
				 System.out.println("비밀번호가 틀렸습니다.");
			 }
		}else {
			System.out.println("아이디 존재하지 않습니다.");
		}
	}
}










