package jspMVCHKShopping.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
				       // 상속
public class GoodsDAO extends DataBaseInfo{
	public void visitCountUpdate(String goodsNum) {
		con = getConnection();
		sql = " update goods "
			+ " set visit_count = visit_count + 1 "
			+ " where goods_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이(가) 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public int goodsDelete(String goodsNum) {
		con = getConnection();
		sql = " delete from goods where goods_num = ? ";
		int i = 0;
		try { //지역변수, 블록변수
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public String employeeNumSelect(String empId) {
		String empNum = null;
		con = getConnection();
		sql = " select EMP_NUM from employees where emp_id = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				empNum = rs.getString("EMP_NUM");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empNum;
	}
	public void goodsUpdate(GoodsDTO dto) {
		con = getConnection();
		sql = " update goods "
			+ " set GOODS_NAME = ?, GOODS_PRICE = ?"
			+ "    ,GOODS_CONTENTS = ? "
			+ "    ,UPDATE_EMP_NUM = ?, GOODS_UPDATE_DATE = sysdate"
			+ " where GOODS_NUM = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsName());
			pstmt.setInt(2, dto.getGoodsPrice());
			pstmt.setString(3, dto.getGoodsContent());
			pstmt.setString(4, dto.getUpdateEmpNum());
			pstmt.setString(5, dto.getGoodsNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 수정되었습니다.");			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}
	}
	public GoodsDTO goodsSelectOne(String goodsNum) {
		GoodsDTO dto = null;
		con = getConnection();
		sql = " select GOODS_NUM,GOODS_NAME, GOODS_PRICE,GOODS_CONTENTS,VISIT_COUNT"
				+ "   ,EMP_NUM , GOODS_REGIST, UPDATE_EMP_NUM, GOODS_UPDATE_DATE "
				+ "   ,GOODS_MAIN_IMAGE, GOODS_MAIN_STORE_IMAGE"
				+ "   ,GOODS_DETAIL_IMAGE, GOODS_DETAIL_STORE_IMAGE "
			+ " from goods "
			+ " where GOODS_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new GoodsDTO();
				dto.setGoodsDetailImage(rs.getString("GOODS_DETAIL_IMAGE"));
				dto.setGoodsDetailStoreImage(rs.getString("GOODS_DETAIL_STORE_IMAGE"));
				dto.setGoodsMainImage(rs.getString("GOODS_MAIN_IMAGE"));
				dto.setGoodsMainStoreImage(rs.getString("GOODS_MAIN_STORE_IMAGE"));
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setGoodsName(rs.getString("GOODS_NAME"));
				dto.setGoodsPrice(rs.getInt("GOODS_PRICE"));
				dto.setGoodsContent(rs.getString("GOODS_CONTENTS"));
				dto.setVisitCount(rs.getInt(5));
				dto.setEmpNum(rs.getString("EMP_NUM"));
				dto.setGoodsRegist(rs.getString("GOODS_REGIST"));
				dto.setUpdateEmpNum(rs.getString("UPDATE_EMP_NUM"));
				dto.setGoodsUpdateDate(rs.getString("GOODS_UPDATE_DATE"));
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
			+ "        , GOODS_MAIN_STORE_IMAGE"
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
				dto.setGoodsMainStoreImage(rs.getString("GOODS_MAIN_STORE_IMAGE"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}
		return list;
	}
	
	public void goodsInsert(GoodsDTO dto) { // 매개변수:parameter
		con = getConnection();
		sql = " insert into goods (GOODS_NUM,GOODS_NAME, GOODS_PRICE,GOODS_CONTENTS,VISIT_COUNT"
				+ "                ,emp_num, GOODS_REGIST"
				+ "				   ,GOODS_MAIN_IMAGE, GOODS_MAIN_STORE_IMAGE"
				+ "                ,GOODS_DETAIL_IMAGE, GOODS_DETAIL_STORE_IMAGE) "
			+ " values( ?, ?, ?, ?, 0,?, sysdate,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, dto.getGoodsName());
			pstmt.setInt(3, dto.getGoodsPrice());
			pstmt.setString(4, dto.getGoodsContent());
			pstmt.setString(5, dto.getEmpNum());
			pstmt.setString(6, dto.getGoodsMainImage());
			pstmt.setString(7, dto.getGoodsMainStoreImage());
			pstmt.setString(8, dto.getGoodsDetailImage());
			pstmt.setString(9, dto.getGoodsDetailStoreImage());
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
