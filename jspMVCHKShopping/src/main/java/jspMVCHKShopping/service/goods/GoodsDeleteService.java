package jspMVCHKShopping.service.goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.GoodsDAO;
import jspMVCHKShopping.model.GoodsDTO;

public class GoodsDeleteService {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		GoodsDAO dao = new GoodsDAO();
		// 파일정보를 가져오기 위해 상품번호에 해당하는 정보들을 가지고 옴
		GoodsDTO dto = dao.goodsSelectOne(goodsNum);
		int i = dao.goodsDelete(goodsNum);
		if(i > 0) {
			String realPath = request.getServletContext().getRealPath("goods/upload");
			String mainImage = dto.getGoodsMainStoreImage();
			File file = new File(realPath + "/" + mainImage);
			if(file.exists()) file.delete();
			// split()을 하면 반환되는 것은 배열이다.
			String [] images = dto.getGoodsDetailStoreImage().split("`");
			for(String image : images) {
				file = new File(realPath + "/" + image);
				if(file.exists()) file.delete();
			}			
		}		
	}
}