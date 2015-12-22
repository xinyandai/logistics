package org.module.client.presentation.orderui;

import org.module.client.main.Main;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.TranCenterLoadingListVO;
import org.module.common.po.State;

public class NewTranCenterLoadingrListInputFrame extends NewLoadingrListInputFrame {

	
	private static final long serialVersionUID = 3576753507697968924L;

	public NewTranCenterLoadingrListInputFrame(String[] cities) {
		super(cities);
	}

	public NewTranCenterLoadingrListInputFrame(String[] cities,
			TranCenterLoadingListVO vo) {
		super(cities, vo);
	}

	public TranCenterLoadingListVO getVO(){
		String[] shippingId = shippingId();
		if(shippingId==null) return null;
		return ( 
				new TranCenterLoadingListVO(
						DateTransferHelper.getString(timePicker.getDate()),
				department.getText(), 
				trucksID.getText(), 
				origin.getSelectedItem().toString(),
				target.getSelectedItem().toString(),
				carID.getText(), 
				supervision.getText(),
				driver.getSelectedItem().toString(), 
				shippingId, 
				price.getText(),
				State.SUBMITTED ,Main.currentUser.getId() 
				)
				);
	}
	
	public boolean isDataUsable(){
		String[] shippingId = shippingId();
		return shippingId!=null;
	}
}
