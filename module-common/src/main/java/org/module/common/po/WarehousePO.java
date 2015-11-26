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
	final private String split=":%:%:";
	@Override
	public String toString(){
		return this.number+this.split+this.qu
				+this.split+this.pai+this.split
				+this.jia+this.split+this.wei;
	}
	public WarehousePO(String str) {
		super();
		String[] strs=str.split(this.split);
		this.number = strs[0];
		this.qu = strs[1];
		this.pai = strs[2];
		this.jia = strs[3];
		this.wei = strs[4];
	}
	public WarehousePO(String number, String qu, String pai, String jia,
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
