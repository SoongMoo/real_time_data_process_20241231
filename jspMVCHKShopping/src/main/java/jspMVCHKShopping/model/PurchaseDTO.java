package jspMVCHKShopping.model;

public class PurchaseDTO {
	String purchaseNum;
	String purchaseDate;
	Long purchasePrice;
	String deliveryName; // 받는 사람이름
	String deliveryAddr;
	String deliveryAddrDetail;
	String deliveryPost;
	String deliveryPhone;
	String message;
	String purchaseStatus;
	String memberNum;
	
	String purchaseName; // 구매상품이름
	public String getPurchaseName() {
		return purchaseName;
	}
	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}
	
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Long getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Long purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public String getDeliveryAddr() {
		return deliveryAddr;
	}
	public void setDeliveryAddr(String deliveryAddr) {
		this.deliveryAddr = deliveryAddr;
	}
	public String getDeliveryAddrDetail() {
		return deliveryAddrDetail;
	}
	public void setDeliveryAddrDetail(String deliveryAddrDetail) {
		this.deliveryAddrDetail = deliveryAddrDetail;
	}
	public String getDeliveryPost() {
		return deliveryPost;
	}
	public void setDeliveryPost(String deliveryPost) {
		this.deliveryPost = deliveryPost;
	}
	public String getDeliveryPhone() {
		return deliveryPhone;
	}
	public void setDeliveryPhone(String deliveryPhone) {
		this.deliveryPhone = deliveryPhone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPurchaseStatus() {
		return purchaseStatus;
	}
	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	public String getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}

}
