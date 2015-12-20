package org.module.client.vo;

import org.module.common.po.State;
import org.module.common.po.TranCenterLoadingListPO;

/**
 * 快递到达把目的地中转中心，同样生成中转中心到达单，再次进行入库管理。
 * 中转中心业务员负责出库、装车，并在系统中录入装车单
 * 装车日期、
 * 本中转中心汽运编号（中转中心编号+日期+0000000七位数字）
 * 到达地（营业厅）、
 * 车辆代号、
 * 监装员、
 * 押运员、
 * 本次装箱所有订单条形码号
 * 运费（运费根据出发地和目的地自动生成）
 * @author 
 *
 */
public class TranCenterLoadingListVO  extends AbstractLoadingListVO{

	
	
	public TranCenterLoadingListVO(String loadingDate, String officeId,
			String trucksId, String city,String location, String carId, String supervision,
			String escort, String[] shippingId, String price,State state,String w) {
		super();
		LoadingDate = loadingDate;
		OfficeId = officeId;
		this.trucksId = trucksId;
		this.city = city;
		this.location = location;
		this.carId = carId;
		Supervision = supervision;
		this.escort = escort;
		this.shippingIds = shippingId;
		this.price = price;
		this.setState(state);
		this.writer = w;
	}
	public TranCenterLoadingListVO(TranCenterLoadingListPO LoadingListPO) {
		this(LoadingListPO.getLoadingDate(),
				LoadingListPO.getOfficeId(),
				LoadingListPO.getTrucksId(),
				LoadingListPO.getCity(),
				LoadingListPO.getLocation(),
				LoadingListPO.getCarId(),
				LoadingListPO.getSupervision(),
				LoadingListPO.getEscort(),
				LoadingListPO.getShippingId(),
				LoadingListPO.getPrice(),
				LoadingListPO.getState(),
				LoadingListPO.getWriter()
				);
	}
	
	public TranCenterLoadingListPO toPO() {
		return new TranCenterLoadingListPO(
				LoadingDate ,
				OfficeId ,
				this.trucksId ,
				this.city ,
				this.location ,
				this.carId ,
				Supervision ,
				this.escort ,
				this.shippingIds ,
				this.price,
				this.state
				,writer
				);
	}
	
	
	@Override
	public String[] names() {
		String[] s = {
				"装车日期","中转中心","汽运编号","出发地","目的地",
				"车号","监装员","司机","物流单号","价格","状态"
		};
		return s;
	}


}
