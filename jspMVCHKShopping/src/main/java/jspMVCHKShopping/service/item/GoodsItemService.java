package jspMVCHKShopping.service.item;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.CartListDTO;
import jspMVCHKShopping.model.ItemDAO;
import jspMVCHKShopping.model.MemberDAO;
import jspMVCHKShopping.model.MemberDTO;

public class GoodsItemService {
	public void execute(HttpServletRequest request) {
		String [] goodsNums = request.getParameterValues("prodCk");
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = mdao.memberSelectOne(auth.getUserId());
		ItemDAO dao = new ItemDAO();
		List<CartListDTO> list = new ArrayList<CartListDTO>();
		Integer goodsTotalPrice = 0;
		String nums = "";
		/// jdbc => mybytis(spring)
		/// select * from cart 
		/// where goods_num in ('goods_100002', 'goods_100003') and member_num = 'mem_10001'
		for(String goodsNum : goodsNums) {
			CartListDTO dto = dao.itemSelectOne(goodsNum, mdto.getMemberNum());
			list.add(dto);
			goodsTotalPrice += dto.getTotalPrice();
			nums += goodsNum + "`"; 
		}
		request.setAttribute("goodsTotalPrice", goodsTotalPrice);
		request.setAttribute("list", list);
		request.setAttribute("nums", nums);
	}
}
