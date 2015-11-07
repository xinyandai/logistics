package org.module.common.po;

public class AccountPO {
	private String id;
	private String money;
	public AccountPO(String id, String money) {
		super();
		this.id = id;
		this.money = money;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	
}
