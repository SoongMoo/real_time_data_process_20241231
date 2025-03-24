package jspMVCHKShopping.service.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.CartListDTO;
import jspMVCHKShopping.model.ItemDAO;
import jspMVCHKShopping.model.MemberDAO;
import jspMVCHKShopping.model.MemberDTO;

public class CartListService {
	public void execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = mdao.memberSelectOne(auth.getUserId());
		
		ItemDAO dao = new ItemDAO();
		List<CartListDTO> list = dao.cartSelectAll(mdto.getMemberNum());
		request.setAttribute("list", list);
		
	}
}



