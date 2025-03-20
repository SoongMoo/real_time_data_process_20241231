package jspMVCHKShopping.service.goods;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.GoodsDAO;

public class GoodsAutoNumService {
	public void execute(HttpServletRequest request) {
		GoodsDAO dao = new GoodsDAO();
		String goodsNum  = dao.goodsAutoNum();
		request.setAttribute("goodsNum", goodsNum);
	}
}
