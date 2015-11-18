package org.module.client.vo;

/**
 * 当营业厅送达货物到中转中心之后业务员生成中转中心到达单。
 * 中转中心到达单前缀：
 * 中转中心编号（025城市编码+0中转中心）、
 * 到达日期、
 * 中转单编号（若是由营业厅运送过来直接填写装车单）、
 * 出发地、
 * 货物到达状态（损坏、完整、丢失））
 * @author 
 *
 */

public class TranCenterArrivalListVO {

	private String transId;
	private String date;
	private String transportListId;
	private String origin;
	private String state;
	public TranCenterArrivalListVO(String transId, String date,
			String transportListId, String origin, String state) {
		super();
		this.transId = transId;
		this.date = date;
		this.transportListId = transportListId;
		this.origin = origin;
		this.state = state;
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTransportListId() {
		return transportListId;
	}
	public void setTransportListId(String transportListId) {
		this.transportListId = transportListId;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
