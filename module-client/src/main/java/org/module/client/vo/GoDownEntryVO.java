package org.module.client.vo;

import org.module.common.po.GoDownEntryListPO;
import org.module.common.po.State;

/**
 * 
 *库存入库单（快递编号、入库日期、目的地、区号、排号、架号、位号）
 */
public class GoDownEntryVO extends AbstractVO{
   
	private String warehouseOfWhichTranCenter;
	
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
	private State state;
	
	public GoDownEntryVO(String warehouseOfWhichTranCenter,String courier, String date, String destination,
			String qu, String pai, String jia, String wei,State state) {
		super();
		this.warehouseOfWhichTranCenter = warehouseOfWhichTranCenter;
		id = courier;
		this.date = date;
		this.destination = destination;
		this.qu = qu;
		this.pai = pai;
		this.jia = jia;
		this.wei = wei;
		this.state = state;
	}

	
	public GoDownEntryVO(GoDownEntryListPO goDownEntryListPO) {
		this(goDownEntryListPO.getWarehouseOfWhichTranCenter(),
				goDownEntryListPO.getId(),
				goDownEntryListPO.getDate(),
				goDownEntryListPO.getDestination(),
				goDownEntryListPO.getQu(),
				goDownEntryListPO.getPai(),
				goDownEntryListPO.getJia(),
				goDownEntryListPO.getWei(),
				goDownEntryListPO.getState());
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
	public String getWarehouseOfWhichTranCenter() {
		return warehouseOfWhichTranCenter;
	}
	public void setWarehouseOfWhichTranCenter(String warehouseOfWhichTranCenter) {
		this.warehouseOfWhichTranCenter = warehouseOfWhichTranCenter;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

    public State getState() {
		return state;
	}


	public void setState(State state) {
		this.state = state;
	}


	public String[] toArray(){
    	String[] s = {this.warehouseOfWhichTranCenter ,
		id ,
		this.date,
		this.destination,
		this.qu,
		this.pai,
		this.jia ,
		this.wei,
		this.state.toString()};
    	return s;
    }
	
	@Override
	public String get(int i) {
		return this.toArray()[i];
	}


	public GoDownEntryListPO toPO() {
		// TODO Auto-generated method stub
		return new GoDownEntryListPO(this.warehouseOfWhichTranCenter ,
		id ,
		this.date,
		this.destination,
		this.qu,
		this.pai,
		this.jia ,
		this.wei,
		this.state);
	}


	@Override
	public String[] names() {
		String[] s = {
				"中转中心","快递编号","入库日期","目的地","区号","排号","架号","位号","状态"
		};
	    return s;
	}
}
