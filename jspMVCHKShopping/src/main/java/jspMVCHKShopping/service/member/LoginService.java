package jspMVCHKShopping.service.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.UserDAO;

public class LoginService {
	public int execute(HttpServletRequest request
			,HttpServletResponse response) {
		System.out.println("로그인 서비스");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		UserDAO dao = new UserDAO();
		AuthInfoDTO dto = dao.loginSelectOne(userId);
		/** 로그인 알고리즘 **/
		int i = 0;
		if(dto == null) { // 아이디가 존재하지 않는 경우
			request.setAttribute("idErr", "아이디가 존재하지 않아요");
		}else { // 아이디가 존재 하는 경우
			if(userPw.equals(dto.getUserPw())) { // 비밀번호도 일치하는 경우
				HttpSession  session = request.getSession();
				session.setAttribute("auth", dto);
				String storeId = request.getParameter("storeId"); // 1. 요청
				String keepLogin = request.getParameter("keepLogin");
				if(keepLogin != null && keepLogin.equals("on")) {
					// 2.
					System.out.println(" 쿠키 생성");
					Cookie cookie = new Cookie("keepLogin", userId);
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					// 3. 웹브라우저로 전달
					response.addCookie(cookie);
				}
				if(storeId != null && storeId.equals("store")) {
					// 2.
					System.out.println(" 쿠키 생성");
					Cookie cookie = new Cookie("storeId", userId);
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					// 3. 웹브라우저로 전달
					response.addCookie(cookie);
				}else {
					// 쿠키 삭제
					Cookie cookie = new Cookie("storeId", "");
					cookie.setPath("/");
					cookie.setMaxAge(0);
					// 웹브라우저로 전달
					response.addCookie(cookie);
				}
				i = 1;
			}else {// 비밀번호가 일치하지 않을 때
				request.setAttribute("pwErr", "비밀번호가 틀렸습니다.");
			}
		}
		return i;
	}
}






