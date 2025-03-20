package jspMVCHKShopping.service.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.MemberDAO;

public class MemberDropService {
	public int execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String memberId = auth.getUserId();
		
		String memberPw = request.getParameter("memberPw");
		
		int i;
		if(memberPw.equals(auth.getUserPw())) {
			MemberDAO dao = new MemberDAO();
			dao.memberDelete(memberId);
			i = 1;
		}else {
			request.setAttribute("errPw", "비밀번호가 틀렸습니다.");
			i = 0;
		}
		return i;
	}
}
