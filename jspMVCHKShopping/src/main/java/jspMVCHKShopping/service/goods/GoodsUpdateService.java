package jspMVCHKShopping.service.goods;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.EmployeeDAO;
import jspMVCHKShopping.model.GoodsDAO;
import jspMVCHKShopping.model.GoodsDTO;

public class GoodsUpdateService {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String goodsNum = request.getParameter("goodsNum");
		String goodsName = request.getParameter("goodsName");
		String goodsPrice = request.getParameter("goodsPrice");
		String goodsContent = request.getParameter("goodsContent");
		
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String empId = auth.getUserId();
		
		GoodsDAO dao = new GoodsDAO();
		String updateEmpNum = dao.employeeNumSelect(empId);
		
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsNum(goodsNum);
		dto.setGoodsName(goodsName);
		dto.setGoodsPrice(Integer.parseInt(goodsPrice));
		dto.setGoodsContent(goodsContent);
		dto.setUpdateEmpNum(updateEmpNum);
		
		dao.goodsUpdate(dto);
	}
}
