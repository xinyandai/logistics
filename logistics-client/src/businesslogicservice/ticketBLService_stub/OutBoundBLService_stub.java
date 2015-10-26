package businesslogicservice.ticketBLService_stub;

import java.util.ArrayList;

import po.OutBoundListPO;
import vo.OutBoundListVO;
import businesslogicservice.ticketBLservice.OutBoundBLService;

public class OutBoundBLService_stub implements OutBoundBLService{
	OutBoundListPO oblpo;
	@Override
	public boolean createTicket(OutBoundListVO t) {
		// TODO 自动生成的方法存根
		System.out.println("OutBound");
		return false;
	}

	@Override
	public boolean modifyTicket(OutBoundListVO newOne) {
		// TODO 自动生成的方法存根
		System.out.println("OutBound");
		return false;
	}

	@Override
	public ArrayList<OutBoundListVO> findTicketByTime(long timeStart,
			long timeEnd) {
		// TODO 自动生成的方法存根
		System.out.println("OutBound");
		return null;
	}

	@Override
	public boolean clear() {
		// TODO 自动生成的方法存根
		System.out.println("OutBound");
		return false;
	}

}
