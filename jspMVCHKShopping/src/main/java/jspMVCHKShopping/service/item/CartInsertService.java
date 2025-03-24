package jspMVCHKShopping.service.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.CartDTO;
import jspMVCHKShopping.model.ItemDAO;
import jspMVCHKShopping.model.MemberDAO;
import jspMVCHKShopping.model.MemberDTO;

public class CartInsertService {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		String cartQty = request.getParameter("cartQty");
		
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = mdao.memberSelectOne(auth.getUserId());
		
		CartDTO dto = new CartDTO();
		dto.setCartQty(Integer.parseInt(cartQty));
		dto.setGoodsNum(goodsNum);
		dto.setMemberNum(mdto.getMemberNum());
		
		ItemDAO dao = new ItemDAO();
		dao.cartMerge(dto);
		
	}
}
