package org.module.common.po;

import java.io.Serializable;

public class WarehousePO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1576332939454745445L;
	private String number;
	private String qu;
	private String pai;
	private String jia;
	private String wei;
	
	private String warehouseOfWhichTranCenter;
	private String date;
	
	public boolean samePalace(WarehousePO po){
		return 
				this.warehouseOfWhichTranCenter.equals(po.warehouseOfWhichTranCenter) &&
				this.qu.equals(po.qu) &&
				this.pai.equals(po.pai) &&
				this.jia.equals(po.jia) &&
				this.wei.equals(po.wei);
	}
	
	final private String split=":%:%:";
	@Override
	public String toString(){
		return this.number+this.split+this.qu
				+this.split+this.pai+this.split
				+this.jia+this.split+this.wei + 
				this.split + 
				this.warehouseOfWhichTranCenter + this.split
				+ this.date;
	}
	public WarehousePO(String str) {
		super();
		String[] strs=str.split(this.split);
		this.number = strs[0];
		this.qu = strs[1];
		this.pai = strs[2];
		this.jia = strs[3];
		this.wei = strs[4];
		this.warehouseOfWhichTranCenter = strs[5];
		this.date = strs[6];
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNumber() {
		return number;
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
	public String getWarehouseOfWhichTranCenter() {
		return warehouseOfWhichTranCenter;
	}
	public String getDate() {
		return date;
	}
	public String getSplit() {
		return split;
	}
	public WarehousePO(String number, String qu, String pai, String jia,
			String wei, String warehouseOfWhichTranCenter, String data) {
		super();
		this.number = number;
		this.qu = qu;
		this.pai = pai;
		this.jia = jia;
		this.wei = wei;
		this.warehouseOfWhichTranCenter = warehouseOfWhichTranCenter;
		this.date = data;
	}
	
	
	
}
