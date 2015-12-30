package org.module.client.vo;

import org.module.common.po.OfficeLoadingListPO;
import org.module.common.po.State;

/**
 * 快递员揽件之后，营业厅人员负责分拣和装车，并在系统中录入装车单                    
 * 营业厅装车单前缀：       001
 * 装车日期、                 
 * 本营业厅编号（025城市编码+000鼓楼营业厅）、       
 * 汽运编号 （营业厅编号+20150921日期+00000编码 、五位数字）、        
 * 到达地ID（本地中转中心或者其它营业厅）、         
 * 车辆代号、      
 * 监装员、   
 * 押运员、  
 * 本次装箱所有订单条形码号）、   
 * 运费（运费根据出发地和目的地自动生成）
 * @author 
 *
 */

public class OfficeLoadingListVO extends AbstractLoadingListVO{

	
	
	
	public OfficeLoadingListVO(String loadingDate, String officeId,
			String trucksId, String origin,String target, String carId, String supervision,
			String escort, String[] shippingId, String price,State state,
			String w) {
		super();
		LoadingDate = loadingDate;
		OfficeId = officeId;
		this.trucksId = trucksId;
		this.origin = origin;
		this.target = target;
		this.carId = carId;
		Supervision = supervision;
		this.escort = escort;
		this.shippingIds = shippingId;
		this.price = price;
		this.setState(state);
		this.writer = w;
	}
	public OfficeLoadingListVO(OfficeLoadingListPO officeLoadingListPO) {
		this(
				officeLoadingListPO.getLoadingDate(),
				officeLoadingListPO.getOfficeId(),
				officeLoadingListPO.getTrucksId(),
				officeLoadingListPO.getCity(),
				officeLoadingListPO.getLocation(),
				officeLoadingListPO.getCarId(),
				officeLoadingListPO.getSupervision(),
				officeLoadingListPO.getEscort(),
				officeLoadingListPO.getShippingId(),
				officeLoadingListPO.getPrice(),
				officeLoadingListPO.getState(),
				officeLoadingListPO.getWriter());
	}
	
	public OfficeLoadingListPO toPO( ){
		return new OfficeLoadingListPO(
 
				getLoadingDate(),
				getOfficeId()
				,getTrucksId(),getCity(),getLocation(),getCarId(),getSupervision(),getEscort()
				,getShippingId(),getPrice(),getState(),writer);
	}
	
	
	@Override
	public String[] names() {
		String[] s = {
				"装车日期","营业厅","汽运编号","出发地","目的地","车号","监装员",
				"司机","物流单号","价格","状态"
		};
	    return s;
	}

}
