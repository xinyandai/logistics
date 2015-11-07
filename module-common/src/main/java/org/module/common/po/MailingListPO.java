package org.module.common.po;

public class MailingListPO {
	private String sendername;
	private String senderhome;
	private String sendercompany;
	private String senderphone;
	private String sendermobile;
	private String recipientname;
	private String recipienthome;
	private String recipientcompany;
	private String recipientphone;
	private String recipientmobile;
	private String number;
	private String weight;
	private String volume;
	private String goodsname;
	private String way;
	private String packing;
	private String price;
	private String orderId;
	public MailingListPO(String sendername, String senderhome,
			String sendercompany, String senderphone, String sendermobile,
			String recipientname, String recipienthome,
			String recipientcompany, String recipientphone,
			String recipientmobile, String number, String weight,
			String volume, String goodsname, String way, String packing,
			String price, String orderId) {
		super();
		this.sendername = sendername;
		this.senderhome = senderhome;
		this.sendercompany = sendercompany;
		this.senderphone = senderphone;
		this.sendermobile = sendermobile;
		this.recipientname = recipientname;
		this.recipienthome = recipienthome;
		this.recipientcompany = recipientcompany;
		this.recipientphone = recipientphone;
		this.recipientmobile = recipientmobile;
		this.number = number;
		this.weight = weight;
		this.volume = volume;
		this.goodsname = goodsname;
		this.way = way;
		this.packing = packing;
		this.price = price;
		this.orderId = orderId;
	}
	public String getSendername() {
		return sendername;
	}
	public void setSendername(String sendername) {
		this.sendername = sendername;
	}
	public String getSenderhome() {
		return senderhome;
	}
	public void setSenderhome(String senderhome) {
		this.senderhome = senderhome;
	}
	public String getSendercompany() {
		return sendercompany;
	}
	public void setSendercompany(String sendercompany) {
		this.sendercompany = sendercompany;
	}
	public String getSenderphone() {
		return senderphone;
	}
	public void setSenderphone(String senderphone) {
		this.senderphone = senderphone;
	}
	public String getSendermobile() {
		return sendermobile;
	}
	public void setSendermobile(String sendermobile) {
		this.sendermobile = sendermobile;
	}
	public String getRecipientname() {
		return recipientname;
	}
	public void setRecipientname(String recipientname) {
		this.recipientname = recipientname;
	}
	public String getRecipienthome() {
		return recipienthome;
	}
	public void setRecipienthome(String recipienthome) {
		this.recipienthome = recipienthome;
	}
	public String getRecipientcompany() {
		return recipientcompany;
	}
	public void setRecipientcompany(String recipientcompany) {
		this.recipientcompany = recipientcompany;
	}
	public String getRecipientphone() {
		return recipientphone;
	}
	public void setRecipientphone(String recipientphone) {
		this.recipientphone = recipientphone;
	}
	public String getRecipientmobile() {
		return recipientmobile;
	}
	public void setRecipientmobile(String recipientmobile) {
		this.recipientmobile = recipientmobile;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public String getPacking() {
		return packing;
	}
	public void setPacking(String packing) {
		this.packing = packing;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
