package jspMVCHKShopping.service.user;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.MemberDTO;
import jspMVCHKShopping.model.UserDAO;

public class UserWriteService {
	public void execute(HttpServletRequest request) {
		System.out.println("writeService");
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {}
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userPhone1 = request.getParameter("userPhone1");
		String userPhone2 = request.getParameter("userPhone2");
		String userAddr = request.getParameter("userAddr");
		String userAddrDetail = request.getParameter("userAddrDetail");
		String userPost = request.getParameter("userPost");
		String userEamil = request.getParameter("userEamil");
		String userGender = request.getParameter("userGender");
		String userBirth = request.getParameter("userBirth");
		MemberDTO dto = new MemberDTO();
		dto.setMemberAddr(userAddr);
		dto.setMemberAddrDetail(userAddrDetail);
		dto.setMemberBirth(userBirth);
		dto.setMemberEmail(userEamil);
		dto.setMemberGender(userGender);
		dto.setMemberId(userId);
		dto.setMemberName(userName);
		dto.setMemberPhone1(userPhone1);
		dto.setMemberPhone2(userPhone2);
		dto.setMemberPost(userPost);
		dto.setMemberPw(userPw);		
		UserDAO dao = new UserDAO();
		dao.userInsert(dto);
	}
}
