package org.module.client.vo;

import org.module.common.po.MailingListPO;
import org.module.common.po.State;



public class MailingListVO {

	private String senderName;
	private String senderCompany;
	private String senderMobile;
	private String senderPhone;
	private String senderCity;
	private String senderPosition;
	private String receiveName;
	private String receiveCompany;
	private String receiveMobile;
	private String receivePhone;
	private String receiveCity;
	private String receivePosition;
	private String nameOfGood;
	private String counts;
	private String weight;
	private String volume;
	private String costOfDecoration;
	private String type;
	private String id;
	//private State state;
	
	public MailingListVO(MailingListPO po){
		this(  po.getSenderName(),
				po.getSenderCompany(),
				po.getSenderMobile(),
				po.getSenderPhone(),
				po.getSenderCity(),
				po.getSenderPosition(),
				po.getReceiveName(),
				po.getReceiveCompany(),
				po.getReceiveMobile(),
				po.getReceivePhone(),
				po.getReceiveCity(),
				po.getReceivePosition(),
				po.getNameOfGood(),
				po.getCounts(),
				po.getWeight(),
				po.getVolume(),
				po.getCostOfDecoration(),
				po.getType(),
				po.getId()
				);
	}
	
	public MailingListPO toPO(State state){
		return new MailingListPO(getSenderName(),
				getSenderCompany(),
				getSenderMobile(),
				getSenderPhone(),
			    getSenderCity(),
			    getSenderPosition(),
				getReceiveName(),
				getReceiveCompany(),
				getReceiveMobile(),
				getReceivePhone(),
				getReceiveCity(),
				getReceivePosition(),
				getNameOfGood(),
				getCounts(),
				getWeight(),
				getVolume(),
				getCostOfDecoration(),
				getType(),
				getId(),
				state);
	}
	
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderCompany() {
		return senderCompany;
	}
	public void setSenderCompany(String senderCompany) {
		this.senderCompany = senderCompany;
	}
	public String getSenderMobile() {
		return senderMobile;
	}
	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}
	public String getSenderPhone() {
		return senderPhone;
	}
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}
	public String getSenderCity() {
		return senderCity;
	}
	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}
	public String getSenderPosition() {
		return senderPosition;
	}
	public void setSenderPosition(String senderPosition) {
		this.senderPosition = senderPosition;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getReceiveCompany() {
		return receiveCompany;
	}
	public void setReceiveCompany(String receiveCompany) {
		this.receiveCompany = receiveCompany;
	}
	public String getReceiveMobile() {
		return receiveMobile;
	}
	public void setReceiveMobile(String receiveMobile) {
		this.receiveMobile = receiveMobile;
	}
	public String getReceivePhone() {
		return receivePhone;
	}
	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}
	public String getReceiveCity() {
		return receiveCity;
	}
	public void setReceiveCity(String receiveCity) {
		this.receiveCity = receiveCity;
	}
	public String getReceivePosition() {
		return receivePosition;
	}
	public void setReceivePosition(String receivePosition) {
		this.receivePosition = receivePosition;
	}
	public String getNameOfGood() {
		return nameOfGood;
	}
	public void setNameOfGood(String nameOfGood) {
		this.nameOfGood = nameOfGood;
	}
	public String getCounts() {
		return counts;
	}
	public void setCounts(String counts) {
		this.counts = counts;
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
	public String getCostOfDecoration() {
		return costOfDecoration;
	}
	public void setCostOfDecoration(String costOfDecoration) {
		this.costOfDecoration = costOfDecoration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MailingListVO(String senderName, String senderCompany,
			String senderMobile, String senderPhone, String senderCity,
			String senderPosition, String receiveName, String receiveCompany,
			String receiveMobile, String receivePhone, String receiveCity,
			String receivePosition, String nameOfGood, String counts,
			String weight, String volume, String costOfDecoration, String type,
			String id) {
		super();
		this.senderName = senderName;
		this.senderCompany = senderCompany;
		this.senderMobile = senderMobile;
		this.senderPhone = senderPhone;
		this.senderCity = senderCity;
		this.senderPosition = senderPosition;
		this.receiveName = receiveName;
		this.receiveCompany = receiveCompany;
		this.receiveMobile = receiveMobile;
		this.receivePhone = receivePhone;
		this.receiveCity = receiveCity;
		this.receivePosition = receivePosition;
		this.nameOfGood = nameOfGood;
		this.counts = counts;
		this.weight = weight;
		this.volume = volume;
		this.costOfDecoration = costOfDecoration;
		this.type = type;
		this.id = id;
		//this.state = State.getInstance(state);
	}
	/*public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}*/
}
