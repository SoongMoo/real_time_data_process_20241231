package jspMVCHKShopping.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAO extends DataBaseInfo{
	public int goodsDelete(String goodsNum) {
		con = getConnection();
		sql = " delete from goods where goods_num = ? ";
		int i = 0;
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}
		return i;
	}
	public void goodsUpdate(GoodsDTO dto) {
		con = getConnection();
		sql = " update goods "
			+ " set GOODS_NAME = ?, GOODS_PRICE = ?"
			+ "    ,GOODS_CONTENTS = ?"
			+ " where GOODS_NUM = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsName());
			pstmt.setInt(2, dto.getGoodsPrice());
			pstmt.setString(3, dto.getGoodsContent());
			pstmt.setString(4, dto.getGoodsNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 수정되었습니다.");			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}
	}
	public GoodsDTO goodsSelectOne(String goodsNum) {
		GoodsDTO dto = null;
		con = getConnection();
		sql = " select GOODS_NUM,GOODS_NAME, GOODS_PRICE,GOODS_CONTENTS,VISIT_COUNT "
			+ " from goods "
			+ " where GOODS_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new GoodsDTO();
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setGoodsName(rs.getString("GOODS_NAME"));
				dto.setGoodsPrice(rs.getInt("GOODS_PRICE"));
				dto.setGoodsContent(rs.getString("GOODS_CONTENTS"));
				dto.setVisitCount(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}
		return dto;
	}
	
	public List<GoodsDTO> goodsSelectAll() {
		List<GoodsDTO> list = new ArrayList<GoodsDTO>(); 
		con = getConnection();
		sql = " select GOODS_NUM,GOODS_NAME, GOODS_PRICE,GOODS_CONTENTS,VISIT_COUNT "
			+ " from goods ";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodsDTO dto = new GoodsDTO();
				dto.setGoodsNum(rs.getString(1));
				dto.setGoodsName(rs.getString(2));
				dto.setGoodsPrice(rs.getInt(3));
				dto.setGoodsContent(rs.getString(4));
				dto.setVisitCount(5);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}
		return list;
	}
	
	public void goodsInsert(GoodsDTO dto) {
		con = getConnection();
		sql = " insert into goods (GOODS_NUM,GOODS_NAME, GOODS_PRICE,GOODS_CONTENTS,VISIT_COUNT) "
			+ " values( ?, ?, ?, ?, 0)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, dto.getGoodsName());
			pstmt.setInt(3, dto.getGoodsPrice());
			pstmt.setString(4, dto.getGoodsContent());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개행이(가) 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}
	}
	public String goodsAutoNum() {
		String goodsNum = null;
		con = getConnection();
		sql = " select concat('goods_', nvl(max(substr(goods_num, 7)), 100000) + 1) from goods ";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			goodsNum = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}
		return goodsNum;
	}
}
