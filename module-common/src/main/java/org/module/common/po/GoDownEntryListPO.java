package org.module.common.po;

import java.io.Serializable;

/**
 * 
 *库存入库单（快递编号、入库日期、目的地、区号、排号、架号、位号）
 */
public class GoDownEntryListPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4680037496734611274L;
	
	private String warehouseOfWhichTranCenter;
	
	public String getWarehouseOfWhichTranCenter() {
		return warehouseOfWhichTranCenter;
	}

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

	public GoDownEntryListPO(String warehouseOfWhichTranCenter,String courier, String date, String destination,
			String qu, String pai, String jia, String wei, State state) {
		super();
		this.warehouseOfWhichTranCenter = warehouseOfWhichTranCenter;
		id = courier;
		this.date = date;
		this.destination = destination;
		this.qu = qu;
		this.pai = pai;
		this.jia = jia;
		this.wei = wei;
		this.state =state;
	}

	final private String spt = ":%：%：";
	public GoDownEntryListPO(String string) {
		String[] s = string.split(spt);
		this.warehouseOfWhichTranCenter = s[0];
	    this.id = s[1];
		this.date = s[2];
		this.destination = s[3];
		this.qu = s[4];
		this.pai = s[5];
		this.jia = s[6];
		this.wei = s[7];
		this.state = State.getInstance(s[8]);
	}
	
	@Override
	public String toString(){
		return  this.warehouseOfWhichTranCenter + this.spt +
				this.id + this.spt+
				this.date + this.spt+
				this.destination + this.spt+
				this.qu + this.spt+
				this.pai + this.spt+
				this.jia + this.spt+
				this.wei + this.spt+
				this.state.toString();
	}

	public String getId() {
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
