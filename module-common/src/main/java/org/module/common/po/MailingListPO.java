package org.module.common.po;

public class MailingListPO {
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
	
	private State state;

	public MailingListPO(String senderName, String senderCompany,
			String senderMobile, String senderPhone, String senderCity,
			String senderPosition, String receiveName, String receiveCompany,
			String receiveMobile, String receivePhone, String receiveCity,
			String receivePosition, String nameOfGood, String counts,
			String weight, String volume, String costOfDecoration, String type,
			String id, String state) {
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
		this.state = State.getInstance(state);
	}

	public String getSenderName() {
		return senderName;
	}

	public String getSenderCompany() {
		return senderCompany;
	}

	public String getSenderMobile() {
		return senderMobile;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public String getSenderCity() {
		return senderCity;
	}

	public String getSenderPosition() {
		return senderPosition;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public String getReceiveCompany() {
		return receiveCompany;
	}

	public String getReceiveMobile() {
		return receiveMobile;
	}

	public String getReceivePhone() {
		return receivePhone;
	}

	public String getReceiveCity() {
		return receiveCity;
	}

	public String getReceivePosition() {
		return receivePosition;
	}

	public String getNameOfGood() {
		return nameOfGood;
	}

	public String getCounts() {
		return counts;
	}

	public String getWeight() {
		return weight;
	}

	public String getVolume() {
		return volume;
	}

	public String getCostOfDecoration() {
		return costOfDecoration;
	}

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public State getState() {
		return state;
	}
	
	
	
	
	
}
