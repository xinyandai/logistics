package org.module.common.po;

import java.io.Serializable;

public class WarehouseStorage implements Serializable {

	private static final long serialVersionUID = 691408033266114598L;

	
	
	private String number;
	private String qu;
	private String pai;
	private String jia;
	private String wei;
	/**
	 * 所属仓库
	 */
	private String warehouseOfWhichTranCenter;
	/**
	 * 每一个位置均有一个唯一ID
	 */
	private String id;
	
	
	final private String split=":%:%:";
	@Override
	public String toString(){
		return this.number+this.split+this.qu
				+this.split+this.pai+this.split
				+this.jia+this.split+this.wei + 
				this.split + this.id + this.split +
				this.warehouseOfWhichTranCenter;
	}
	public WarehouseStorage(String str) {
		super();
		String[] strs=str.split(this.split);
		this.number = strs[0];
		this.qu = strs[1];
		this.pai = strs[2];
		this.jia = strs[3];
		this.wei = strs[4];
		this.warehouseOfWhichTranCenter = strs[5];
		this.id = strs[6];
	}
	public String getId() {
		return id;
	}
	public WarehouseStorage(String number, String qu, String pai, String jia,
			String wei,String warehouseOfWhichTranCenter) {
		super();
		this.number = number;
		this.qu = qu;
		this.pai = pai;
		this.jia = jia;
		this.wei = wei;
		this.warehouseOfWhichTranCenter = warehouseOfWhichTranCenter;
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
	public String getWarehouseOfWhichTranCenter() {
		return warehouseOfWhichTranCenter;
	}
}
