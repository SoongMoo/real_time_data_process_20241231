package jspMVCHKShopping.service.goods;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.GoodsDAO;

public class GoodsVisitCountService {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		GoodsDAO dao = new GoodsDAO();
		dao.visitCountUpdate(goodsNum);
	}
}
