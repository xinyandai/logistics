package org.module.client.presentation.orderui;

import org.module.client.main.Main;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.OfficeArrivalListVO;
import org.module.common.po.State;

public class NewOfficeArrivalListInputFrame extends NewArrivalListInputFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4777746654141914472L;
	
	public NewOfficeArrivalListInputFrame(
			OfficeArrivalListVO officeArrivalListVO) {
		super(officeArrivalListVO);
	}
	public NewOfficeArrivalListInputFrame( ) {
	}

	public OfficeArrivalListVO getVO(){
		OfficeArrivalListVO vo = new OfficeArrivalListVO(
				this.deparmentID.getText(),
				DateTransferHelper.getString(this.time.getDate()),
				this.transportID.getText(),
				this.origin.getText(),
				this.stateOfArrival.getSelectedItem().toString(),
				State.SUBMITTED ,Main.currentUser.getId() 
				);
		return vo;
	}
}
