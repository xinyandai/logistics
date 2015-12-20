package org.module.client.presentation.orderui;

import org.module.client.main.Main;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.OfficeLoadingListVO;
import org.module.common.po.State;

public class NewOfficeLoadingrListInputFrame extends NewLoadingrListInputFrame{
	
	private static final long serialVersionUID = -692710682551959649L;

	public NewOfficeLoadingrListInputFrame(String[] cities) {
		super(cities);
	}
	
	public NewOfficeLoadingrListInputFrame(String[] cities,
			OfficeLoadingListVO vo) {
		super(cities, vo);
	}

	
	
	public OfficeLoadingListVO getVO(){
		String[] shippingId = shippingId();
		if(shippingId==null) return null;
		return ( 
				new OfficeLoadingListVO(
						DateTransferHelper.getString(timePicker.getDate()), 
				department.getText(), 
				trucksID.getText(), 
				origin.getSelectedItem().toString(),
				target.getSelectedItem().toString(),
				carID.getText(), 
				supervision.getText(),
				driver.getText(), 
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
