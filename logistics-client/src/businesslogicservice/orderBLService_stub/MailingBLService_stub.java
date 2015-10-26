package businesslogicservice.orderBLService_stub;

import java.util.ArrayList;

import vo.MailingListVO;
import businesslogicservice.orderBLservice.MailingBLService;

public class MailingBLService_stub implements MailingBLService{

	@Override
	public double calculatePrice(MailingListVO m) {
		// TODO 自动生成的方法存根
		System.out.println("price");
		return 0;
	}

	@Override
	public double calculateTime(MailingListVO m) {
		// TODO 自动生成的方法存根
		System.out.println("time");
		return 0;
	}

	@Override
	public boolean creat(MailingListVO o) {
		// TODO 自动生成的方法存根
		System.out.println("mail");
		return false;
	}

	@Override
	public ArrayList<MailingListVO> getAll() {
		// TODO 自动生成的方法存根
		return null;
	}

}
