package jspMVCHKShopping.service.goods;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.GoodsDAO;
import jspMVCHKShopping.model.GoodsDTO;

public class GoodsDetailService {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = dao.goodsSelectOne(goodsNum);
		request.setAttribute("dto", dto);
	}
}








