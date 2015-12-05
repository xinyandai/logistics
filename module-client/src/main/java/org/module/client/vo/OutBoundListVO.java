package org.module.client.vo;

import org.module.common.po.OutBoundListPO;
import org.module.common.po.State;

/**
 * 库存出库单
 * （快递编号、出库日期、目的地、装运形式（火车、飞机、汽车）、中转单编号或者汽运编号）
 *
 */
public class OutBoundListVO  extends AbstractVO{

	/**
	 * 快递编号
	 */
	private String id;
	/**
	 * 出库日期
	 */
	private String date;
	/**
	 * 目的地
	 */
	private String destination;
	/**
	 * 装运形式
	 */
	private String typeOfLoading;
	/**
	 * 中转单编号或者货运编号
	 */
	private String tansportListId;
//	private String carId;
	
	
	public OutBoundListVO(String id, String date, String destination,
			String typeOfLoading, String tansportListId) {
		super();
		this.id = id;
		this.date = date;
		this.destination = destination;
		this.typeOfLoading = typeOfLoading;
		this.tansportListId = tansportListId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getTypeOfLoading() {
		return typeOfLoading;
	}
	public void setTypeOfLoading(String typeOfLoading) {
		this.typeOfLoading = typeOfLoading;
	}
	public String getTansportListId() {
		return tansportListId;
	}
	public void setTansportListId(String tansportListId) {
		this.tansportListId = tansportListId;
	}
	
	public OutBoundListVO(OutBoundListPO po){
		this(po.getId(),po.getDate(),po.getDestination(),po.getTypeOfLoading(),po.getTypeOfLoading());
	}
	public OutBoundListPO toPO( State state ){
		return new OutBoundListPO(
				this.id ,
				this.date ,
				this.destination ,
				this.typeOfLoading ,
				this.tansportListId ,
				state
				);
	}
	public String[] toArray(){
		String[] s = {
				this.id ,
				this.date ,
				this.destination ,
				this.typeOfLoading ,
				this.tansportListId 
		};
		return s;
	}
	
	@Override
	public String get(int i) {
		// TODO Auto-generated method stub
		return this.toArray()[i];
	}
	@Override
	public String[] names() {
		String[] s = {
				"物流单号","出库日期","目的地","装车方式","中转单"
		};
	    return s;
	}
	
	
	
}
