package jspMVCHKShopping.service.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.MemberDAO;
import jspMVCHKShopping.model.MemberDTO;

public class MemberUpdateService {
	public int execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {}
		String memberNum = request.getParameter("memberNum");
		String memberName = request.getParameter("memberName");
		String memberId = request.getParameter("memberId");
		String memberAddr = request.getParameter("memberAddr");
		String memberAddrDetail = request.getParameter("memberAddrDetail");
		String memberPost = request.getParameter("memberPost");
		String memberPhone1 = request.getParameter("memberPhone1");
		String memberPhone2 = request.getParameter("memberPhone2");
		String memberGender = request.getParameter("memberGender");
		String memberEmail = request.getParameter("memberEmail");
		String memberBirth = request.getParameter("memberBirth");
		
		String memberPW = request.getParameter("memberPw");
		
		MemberDTO dto = new MemberDTO();
		dto.setMemberAddr(memberAddr);
		dto.setMemberAddrDetail(memberAddrDetail);
		dto.setMemberBirth(memberBirth);
		dto.setMemberEmail(memberEmail);
		dto.setMemberGender(memberGender);
		dto.setMemberId(memberId);
		dto.setMemberName(memberName);
		dto.setMemberNum(memberNum);
		dto.setMemberPhone1(memberPhone1);
		dto.setMemberPhone2(memberPhone2);
		dto.setMemberPost(memberPost);
		
		int i;
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		if(memberPW.equals(auth.getUserPw())) { // 비밀번호가 일치하면 수정
			MemberDAO dao = new MemberDAO();
			dao.memberUpdate(dto);
			i = 1;
		}else { // 일치하지 않으면 수정페이지
			request.setAttribute("pwErr", "비밀번호가 틀렸습니다.");
			i = 0;
		}
		return i;
	}
}






