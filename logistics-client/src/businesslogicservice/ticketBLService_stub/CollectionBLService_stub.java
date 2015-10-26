package businesslogicservice.ticketBLService_stub;

import java.util.ArrayList;

import po.ReceiptListPO;
import vo.ReceiptListVO;
import businesslogicservice.ticketBLservice.CollectionBLService;

public class CollectionBLService_stub implements CollectionBLService{
	ReceiptListPO rlpo;
	@Override
	public boolean createTicket(ReceiptListVO t) {
		// TODO 自动生成的方法存根
		System.out.println("createTicket");
		return false;
	}

	@Override
	public boolean modifyTicket(ReceiptListVO newOne) {
		// TODO 自动生成的方法存根
		System.out.println("modifyTicket");
		return false;
	}

	@Override
	public ArrayList<ReceiptListVO> findTicketByTime(long timeStart,
			long timeEnd) {
		// TODO 自动生成的方法存根
		System.out.println("findTicket");
		return null;
	}

	@Override
	public boolean clear() {
		// TODO 自动生成的方法存根
		System.out.println("clear Ticket");
		return false;
	}

}
