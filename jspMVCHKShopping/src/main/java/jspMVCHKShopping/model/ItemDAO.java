package jspMVCHKShopping.model;

import java.sql.SQLException;

public class ItemDAO extends DataBaseInfo{
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






