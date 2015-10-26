package businesslogicservice.ticketBLService_stub;

import java.util.ArrayList;

import vo.GoDownEntryListVO;
import businesslogicservice.ticketBLservice.GoDownEntryBLService;

public class GoDownEntryBLService_stub implements GoDownEntryBLService{

	@Override
	public boolean creatTicket(GoDownEntryListVO t) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean modifyTicket(GoDownEntryListVO newOne) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public ArrayList<GoDownEntryListVO> findTicketByTime(long timeStart,
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
