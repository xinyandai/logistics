package org.module.client.vo;

import org.module.common.po.CarPO;

public class CarVO extends AbstractVO{

	private String id;
	private String License;
	private String time;
	
	
	public CarVO(String id, String license, String time) {
		super();
		this.id = id;
		License = license;
		this.time = time;
	}
	public CarVO(CarPO carPO) {
		this(
				carPO.getId(),
				carPO.getLicense(),
				carPO.getTime()
				);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLicense() {
		return License;
	}
	public void setLicense(String license) {
		License = license;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String[] toArray() {
		String[] re = new String[3];
		re[0] = id;
		re[1] = this.License;
		re[2] = time;
		return re;
	}
	
	
	
	@Override
	public String get(int i) {
		return this.toArray()[i];
	}
	@Override
	public String[] names() {
		String[] s = {"车辆代号","车牌号","服役时间"};
		return s;
	}

}
