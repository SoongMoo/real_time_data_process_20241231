package jspMVCHKShopping.service.goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.GoodsDAO;
import jspMVCHKShopping.model.GoodsDTO;

public class GoodsDeleteService {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = dao.goodsSelectOne(goodsNum);
		dao.goodsDelete(goodsNum);
	}
}