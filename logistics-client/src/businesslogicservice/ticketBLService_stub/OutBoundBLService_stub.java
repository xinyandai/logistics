package businesslogicservice.ticketBLService_stub;

import java.util.ArrayList;

import vo.OutBoundListVO;
import businesslogicservice.ticketBLservice.OutBoundBLService;

public class OutBoundBLService_stub implements OutBoundBLService{

	@Override
	public boolean creatTicket(OutBoundListVO t) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean modifyTicket(OutBoundListVO newOne) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public ArrayList<OutBoundListVO> findTicketByTime(long timeStart,
			long timeEnd) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean clear() {
		// TODO 自动生成的方法存根
		return false;
	}

}
