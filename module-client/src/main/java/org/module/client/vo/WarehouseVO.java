package org.module.client.vo;

import org.module.common.po.WarehousePO;


public class WarehouseVO extends AbstractVO{

	private String number;
	private String qu;
	private String pai;
	private String jia;
	private String wei;
	private String warehouseOfWhichTranCenter;
	private long date;
	
	public WarehouseVO(WarehousePO po ){
		this(po.getNumber(),
				po.getQu(),
				po.getPai(),
				po.getJia(),
				po.getWei(),
				po.getWarehouseOfWhichTranCenter(),
				Long.parseLong( po.getDate())
				);
	}
	public WarehousePO toVO(){
		return new WarehousePO(this.number ,
				this.qu ,
				this.pai ,
				this.jia ,
				this.wei ,
				this.warehouseOfWhichTranCenter,
				this.date+"");
	}
	
	
	public WarehouseVO(String number, String qu, String pai, String jia,
			String wei, String warehouseOfWhichTranCenter, long data) {
		super();
		this.number = number;
		this.qu = qu;
		this.pai = pai;
		this.jia = jia;
		this.wei = wei;
		this.warehouseOfWhichTranCenter = warehouseOfWhichTranCenter;
		this.date = data;
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

	public void setWarehouseOfWhichTranCenter(String warehouseOfWhichTranCenter) {
		this.warehouseOfWhichTranCenter = warehouseOfWhichTranCenter;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String[] array(){
		String[] s = {
		this.number ,
		this.qu ,
		this.pai ,
		this.jia ,
		this.wei ,
		this.date+""
				};
		return s;
	}
	
	@Override
	public String get(int i) {
		return this.array()[i];
	}
	
	
}
