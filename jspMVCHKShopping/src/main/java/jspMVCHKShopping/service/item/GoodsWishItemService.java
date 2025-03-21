package jspMVCHKShopping.service.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.ItemDAO;
import jspMVCHKShopping.model.MemberDAO;
import jspMVCHKShopping.model.MemberDTO;
import jspMVCHKShopping.model.WishDTO;

public class GoodsWishItemService {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		/* 회원정보 가져오기 시작*/
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = mdao.memberSelectOne(auth.getUserId());
		/* 회원정보 가져오기 끝 : memberNum */
		WishDTO dto = new WishDTO();
		dto.setMemberNum(mdto.getMemberNum());
		dto.setGoodsNum(goodsNum);
		/* wish 테이블에 데이터 넣기 */
		ItemDAO dao = new ItemDAO();
		dao.wishInsert(dto);
	}
}
