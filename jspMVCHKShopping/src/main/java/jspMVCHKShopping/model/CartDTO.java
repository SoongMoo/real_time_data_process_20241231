package jspMVCHKShopping.model;

public class CartDTO {
	String memberNum;
	String goodsNum;
	Integer cartQty;  
	String cartDate;
	public String getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public Integer getCartQty() {
		return cartQty;
	}
	public void setCartQty(Integer cartQty) {
		this.cartQty = cartQty;
	}
	public String getCartDate() {
		return cartDate;
	}
	public void setCartDate(String cartDate) {
		this.cartDate = cartDate;
	}
}
