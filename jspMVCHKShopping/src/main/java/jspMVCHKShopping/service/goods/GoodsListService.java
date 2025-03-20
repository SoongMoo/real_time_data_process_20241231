package jspMVCHKShopping.service.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.GoodsDAO;
import jspMVCHKShopping.model.GoodsDTO;

public class GoodsListService {
	public void execute(HttpServletRequest request) {
		GoodsDAO dao = new GoodsDAO();
		List<GoodsDTO> list = dao.goodsSelectAll();
		System.out.println(list.size());
		request.setAttribute("list", list);
	}
}
