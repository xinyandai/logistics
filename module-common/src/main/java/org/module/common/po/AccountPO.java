package org.module.common.po;

import java.io.Serializable;

public class AccountPO implements Serializable{
	
	private static final long serialVersionUID = -5647838700427395670L;
	
	private String id;
	private String money;
	final private String split = ":%:%:";
	public AccountPO(String id, String money) {
		super();
		this.id = id;
		this.money = money;
	}
	@Override
	public String toString(){
		return this.id + this.split + this.money;
	}
	public AccountPO(String string) {
		String[] strs = string.split(split);
		this.id = strs [0];
		this.money = strs[1];
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
