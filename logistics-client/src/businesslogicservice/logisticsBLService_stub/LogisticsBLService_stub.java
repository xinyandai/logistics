package businesslogicservice.logisticsBLService_stub;

import java.util.ArrayList;

import po.LogisticsPO;
import vo.LogisticsVO;
import businesslogicservice.logisticsBLservice.LogisticsBLService;

public class LogisticsBLService_stub implements LogisticsBLService{
	LogisticsPO lgpo;
	@Override
	public LogisticsVO showState(String id) {
		// TODO 自动生成的方法存根
		if(id.equals("140010001")){
			lgpo.getLocation();
			System.out.println("state");
		}
		return null;
	}

	@Override
	public boolean setState(String id, String state) {
		// TODO 自动生成的方法存根
		if(id.equals("")){
			lgpo.setLocation(state);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean setState(LogisticsVO o) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean setState(ArrayList<LogisticsVO> al) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean clear() {
		// TODO 自动生成的方法存根
		return false;
	}

}
