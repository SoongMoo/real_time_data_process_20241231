package jspMVCHKShopping.service.goods;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.GoodsDAO;
import jspMVCHKShopping.model.GoodsDTO;

public class GoodsWriteService {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int fileSize = 1024 * 1024 * 100 ;  //100M
		String realPath = request.getServletContext().getRealPath("goods/upload");
		System.out.println(realPath);
		// 파일을 받아오기 위해서 사용
		try {
			// 파일저장이 이루어짐
			MultipartRequest multi = 
					new MultipartRequest(request, realPath, fileSize, "utf-8"
							, new DefaultFileRenamePolicy());
			String goodsNum = multi.getParameter("goodsNum");
			String goodsName = multi.getParameter("goodsName");
			String goodsPrice = multi.getParameter("goodsPrice");
			String goodscontent = multi.getParameter("goodsContent");
			String goodsMainImage = multi.getOriginalFileName("mainImage");
			String goodsMainStoreImage = multi.getFilesystemName("mainImage");
			String image1 = multi.getOriginalFileName("image1");
			String image1Store = multi.getFilesystemName("image1"); 
			String image2 = multi.getOriginalFileName("image2");
			String image2Store = multi.getFilesystemName("image2"); 
			String image3 = multi.getOriginalFileName("image3");
			String image3Store = multi.getFilesystemName("image3"); 
			
			String goodsDetailImage = image1 + "`" + image2 + "`" + image3;
			String goodsDetailStoreImage = image1Store + "`" + image2Store 
										 + "`" + image3Store;
			
			HttpSession session = request.getSession();
			//로그인 할때 만들어 진 정보
			AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
			
			String empId = auth.getUserId();	
			GoodsDAO dao = new GoodsDAO();
			String empNum = dao.employeeNumSelect(empId);
			
			GoodsDTO dto = new GoodsDTO();
			dto.setGoodsNum(goodsNum);
			dto.setGoodsName(goodsName);
			dto.setGoodsPrice(Integer.parseInt(goodsPrice));
			dto.setGoodsContent(goodscontent);
			dto.setEmpNum(empNum);
			dto.setGoodsMainImage(goodsMainImage);
			dto.setGoodsMainStoreImage(goodsMainStoreImage);
			dto.setGoodsDetailImage(goodsDetailImage);
			dto.setGoodsDetailStoreImage(goodsDetailStoreImage);
			dao.goodsInsert(dto); // 인자 : argument
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		

	}
}
