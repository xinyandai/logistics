package org.module.client.vo;
/**
 * 
 *库存入库单（快递编号、入库日期、目的地、区号、排号、架号、位号）
 */
public class GoDownEntryVO {
    /**
	 * 快递单号
	 */
	private String id;

	
	
	/**
	 * 入库日期
	 */
	private String date;
	/**
	 * 目的地
	 */
	private String destination;
	/**
	 * 区
	 */
	private String qu;
	/**
	 * 排
	 */
	private String pai;
	/**
	 * 架
	 */
	private String jia;
	/**
	 * 位
	 */
	private String wei;
	public GoDownEntryVO(String courier, String date, String destination,
			String qu, String pai, String jia, String wei) {
		super();
		id = courier;
		this.date = date;
		this.destination = destination;
		this.qu = qu;
		this.pai = pai;
		this.jia = jia;
		this.wei = wei;
	}
	public String getCourier() {
		return id;
	}
	public void setCourier(String courier) {
		id = courier;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
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
