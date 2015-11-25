package org.module.client.businesslogicservice.logisticsBLService_stub;


import org.module.client.businesslogicservice.logisticsBLservice.LogisticsBLService;
import org.module.client.vo.LogisticsVO;


public class LogisticsBLService_stub implements LogisticsBLService{
	LogisticsVO lgpo;
	public LogisticsVO showState(String id) {
		// TODO �Զ����ɵķ������
		if(id.equals("140010001")){
			lgpo.getLocation();
			System.out.println("state");
		}
		return null;
	}

	public boolean setState(String id, String state) {
		// TODO �Զ����ɵķ������
		if(id.equals("")){
			lgpo.setLocation(state);
			return true;
		}else{
			return false;
		}
	}

	public boolean setState(String origin, String estination,
			String location,String orderId, String[] historyLocation,String[] historyTime) {
		// TODO �Զ����ɵķ������
		return false;
	}

}
