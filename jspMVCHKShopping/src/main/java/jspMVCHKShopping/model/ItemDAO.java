package jspMVCHKShopping.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO extends DataBaseInfo{
	public void paymentInsert(PaymentDTO dto) {
		con = getConnection();
		sql = " insert into payment (purchase_Num,confirmNumber,cardNum,TID"
			+ "                     ,totalPrice,RESULTMASSAGE,PAYMATHOD,applDate"
			+ "                     ,appTime ) "
			+ " values (?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPurchaseNum());
			pstmt.setString(2, dto.getConfirmNumber());
			pstmt.setString(3, dto.getCardNum());
			pstmt.setString(4, dto.getTid());
			pstmt.setString(5, dto.getTotalPrice());
			pstmt.setString(6, dto.getResultMessage());
			pstmt.setString(7, dto.getPayMethod());
			pstmt.setString(8, dto.getApplDate());
			pstmt.setString(9, dto.getApplTime());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void cartDelete(String goodsNum, String memberNum) {
		con = getConnection();
		sql = " delete from cart "
			+ " where goods_num = ? and member_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			pstmt.setString(2, memberNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이(가) 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void purchaseListInsert(String goodsNum, String purchaseNum, String memberNum){
		con = getConnection();
		sql = " insert into purchase_list(GOODS_NUM, PURCHASE_NUM, PURCHASE_QTY,GOODS_UNIT_PRICE )"
			+ " select c.GOODS_NUM , ?, cart_qty , cart_qty * goods_price "
			+ " from cart c join goods g "
			+ " on c.goods_num = g.goods_num "
			+ " where g.goods_num = ? and member_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			pstmt.setString(2, goodsNum);
			pstmt.setString(3, memberNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이(가) 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public PurchaseDTO purchaseSelectOne(String purchaseNum) {
		PurchaseDTO dto = null;
		con = getConnection();
		sql = " select  PURCHASE_NUM, PURCHASE_DATE, PURCHASE_PRICE  "
			+ "     	,DELIVERY_ADDR, DELIVERY_ADDR_DETAIL, DELIVERY_POST"
			+ "     	,DELIVERY_PHONE, MESSAGE, PURCHASE_STATUS, MEMBER_NUM"
			+ "     	,DELIVERY_NAME, PURCHASE_NAME"
			+ " from purchase "
			+ " where PURCHASE_NUM = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new PurchaseDTO();
				dto.setDeliveryAddr(rs.getString("DELIVERY_ADDR"));
				dto.setDeliveryAddrDetail(rs.getString("DELIVERY_ADDR_DETAIL"));
				dto.setDeliveryName(rs.getString("DELIVERY_NAME"));
				dto.setDeliveryPhone(rs.getString("DELIVERY_PHONE"));
				dto.setMemberNum(rs.getString("MEMBER_NUM"));
				dto.setMessage(rs.getString("MESSAGE"));
				dto.setPurchaseDate(rs.getString("PURCHASE_DATE"));
				dto.setPurchaseName(rs.getString("PURCHASE_NAME"));
				dto.setPurchaseNum(rs.getString("PURCHASE_NUM"));
				dto.setPurchasePrice(rs.getLong("PURCHASE_PRICE"));
				dto.setPurchaseStatus(rs.getString("PURCHASE_STATUS"));
				dto.setDeliveryPost(rs.getString("DELIVERY_POST"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;		
	}
	public void purchaseInsert(PurchaseDTO dto) {
		con = getConnection();
		sql = " insert into purchase (PURCHASE_NUM, PURCHASE_DATE, PURCHASE_PRICE "
			+ " 					,DELIVERY_ADDR, DELIVERY_ADDR_DETAIL, DELIVERY_POST"
			+ "                     ,DELIVERY_PHONE, MESSAGE, PURCHASE_STATUS, MEMBER_NUM"
			+ "                     ,DELIVERY_NAME, PURCHASE_NAME)"
			+ " values( ?, sysdate, ?, ?, ?, ?, ?, ?, '결제대기중', ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPurchaseNum());
			pstmt.setLong(2, dto.getPurchasePrice());
			pstmt.setString(3, dto.getDeliveryAddr());
			pstmt.setString(4, dto.getDeliveryAddrDetail());
			pstmt.setString(5, dto.getDeliveryPost());
			pstmt.setString(6, dto.getDeliveryPhone());
			pstmt.setString(7, dto.getMessage());
			pstmt.setString(8, dto.getMemberNum());
			pstmt.setString(9, dto.getDeliveryName());
			pstmt.setString(10, dto.getPurchaseName());
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이(가) 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public CartListDTO itemSelectOne(String goodsNum, String memberNum) {
		CartListDTO dto = null;
		con = getConnection();
		sql = " select g.goods_Num, goods_Name, goods_Price , goods_main_store_image "
			+ " 	  ,MEMBER_NUM, CART_QTY, CART_DATE "
			+ " 	  ,CART_QTY * goods_Price as total_price "
			+ " from goods g join cart c "
			+ " on g.goods_num = c.goods_num "
			+ " where member_num = ? and g.goods_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			pstmt.setString(2, goodsNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new CartListDTO();
				dto.setCartDate(rs.getString("CART_DATE"));
				dto.setCartQty(rs.getInt("CART_QTY"));
				dto.setGoodsImage(rs.getString("goods_main_store_image"));
				dto.setGoodsName(rs.getString("goods_Name"));
				dto.setGoodsNum(rs.getString("goods_Num"));
				dto.setGoodsPrice(rs.getInt("goods_Price"));
				dto.setMemberNum(rs.getString("member_num"));
				dto.setTotalPrice(rs.getInt("total_price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	public List<CartListDTO> cartSelectAll(String memberNum) {
		List<CartListDTO> list = new ArrayList<CartListDTO>();
		con = getConnection();
		sql = " select g.goods_Num, goods_Name, goods_Price , goods_main_store_image "
			+ " 	  ,MEMBER_NUM, CART_QTY, CART_DATE "
			+ " 	  ,CART_QTY * goods_Price as total_price "
			+ " from goods g join cart c "
			+ " on g.goods_num = c.goods_num "
			+ " where member_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartListDTO dto = new CartListDTO();
				dto.setCartDate(rs.getString("CART_DATE"));
				dto.setCartQty(rs.getInt("CART_QTY"));
				dto.setGoodsImage(rs.getString("goods_main_store_image"));
				dto.setGoodsName(rs.getString("goods_Name"));
				dto.setGoodsNum(rs.getString("goods_Num"));
				dto.setGoodsPrice(rs.getInt("goods_Price"));
				dto.setMemberNum(rs.getString("member_num"));
				dto.setTotalPrice(rs.getInt("total_price"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void cartMerge(CartDTO dto) {
		con = getConnection();
		sql = " merge into cart c "
			+ " using (select goods_num from goods where goods_num = ? ) g"
			+ " on (c.goods_num = g.goods_num and c.member_num = ? ) "
			+ " when matched then "
			+ " 	update set CART_QTY = CART_QTY + ? "
			+ " when not matched then "
			+ " 	insert (MEMBER_NUM,GOODS_NUM,CART_DATE, CART_QTY) "
			+ " 	values (?, g.goods_num, sysdate, ? )";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, dto.getMemberNum());
			pstmt.setInt(3, dto.getCartQty());
			pstmt.setString(4, dto.getMemberNum());
			pstmt.setInt(5, dto.getCartQty());
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이(가) 병합되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public WishDTO wishSelectOne(WishDTO dto) {
		WishDTO wdto = null;
		 con = getConnection();
		 sql = " select * from wish where goods_num = ? and member_num = ? ";
		 try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, dto.getMemberNum());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				wdto = new WishDTO();
				wdto.setGoodsNum(rs.getString("goods_num"));
				wdto.setMemberNum(rs.getString("member_num"));
				wdto.setWishDate(rs.getString("wish_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wdto;
	}
	
	public void wishInsert(WishDTO dto) {
		con = getConnection();
		sql  = " merge into wish w  "
			 + " using (select goods_num from goods where goods_num = ?) g "
			 + " on (w.goods_num = g.goods_num and w.member_num = ? )"
			 + " when matched then "
			 + " 	update set WISH_DATE = sysdate "
			 + "    delete where goods_num = ? and member_num  = ? "
			 + " when not matched then "
			 + " 	insert (member_num, goods_num , WISH_DATE) "
			 + "    values (?, g.goods_num , sysdate) ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, dto.getMemberNum());
			pstmt.setString(3, dto.getGoodsNum());
			pstmt.setString(4, dto.getMemberNum());
			pstmt.setString(5, dto.getMemberNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + " 행이(가) 병합되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}






