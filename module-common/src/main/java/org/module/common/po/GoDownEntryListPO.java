package org.module.common.po;
/**
 * 
 *库存入库单（快递编号、入库日期、目的地、区号、排号、架号、位号）
 */
public class GoDownEntryListPO {
	
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
	/**
	 * 单据状态
	 */
	private State state;

	public GoDownEntryListPO(String courier, String date, String destination,
			String qu, String pai, String jia, String wei, String state) {
		super();
		id = courier;
		this.date = date;
		this.destination = destination;
		this.qu = qu;
		this.pai = pai;
		this.jia = jia;
		this.wei = wei;
		this.state = State.getInstance(state);
	}

	public String getCourier() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getDestination() {
		return destination;
	}

	public String getQu() {
		return qu;
	}

	public String getPai() {
		return pai;
	}

	public String getJia() {
		return jia;
	}

	public String getWei() {
		return wei;
	}

	public State getState() {
		return state;
	}
	
	
	
}
