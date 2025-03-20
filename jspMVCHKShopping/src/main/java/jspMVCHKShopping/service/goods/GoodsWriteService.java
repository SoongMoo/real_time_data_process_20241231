package jspMVCHKShopping.service.goods;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.GoodsDAO;
import jspMVCHKShopping.model.GoodsDTO;

public class GoodsWriteService {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String goodsNum = request.getParameter("goodsNum");
		String goodsName = request.getParameter("goodsName");
		String goodsPrice = request.getParameter("goodsPrice");
		String goodscontent = request.getParameter("goodsContent");
		System.out.println("goodsPrice : " + goodsPrice);
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsNum(goodsNum);
		dto.setGoodsName(goodsName);
		dto.setGoodsPrice(Integer.parseInt(goodsPrice));
		dto.setGoodsContent(goodscontent);

		GoodsDAO dao = new GoodsDAO();
		dao.goodsInsert(dto);

	}
}
