package org.module.client.vo;


public class WarehouseVO {

	private String number;
	private String qu;
	private String pai;
	private String jia;
	private String wei;
	
	public WarehouseVO(String number, String qu, String pai, String jia,
			String wei) {
		super();
		this.number = number;
		this.qu = qu;
		this.pai = pai;
		this.jia = jia;
		this.wei = wei;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getQu() {
		return qu;
	}
	public void setQu(String qu) {
		this.qu = qu;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	public String getJia() {
		return jia;
	}
	public void setJia(String jia) {
		this.jia = jia;
	}
	public String getWei() {
		return wei;
	}
	public void setWei(String wei) {
		this.wei = wei;
	}
	
}
