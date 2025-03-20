package jspMVCHKShopping.model;

public class GoodsDTO {
	// 멤버필드 , 멤버변수 , 인스턴스변수
	String goodsNum;
	String goodsName;
	int goodsPrice;
	String goodsContent;
	int visitCount;
	String empNum;
	String goodsRegist;
	String updateEmpNum;
	String goodsUpdateDate;
	String goodsMainImage;
	String goodsMainStoreImage;	
	String goodsDetailImage;
	String goodsDetailStoreImage;
	public String getGoodsDetailImage() {
		return goodsDetailImage;
	}
	public void setGoodsDetailImage(String goodsDetailImage) {
		this.goodsDetailImage = goodsDetailImage;
	}
	public String getGoodsDetailStoreImage() {
		return goodsDetailStoreImage;
	}
	public void setGoodsDetailStoreImage(String goodsDetailStoreImage) {
		this.goodsDetailStoreImage = goodsDetailStoreImage;
	}
	public String getGoodsMainImage() {
		return goodsMainImage;
	}
	public void setGoodsMainImage(String goodsMainImage) {
		this.goodsMainImage = goodsMainImage;
	}
	public String getGoodsMainStoreImage() {
		return goodsMainStoreImage;
	}
	public void setGoodsMainStoreImage(String goodsMainStoreImage) {
		this.goodsMainStoreImage = goodsMainStoreImage;
	}
	// getter : 멤버필드 값을 전달할 때 사용
	public String getUpdateEmpNum() {
		return updateEmpNum;
	}
	//setter : 멤버필드에 값을 저장할 때 사용
	public void setUpdateEmpNum(String updateEmpNum) {
		this.updateEmpNum = updateEmpNum;
	}
	public String getGoodsUpdateDate() {
		return goodsUpdateDate;
	}
	public void setGoodsUpdateDate(String goodsUpdateDate) {
		this.goodsUpdateDate = goodsUpdateDate;
	}
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	public String getGoodsRegist() {
		return goodsRegist;
	}
	public void setGoodsRegist(String goodsRegist) {
		this.goodsRegist = goodsRegist;
	}
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsContent() {
		return goodsContent;
	}
	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}
	public int getVisitCount() {
		return visitCount;
	}
	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}
}





