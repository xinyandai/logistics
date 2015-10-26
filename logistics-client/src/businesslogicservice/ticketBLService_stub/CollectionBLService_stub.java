package businesslogicservice.ticketBLService_stub;

import java.util.ArrayList;

import vo.ReceiptListVO;
import businesslogicservice.ticketBLservice.CollectionBLService;

public class CollectionBLService_stub implements CollectionBLService{

	@Override
	public boolean creatTicket(ReceiptListVO t) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean modifyTicket(ReceiptListVO newOne) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public ArrayList<ReceiptListVO> findTicketByTime(long timeStart,
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
