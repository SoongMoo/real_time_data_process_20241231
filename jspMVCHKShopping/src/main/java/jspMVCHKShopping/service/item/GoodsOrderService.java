package jspMVCHKShopping.service.item;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.ItemDAO;
import jspMVCHKShopping.model.MemberDAO;
import jspMVCHKShopping.model.MemberDTO;
import jspMVCHKShopping.model.PurchaseDTO;

public class GoodsOrderService {
	public String execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {}
		// 장바구니에 있는 상품을 구매정보로 저장
		String purchaseName = request.getParameter("purchaseName");
		String goodsNums = request.getParameter("goodsNums");
		String totalPaymentPrice = request.getParameter("totalPaymentPrice");
		String deliveryName = request.getParameter("deliveryName");
		String deliveryAddr = request.getParameter("deliveryAddr");
		String deliveryAddrDetail = request.getParameter("deliveryAddrDetail");
		String deliveryPost = request.getParameter("deliveryPost");
		String deliveryPhone = request.getParameter("deliveryPhone");
		String message = request.getParameter("message");
		
		PurchaseDTO dto = new PurchaseDTO();
		dto.setDeliveryAddr(deliveryAddr);
		dto.setDeliveryAddrDetail(deliveryAddrDetail);
		dto.setDeliveryName(deliveryName);
		dto.setDeliveryPhone(deliveryPhone);
		dto.setMessage(message);
		dto.setPurchaseName(purchaseName);
		dto.setPurchasePrice(Long.parseLong(totalPaymentPrice));
		
		// 회원 정보 
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = mdao.memberSelectOne(auth.getUserId());
		dto.setMemberNum(mdto.getMemberNum());
		
		// 구매번호 만들기 : yyyyMMddHHmmssSSS
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String purchaseNum = sdf.format(new Date());
		dto.setPurchaseNum(purchaseNum);
		
		ItemDAO dao = new ItemDAO();
		//구매정보 저장
		dao.purchaseInsert(dto);
		
		// 구매상품 정보 :  장바구니에 있는 상품정보를 구매리스트테이블에 저장
		String nums [] = goodsNums.split("`");
		for(String goodsNum : nums) {
			/// triger
			dao.purchaseListInsert(goodsNum, purchaseNum,mdto.getMemberNum());
			dao.cartDelete(goodsNum, mdto.getMemberNum());
		}
		return purchaseNum;
	}
}








