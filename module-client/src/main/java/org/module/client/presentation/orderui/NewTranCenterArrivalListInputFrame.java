package org.module.client.presentation.orderui;

import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.OfficeArrivalListVO;
import org.module.client.vo.TranCenterArrivalListVO;
import org.module.common.po.State;

public class NewTranCenterArrivalListInputFrame extends
		NewArrivalListInputFrame {

	private static final long serialVersionUID = -7832455721055893566L;

	public NewTranCenterArrivalListInputFrame(
			TranCenterArrivalListVO officeArrivalListVO) {
		super(officeArrivalListVO);
	}
	public NewTranCenterArrivalListInputFrame(
			 ) {
	}
	public TranCenterArrivalListVO getVO(){
		TranCenterArrivalListVO vo = new TranCenterArrivalListVO(
				this.deparmentID.getText(),
				DateTransferHelper.getString(this.time.getDate()),
				this.transportID.getText(),
				this.origin.getText(),
				this.stateOfArrival.getSelectedItem().toString(),
				State.SUBMITTED
				);
		return vo;
	}
}
