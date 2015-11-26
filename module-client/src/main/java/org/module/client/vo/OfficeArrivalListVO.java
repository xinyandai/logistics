package org.module.client.vo;
/**
 * 当其它营业厅或中转中心送达货物，首先营业厅业务员生成营业厅到达单。
 * 营业厅到达单前缀为： 
 * 包含货物到达信息（到达日期、中转单编号(如果是由中转中心运送过来的话否则直接填写装车单)、出发地、货物到达状态（损坏、完整、丢失））
 * @author 
 *
 */
public class OfficeArrivalListVO {

	private String officeid;
	private String date;
	private String transportListId;
	private String origin;
	private String stateOfGoods;
	private String state;
	public String getOfficeid() {
		return officeid;
	}
	public void setOfficeid(String officeid) {
		this.officeid = officeid;
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
	public OfficeArrivalListVO(String officeid, String date,
			String transportListId, String origin, String stateOfGoods,String state) {
		super();
		this.officeid = officeid;
		this.date = date;
		this.transportListId = transportListId;
		this.origin = origin;
		this.stateOfGoods = stateOfGoods;
		this.state = state;
	}
	public String getStateOfGoods() {
		return stateOfGoods;
	}
	public void setStateOfGoods(String stateOfGoods) {
		this.stateOfGoods = stateOfGoods;
	}
	
}
