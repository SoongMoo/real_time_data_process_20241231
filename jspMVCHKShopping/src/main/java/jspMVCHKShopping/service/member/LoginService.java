package jspMVCHKShopping.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.UserDAO;

public class LoginService {
	public int execute(HttpServletRequest request) {
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
				i = 1;
			}else {// 비밀번호가 일치하지 않을 때
				request.setAttribute("pwErr", "비밀번호가 틀렸습니다.");
			}
		}
		return i;
	}
}






