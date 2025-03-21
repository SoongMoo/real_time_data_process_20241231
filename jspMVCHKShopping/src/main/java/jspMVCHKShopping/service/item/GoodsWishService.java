package jspMVCHKShopping.service.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.ItemDAO;
import jspMVCHKShopping.model.MemberDAO;
import jspMVCHKShopping.model.MemberDTO;
import jspMVCHKShopping.model.WishDTO;

public class GoodsWishService {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		
		// 사용자 정보 가져오기
		
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = null;
		if(auth != null) {
			MemberDAO mdao = new MemberDAO();
			MemberDTO mdto = mdao.memberSelectOne(auth.getUserId());
			memberNum = mdto.getMemberNum();
		}
		// 찜 정보저장
		WishDTO dto = new WishDTO();
		dto.setGoodsNum(goodsNum);
		dto.setMemberNum(memberNum);
		
		// 찜 정보 가져오기
		ItemDAO dao = new ItemDAO();
		dto = dao.wishSelectOne(dto);
		request.setAttribute("wish", dto);
	}
}
